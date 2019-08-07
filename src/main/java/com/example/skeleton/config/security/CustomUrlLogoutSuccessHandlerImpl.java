package com.example.skeleton.config.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.skeleton.common.basicMethod.WrapMapper;
import com.example.skeleton.domain.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author yebing
 */
public class CustomUrlLogoutSuccessHandlerImpl extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("Logout System!");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String jsonString = JSONObject.toJSONString(WrapMapper.ok().result("退出成功！"));
        out.write(jsonString);
        out.flush();
        out.close();
    }
}
