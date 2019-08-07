package com.example.skeleton.common.basicMethod;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao层增删查改基础服务
 *
 * @param <E>
 */
public interface BasicDao<E extends BasicDTO> {
    /**
     * 插入实体
     * @param record
     * @return
     */
    Integer insert(E record);

    /**
     * 根据主键删除实体
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * 可选参数插入实体
     * @param record
     * @return
     */
    Integer insertSelective(E record);

    /**
     * 批量插入实体
     * @param records
     * @return
     */
    Integer batchSave(@Param("records") List<E> records);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    E selectByPrimaryKey(Long id);

    /**
     * 根据参数查询列表
     * @param record
     * @param pager
     * @return
     */
    List<E> selectList(@Param("record") E record, @Param("pager") Pager pager);

    /**
     * 根据参数查询列表统计
     * @param record
     * @return
     */
    Long countTotal(@Param("record") E record);

    /**
     * 根据主键更新实体指定参数
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(E record);

    /**
     * 根据主键更新实体
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(E record);
}

