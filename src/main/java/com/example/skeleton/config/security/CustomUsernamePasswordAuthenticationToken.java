package com.example.skeleton.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private Object loginType;

    public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials, Object loginType) {
        super(principal,credentials);
        this.loginType = loginType;
    }

    public Object getLoginType() {
        return loginType;
    }
}
