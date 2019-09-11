package com.example.skeleton.config.security;

import com.example.skeleton.common.Role;
import com.example.skeleton.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.List;

/**
 * @author yebing
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private CustomAuthenticationFilter customAuthenticationFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().maximumSessions(1).expiredUrl("/front/html/login.html");
        http
                .cors().and()
                .authorizeRequests()                         //授权配置
                .antMatchers("/**").permitAll()
                .antMatchers("/timer/**").permitAll()
                .antMatchers("/user/selectOne").hasRole(Role.USER)
                .antMatchers("/admin/languageClassificationController/**").hasAnyRole(Role.ADMIN,Role.USER)
                .antMatchers("/admin/**").hasRole(Role.ADMIN)
                .anyRequest()     // 所有请求
                .authenticated(); // 所有请求都进行权限

        http
                .formLogin()
                .loginPage("/front/html/login.html")
                .and()
                .csrf().disable();


        http
                .logout()
                //自定义登出api，无需自己实现
                .logoutUrl("/logout")
                .logoutSuccessUrl("/front/html/login.html")
                .permitAll()
                .invalidateHttpSession(true);

        /*权限认证*/
        http.authenticationProvider(this.authenticationProvider());
        http
                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //自定义登录退出处理器
        http.logout().logoutSuccessHandler(new CustomUrlLogoutSuccessHandlerImpl());

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }

    @Bean(name = "authenticationManager")
    public AuthenticationManager createAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 自定义登录拦截过滤器，不包含密码校验等
     * @return
     * @throws Exception
     */
/*    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(createAuthenticationManager());
        return filter;
    }*/

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        return mappingJackson2HttpMessageConverter;
    }

    @AutoConfigureAfter(WebSecurityConfiguration.class)
    @Configuration
    public static class show {

        @Resource(name = "springSecurityFilterChain")
        private Filter springSecurityFilterChain;

        @Bean
        public Object object() {
            System.out.println(springSecurityFilterChain);
            return new Object();
        }
    }
}
