package com.hack.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author lnurullina
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {
    private String responseData;
    private String error;

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
