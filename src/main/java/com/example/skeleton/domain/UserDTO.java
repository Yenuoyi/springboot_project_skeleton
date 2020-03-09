package com.example.skeleton.domain;

import com.example.skeleton.common.basicMethod.BasicDTO;

import java.io.Serializable;

/**
 * demo dto
 */
public class UserDTO extends BasicDTO implements Serializable {
    private String name;

    private String password;

    private String weChatId;

    private Integer type;
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

    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
