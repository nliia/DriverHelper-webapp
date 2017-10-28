package com.hack.service.impl;

import com.hack.dto.AuthResponse;
import com.hack.dto.Dtp;
import com.hack.dto.DtpListResponse;
import com.hack.dto.DtpResponse;
import com.hack.util.RestUrl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

/**
 * @author lnurullina
 */
@Service
public class DtpServiceImpl {
    private RestTemplate restTemplate;

    DtpServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Dtp> getDtps() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", (String) SecurityContextHolder.getContext().getAuthentication().getCredentials());
        HttpEntity request = new HttpEntity(httpHeaders);
        DtpListResponse response = null;
        try {
            response = restTemplate.exchange(RestUrl.GET_UNFINISHED_METHOD.getUrl(), HttpMethod.GET, request, DtpListResponse.class).getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "AAAAAAAAA");
        }

        Collection<Dtp> readValues = null;

        return response.getResponseData();
    }

    public Dtp getDtp(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", (String) SecurityContextHolder.getContext().getAuthentication().getCredentials());
        HttpEntity request = new HttpEntity<>(httpHeaders);
        DtpResponse response = null;
        try {

            response = restTemplate.exchange(RestUrl.GET_DTP_METHOD.getUrl(), HttpMethod.GET, request, DtpResponse.class, id).getBody();
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage() + e.getResponseBodyAsString() +"AAAAAAAAAAA");
        }
        return response.getResponseData();
    }

    public void closeDtp(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", (String) SecurityContextHolder.getContext().getAuthentication().getCredentials());
        HttpEntity request = new HttpEntity<>(httpHeaders);
        AuthResponse response = null;
        try {

            response = restTemplate.exchange(RestUrl.GET_CLOSE_METHOD.getUrl(), HttpMethod.POST, request, AuthResponse.class, id).getBody();
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage() + e.getResponseBodyAsString() +"AAAAAAAAAAA");
        }
    }

    public List<Dtp> getArchivedDtps() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", (String) SecurityContextHolder.getContext().getAuthentication().getCredentials());
        HttpEntity request = new HttpEntity(httpHeaders);
        DtpListResponse response = null;
        try {
            response = restTemplate.exchange(RestUrl.GET_FINISHED_METHOD.getUrl(), HttpMethod.GET, request, DtpListResponse.class).getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "AAAAAAAAA");
        }

        return response.getResponseData();
    }
}
