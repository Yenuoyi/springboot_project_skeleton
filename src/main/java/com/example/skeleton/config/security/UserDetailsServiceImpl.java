package com.example.skeleton.config.security;

import com.example.skeleton.dao.UserDao;
import com.example.skeleton.domain.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 功能：动态获取用户账号密码认证
 * @Author Created by yebing
 * @Date 2018/8/12 22:05
 * @Version 1.0.0
 */
@Component("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;
    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("开始处理用户信息！");
        //GrantedAuthority是security提供的权限类，
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        String password = null;

        UserDTO record = new UserDTO();
        record.setName(username);
        List<UserDTO> userDTOList = userDao.selectList(record, null);
        /* 数据库有账号*/
        if(userDTOList.size()!=0 ){
            record = userDTOList.get(0);
            this.getUserRoles(record,auths);
            password = record.getPassword();
            logger.info("数据库密码："+record.getName());
        }else{
            throw new UsernameNotFoundException("用户" + username + "不存在");
        }
        //返回包括权限角色的User给security
        return new User(username, password, true, true, true, true, auths);
    }

    public void getUserRoles(UserDTO adminInfoDTO,List<GrantedAuthority> list){
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    public static void main(String[] args){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.print("当前时间："+format.format(calendar.getTime()));


//        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        System.out.print("当前月开始时间："+format.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);

        Date m = calendar.getTime();
        String mon = format.format(m);
        System.out.println("下个月开始时间："+mon);
    }
}
