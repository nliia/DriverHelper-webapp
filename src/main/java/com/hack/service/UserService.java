package com.hack.service;

import com.hack.dto.AuthResponse;
import com.hack.dto.SignUpRequest;

/**
 * @author lnurullina
 */
public interface UserService {
    AuthResponse signUp(SignUpRequest signUpRequest);

    AuthResponse signIn(String email, String password);
}
