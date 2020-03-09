package com.example.skeleton.config.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.skeleton.common.Role;
import com.example.skeleton.common.encrypt.Md5Util;
import com.example.skeleton.common.util.HttpUtil;
import com.example.skeleton.dao.UserDao;
import com.example.skeleton.domain.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义用户账号密码登录拦截器
 * @author yebing
 */
@Component
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private UserDao userDao;
    @Value("${app.id}")
    private String appId;
    @Value("${app.secret}")
    private String appSecret;
    @Value("${wechat.auth.code2Session.URL}")
    private String code2SessionUrl;
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private AuthenticationFailureHandlerImpl authenticationFailureHandler;
    @Resource
    private AuthenticationManager authenticationManager;
    public CustomUsernamePasswordAuthenticationFilter(){
        this.setFilterProcessesUrl("/user/onLogin");
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
                if ("weChat".equals(authenticationBean.getLoginType())){
                    weChatLoin(authenticationBean);
                    CustomUsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new CustomUsernamePasswordAuthenticationToken(
                            authenticationBean.getUsername(), authenticationBean.getPassword(),"weChat");
                    authRequest = usernamePasswordAuthenticationToken;
                }else{
                    authRequest = new UsernamePasswordAuthenticationToken(
                            authenticationBean.getUsername(), authenticationBean.getPassword());
                }

                logger.info("用户登录信息："+ JSON.toJSONString(authenticationBean));
            }catch (IOException e) {
                e.printStackTrace();
                authRequest = new UsernamePasswordAuthenticationToken(
                        "", "");
            }finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }
        else {
            return super.attemptAuthentication(request, response);
        }
    }

    public void setDetails(HttpServletRequest request, CustomUsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    @Override
    public void afterPropertiesSet(){
        this.setAuthenticationManager(authenticationManager);
        super.afterPropertiesSet();
        this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        this.setAuthenticationFailureHandler(authenticationFailureHandler);
    }

    private void weChatLoin(AuthenticationBean authenticationBean){
        String code2SessionRes = HttpUtil.doGet(code2SessionUrl+"?appid="+appId+"&secret="+appSecret+"&js_code="+authenticationBean.getCode()+"&grant_type=authorization_code", null);
        JSONObject resObject = JSON.parseObject(code2SessionRes);
        /* 判断微信登录是否成功 */
        if (StringUtils.isEmpty(resObject.getString("errcode"))){
            String openid = resObject.getString("openid");
            String sessionKey = resObject.getString("session_key");
            UserDTO userDTO = new UserDTO();
            userDTO.setWeChatId(openid);
            List<UserDTO> userDTOList = userDao.selectList(userDTO, null);
            // 为空则新注册账号，否则则登录成功
            if (CollectionUtils.isEmpty(userDTOList)){

            }else{
                UserDTO realUser = userDTOList.get(0);
                authenticationBean.setUsername(realUser.getName());
                authenticationBean.setRole(Role.ADMIN.getName());
            }
        }

    }
}
