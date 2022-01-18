package es.sergiomendez.obfcheadhuntingjava.controllers;

import es.sergiomendez.obfcheadhuntingjava.dto.LoginRequest;
import es.sergiomendez.obfcheadhuntingjava.dto.MessageResponse;
import es.sergiomendez.obfcheadhuntingjava.dto.RegisterRequest;
import es.sergiomendez.obfcheadhuntingjava.services.auth.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest signUpRequest) {

        return authService.register(signUpRequest);
    }
}