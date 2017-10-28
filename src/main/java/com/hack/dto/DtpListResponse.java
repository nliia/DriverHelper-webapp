package com.hack.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author lnurullina
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class DtpListResponse {
    private List<Dtp> responseData;
    private String error;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public List<Dtp> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<Dtp> responseData) {
        this.responseData = responseData;
    }
}
