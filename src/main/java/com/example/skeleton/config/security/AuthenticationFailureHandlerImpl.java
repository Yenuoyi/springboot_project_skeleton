package com.example.skeleton.config.security;

import com.alibaba.fastjson.JSONObject;
import com.example.skeleton.common.basicMethod.WrapMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@Component("authenticationFailureHandler")
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        logger.info("登录失败！");
        PrintWriter out = httpServletResponse.getWriter();
        String jsonString = JSONObject.toJSONString(WrapMapper.error().result("账号或密码错误！"));
        out.write(jsonString);
        out.flush();
        out.close();
    }
}
