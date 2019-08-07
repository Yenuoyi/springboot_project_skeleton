package com.example.skeleton.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yebing
 */
@Component
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private AuthenticationFailureHandlerImpl authenticationFailureHandler;
    @Resource
    private AuthenticationManager authenticationManager;
    public CustomAuthenticationFilter(){
        this.setFilterProcessesUrl("/user/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.info("this is filter!");
        //attempt Authentication when Content-Type is json
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                ||request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){

            //use jackson to deserialize json
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()){
                AuthenticationBean authenticationBean = mapper.readValue(is,AuthenticationBean.class);
                authRequest = new UsernamePasswordAuthenticationToken(
                        authenticationBean.getUsername(), authenticationBean.getPassword());
                logger.info("用户登录信息：账号："+authenticationBean.getUsername()+"   密码："+authenticationBean.getPassword());
            }catch (IOException e) {
                e.printStackTrace();
                authRequest = new UsernamePasswordAuthenticationToken(
                        "", "");
            }finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }

        //transmit it to UsernamePasswordAuthenticationFilter
        else {
            return super.attemptAuthentication(request, response);
        }
    }

    @Override
    public void afterPropertiesSet(){
        this.setAuthenticationManager(authenticationManager);
        super.afterPropertiesSet();
        this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        this.setAuthenticationFailureHandler(authenticationFailureHandler);
    }
}