package com.hack.service;

import com.hack.dto.AuthResponse;
import com.hack.dto.SignUpRequest;
import org.springframework.http.ResponseEntity;

/**
 * @author lnurullina
 */
public interface UserService {
    ResponseEntity<AuthResponse> signUp(SignUpRequest signUpRequest);

    ResponseEntity<AuthResponse> signIn(String email, String password);
}
