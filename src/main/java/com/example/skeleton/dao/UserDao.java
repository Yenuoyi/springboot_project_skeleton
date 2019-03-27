package com.example.skeleton.dao;

import com.example.skeleton.common.basicMethod.BasicDao;
import com.example.skeleton.domain.UserDTO;
import org.springframework.stereotype.Repository;

/**
 * demo dao
 */
@Repository
public interface UserDao<T> extends BasicDao<UserDTO> {
}
