package com.example.skeleton.service;

import com.example.skeleton.common.basicMethod.BasicService;
import com.example.skeleton.dao.UserDao;
import com.example.skeleton.domain.UserDTO;

public interface UserService extends BasicService<UserDao,UserDTO> {
    /**
     * 通过用户名查询
     * @param name
     * @return
     */
    UserDTO selectOneByName(String name);
}
