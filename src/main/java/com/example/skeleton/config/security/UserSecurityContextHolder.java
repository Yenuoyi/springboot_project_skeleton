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
    public static UserDetails getUserDetails() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
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

    public static int getUserId(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getSession().getAttribute("id").toString());
        return id;
    }
}
