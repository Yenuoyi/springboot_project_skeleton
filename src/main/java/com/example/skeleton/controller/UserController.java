package com.example.skeleton.controller;

import com.example.skeleton.common.basicMethod.ExecuteResult;
import com.example.skeleton.common.basicMethod.WrapMapper;
import com.example.skeleton.common.basicMethod.Wrapper;
import com.example.skeleton.common.basicMethod.BasicController;
import com.example.skeleton.domain.UserDTO;
import com.example.skeleton.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 * @author yebing
 */
@RestController
@Api(description = "用户控制器")
@RequestMapping("/user")
public class UserController extends BasicController<UserService,UserDTO> {
    @RequestMapping(value = "/selectOne",method={RequestMethod.POST})
    public Wrapper<?> selectOne(@RequestBody UserDTO record){
        ExecuteResult<UserDTO> executeResult = basicService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
