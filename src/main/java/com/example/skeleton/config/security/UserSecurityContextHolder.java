package com.example.skeleton.config.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yebing
 */
@Component("userSecurityContextHolder")
public class UserSecurityContextHolder {
    public static UserDetailImpl getUserDetails() {
        UserDetailImpl userDetails = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails;
    }

    public static String getUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        return username;
    }

    public static Long getUserId() {
        long id = getUserDetails().getUserId();
        return id;
    }
}
