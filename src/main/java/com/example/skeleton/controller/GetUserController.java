package com.example.skeleton.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.skeleton.common.basicMethod.WrapMapper;
import com.example.skeleton.common.basicMethod.Wrapper;
import com.example.skeleton.config.security.UserSecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yebing
 */
@RestController
@RequestMapping("/user")
public class GetUserController {
    /**
     * @return
     */
    @GetMapping("/detail")
    public Wrapper<?> executeStatisticsBug(){
        System.out.print(JSONObject.toJSONString(UserSecurityContextHolder.getUserDetails()));
        return WrapMapper.ok();
    }
}
