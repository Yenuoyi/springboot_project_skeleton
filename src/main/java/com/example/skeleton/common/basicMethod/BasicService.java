package com.example.skeleton.common.basicMethod;

import java.util.List;

/**
 * service基础增删查改
 *
 * @param <D>
 */
public interface BasicService<D extends BasicDao,E extends BasicDTO> {
    /**
     * 根据主键删除实体
     *
     * @param id
     * @return
     */
    ExecuteResult<Integer> deleteByPrimaryKey(E record);

    /**
     * 插入实体
     *
     * @param record
     * @return
     */
    ExecuteResult<Integer> insert(E record);

    /**
     * 可选参数插入实体
     *
     * @param record
     * @return
     */
    ExecuteResult<Integer> insertSelective(E record);

    /**
     * 批量插入实体
     *
     * @param records
     * @return
     */
    ExecuteResult<Integer> batchSave(List<E> records);

    /**
     * 根据主键查询
     *
     * @param record
     * @return
     */
    ExecuteResult<E> selectByPrimaryKey(E record);

    /**
     * 根据参数查询列表
     *
     * @param record
     * @param pager
     * @return
     */
    ExecuteResult<DataUtil<E>> selectList(E record, Pager pager);

    /**
     * 根据主键更新实体指定参数
     *
     * @param record
     * @return
     */
    ExecuteResult<Integer> updateByPrimaryKeySelective(E record);

    /**
     * 根据主键更新实体
     *
     * @param record
     * @return
     */
    ExecuteResult<Integer> updateByPrimaryKey(E record);

}
