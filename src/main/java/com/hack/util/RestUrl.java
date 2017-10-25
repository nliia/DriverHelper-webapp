package com.hack.util;

/**
 * @author lnurullina
 */
public enum RestUrl {

    SIGN_UP_METHOD ("https://dtp-hack.herokuapp.com/v1/sign_up"),
    SIGN_IN_METHOD ("https://dtp-hack.herokuapp.com/v1/sign_in");

    private final String url;

    RestUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
