package com.example.skeleton.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

/**
 * 认证完成后写入Spring Security的SecurityContextHolder的用户信息实体
 * @author yebing
 */
public class UserDetailImpl extends User {
    private final String token;
    private final Long userId;
    public UserDetailImpl(String username, String password, String token, Long userId, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.token = token;
        this.userId = userId;
    }

    public UserDetailImpl(String username, String password, String token, Long userId, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }
}
