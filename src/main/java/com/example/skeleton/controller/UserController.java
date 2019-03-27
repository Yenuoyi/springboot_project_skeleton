package com.example.skeleton.controller;

import com.example.skeleton.common.basicMethod.BasicController;
import com.example.skeleton.dao.UserDao;
import com.example.skeleton.domain.UserDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 */
@RestController
@Api(description = "用户控制器")
public class UserController extends BasicController<UserDao, UserDTO> {
}
