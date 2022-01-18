package es.sergiomendez.obfcheadhuntingjava.services.auth;

import es.sergiomendez.obfcheadhuntingjava.dto.LoginRequest;
import es.sergiomendez.obfcheadhuntingjava.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> register(RegisterRequest signUpRequest);
    ResponseEntity<?> login(LoginRequest loginRequest);
}
