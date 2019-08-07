package com.example.skeleton.service.impl;

import com.example.skeleton.common.basicMethod.BasicDao;
import com.example.skeleton.common.basicMethod.BasicServiceImpl;
import com.example.skeleton.dao.UserDao;
import com.example.skeleton.domain.UserDTO;
import com.example.skeleton.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BasicServiceImpl<UserDao,UserDTO> implements UserService {
    @Override
    public UserDTO selectOneByName(String name) {
        UserDTO userDTO = basicDao.selectOneByName(name);
        return userDTO;
    }
}
