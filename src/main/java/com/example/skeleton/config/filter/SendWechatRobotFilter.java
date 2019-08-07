package com.example.skeleton.config.filter;

import com.alibaba.fastjson.JSON;
import com.example.skeleton.common.basicMethod.WrapMapper;
import com.example.skeleton.domain.UserDTO;
import com.example.skeleton.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author yebing
 */
@WebFilter(filterName = "sendWechatRobotFilter", urlPatterns = {"/timer/wechatRobot/**"})
public class SendWechatRobotFilter implements Filter {
    @Resource
    private UserService userService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        String password = servletRequest.getParameter("password");
        OutputStream out = servletResponse.getOutputStream();
        servletResponse.setContentType("application/json; charset=utf-8");
        servletResponse.setCharacterEncoding("UTF-8");
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            out.write(JSON.toJSONString(WrapMapper.error().message("用户名或密码不允许为空")).getBytes("UTF-8"));
            out.flush();
            out.close();
            return;
        }
        UserDTO userDTO = userService.selectOneByName(name);
        if (userDTO == null){
            out.write(JSON.toJSONString(WrapMapper.error().message("查无此用户！")).getBytes("UTF-8"));
            out.flush();
            out.close();
            return;
        }
        if (!userDTO.getPassword().equals(password)){
            out.write(JSON.toJSONString(WrapMapper.error().message("密码错误！")).getBytes("UTF-8"));
            out.flush();
            out.close();
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
