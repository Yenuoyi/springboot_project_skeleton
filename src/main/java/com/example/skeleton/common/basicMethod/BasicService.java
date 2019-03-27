package com.example.skeleton.common.basicMethod;

import com.example.skeleton.common.DataUtil;
import com.example.skeleton.common.ExecuteResult;
import com.example.skeleton.common.Pager;

import java.util.List;

/**
 * service基础增删查改
 * @param <T>
 * @param <D>
 */
public interface BasicService<T extends BasicDao,D extends BasicDTO> {
    ExecuteResult<Integer> deleteByPrimaryKey(D record);

    ExecuteResult<Integer> insert(D record);

    ExecuteResult<Integer> insertSelective(D record);

    ExecuteResult<Integer> batchSave(List<D> records);

    ExecuteResult<D> selectByPrimaryKey(D record);

    ExecuteResult<DataUtil<D>> selectList(D record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(D record);

    ExecuteResult<Integer> updateByPrimaryKey(D record);

}
