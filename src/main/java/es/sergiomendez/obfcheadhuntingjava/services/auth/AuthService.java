package es.sergiomendez.obfcheadhuntingjava.services.auth;

import es.sergiomendez.obfcheadhuntingjava.security.payload.LoginRequest;
import es.sergiomendez.obfcheadhuntingjava.security.payload.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> register(RegisterRequest signUpRequest);
    ResponseEntity<?> login(LoginRequest loginRequest);
}
