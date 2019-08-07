package com.example.skeleton.dao;

import com.example.skeleton.common.basicMethod.BasicDao;
import com.example.skeleton.domain.UserDTO;
import org.springframework.stereotype.Repository;

/**
 * demo dao
 * @author yebing
 */
@Repository
public interface UserDao extends BasicDao<UserDTO>  {
    /**
     * 通过用户名查询
     * @param name
     * @return
     */
    UserDTO selectOneByName(String name);
}
