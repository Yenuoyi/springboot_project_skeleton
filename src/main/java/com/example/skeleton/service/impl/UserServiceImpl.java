package com.example.skeleton.service.impl;

import com.example.skeleton.common.basicMethod.BasicServiceImpl;
import com.example.skeleton.dao.UserDao;
import com.example.skeleton.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl<T extends UserDao,D extends UserDao> extends BasicServiceImpl implements UserService {
}
