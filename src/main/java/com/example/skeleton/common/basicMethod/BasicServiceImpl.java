package com.example.skeleton.common.basicMethod;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * service基础增删查改
 * @author yebing
 * @param <D>
 */
public class BasicServiceImpl<D extends BasicDao,E extends BasicDTO> implements BasicService<D,E> {
    protected Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    protected D basicDao;

    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(E record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if (StringUtils.isEmpty(record.getId())) {
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = basicDao.deleteByPrimaryKey(record.getId());
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e);
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> insert(E record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if (StringUtils.isEmpty(record)) {
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = basicDao.insert(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> insertSelective(E record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if (StringUtils.isEmpty(record)) {
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = basicDao.insertSelective(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> batchSave(List<E> record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if (StringUtils.isEmpty(record)) {
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = basicDao.batchSave(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<E> selectByPrimaryKey(E record) {
        ExecuteResult<E> executeResult = new ExecuteResult<E>();
        try {
            if (StringUtils.isEmpty(record.getId())) {
                throw new RuntimeException("参数错误：ID非空");
            }
            E result = (E) basicDao.selectByPrimaryKey(record.getId());
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }


    @Override
    public ExecuteResult<DataUtil<E>> selectList(E record, Pager pager) {
        ExecuteResult<DataUtil<E>> executeResult = new ExecuteResult<DataUtil<E>>();
        try {
            if (StringUtils.isEmpty(record)) {
                throw new RuntimeException("参数错误：对象非空");
            }
            List<E> result = basicDao.selectList(record, pager);
            Integer total = basicDao.countTotal(record).intValue();
            DataUtil<E> dtoDataUtil = new DataUtil<E>();
            dtoDataUtil.setList(result);
            dtoDataUtil.getPager().setTotalCount(total);
            executeResult.setResult(dtoDataUtil);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e);
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> updateByPrimaryKeySelective(E record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if (StringUtils.isEmpty(record.getId())) {
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = basicDao.updateByPrimaryKeySelective(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e);
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> updateByPrimaryKey(E record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if (StringUtils.isEmpty(record.getId())) {
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = basicDao.updateByPrimaryKey(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        } catch (Exception e) {
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e);
        }
        return executeResult;
    }
}
