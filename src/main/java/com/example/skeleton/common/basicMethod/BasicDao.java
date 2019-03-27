package com.example.skeleton.common.basicMethod;

import com.example.skeleton.common.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * dao层增删查改基础服务
 * @param <T>
 */
public interface BasicDao<T extends BasicDTO> {
    Integer deleteByPrimaryKey(Long id);

    Integer insert(T record);

    Integer insertSelective(T record);

    Integer batchSave(@Param("records") List<T> records);

    T selectByPrimaryKey(Long id);

    List<T> selectList(@Param("record") T record, @Param("pager") Pager pager);

    Long countTotal(@Param("record") T record);

    Integer updateByPrimaryKeySelective(T record);

    Integer updateByPrimaryKey(T record);
}
