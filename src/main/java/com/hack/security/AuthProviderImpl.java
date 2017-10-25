package com.hack.security;

import com.hack.dto.AuthResponse;
import com.hack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lnurullina
 */
@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserService userService;

    @Autowired
    public AuthProviderImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String psw = authentication.getCredentials().toString();
        ResponseEntity<AuthResponse> authResponse = userService.signIn(email, psw);
        if (authResponse.getBody().getError() != null) {
            throw new BadCredentialsException(authResponse.getBody().getError());
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        System.out.println(authResponse.getBody().getResponseData() + " aaaaaaaaaaaaaaa");
        return new UsernamePasswordAuthenticationToken(email, authResponse.getBody().getResponseData(), authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}