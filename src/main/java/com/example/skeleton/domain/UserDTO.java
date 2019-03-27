package com.example.skeleton.domain;

import com.example.skeleton.common.basicMethod.BasicDTO;

import java.io.Serializable;

/**
 * demo dto
 */
public class UserDTO extends BasicDTO implements Serializable {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
