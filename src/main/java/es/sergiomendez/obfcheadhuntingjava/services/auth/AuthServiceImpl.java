package es.sergiomendez.obfcheadhuntingjava.services.auth;

import es.sergiomendez.obfcheadhuntingjava.entities.User;
import es.sergiomendez.obfcheadhuntingjava.repositories.UserRepository;
import es.sergiomendez.obfcheadhuntingjava.security.jwt.JwtTokenUtil;
import es.sergiomendez.obfcheadhuntingjava.dto.JwtResponse;
import es.sergiomendez.obfcheadhuntingjava.dto.LoginRequest;
import es.sergiomendez.obfcheadhuntingjava.dto.MessageResponse;
import es.sergiomendez.obfcheadhuntingjava.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthServiceImpl(AuthenticationManager authManager,
                           UserRepository userRepository,
                           PasswordEncoder encoder,
                           JwtTokenUtil jwtTokenUtil){
        this.authManager = authManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public ResponseEntity<?> login(LoginRequest loginRequest){

        String email = loginRequest.getEmail();

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenUtil.generateJwtToken(authentication);

            // UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponse(jwt));
        }


        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Email is not registered!"));
    }

    public ResponseEntity<MessageResponse> register(RegisterRequest signUpRequest) {

        // Check 1: username
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Check 2: email
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getEmail(),
                signUpRequest.getFullname());

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}