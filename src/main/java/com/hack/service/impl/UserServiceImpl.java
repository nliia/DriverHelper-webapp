package com.hack.service.impl;

import com.hack.dto.AuthResponse;
import com.hack.dto.SignInRequest;
import com.hack.dto.SignUpRequest;
import com.hack.service.UserService;
import com.hack.util.RestUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lnurullina
 */
@Service
public class UserServiceImpl implements UserService {
    private RestTemplate restTemplate;

    @Autowired
    UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        HttpEntity<SignUpRequest> request = new HttpEntity<>(signUpRequest);
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.exchange(RestUrl.SIGN_UP_METHOD.getUrl(), HttpMethod.POST, request, AuthResponse.class).getBody();
    }

    @Override
    public AuthResponse signIn(String email, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity<SignInRequest> request = new HttpEntity<>(new SignInRequest(email, password), headers);
        return restTemplate.postForEntity(RestUrl.SIGN_IN_METHOD.getUrl(), request, AuthResponse.class).getBody();

    }
}
