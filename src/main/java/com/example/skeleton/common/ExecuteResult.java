package com.example.skeleton.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行结果信息类，用于封装增删改方法的结果信息 失败时必须将错误信息设置到errorMessages中
 */
public class ExecuteResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执行成功返回结果集
     */
    private T result;
    /**
     * 执行成功结果信息
     */
    private String resultMessage;
    /**
     * 调用失败时，返回的错误集合
     */
    private List<String> errorMessages = new ArrayList<String>();

    /**
     * 存入错误信息
     */
    @Deprecated
    public void addErrorMsg(String errorMsg) {
        errorMessages.add(errorMsg);
    }

    /**
     * 判断执行是否成功
     *
     * @return true:成功 false:失败
     */
    public boolean isSuccess() {
        return errorMessages.isEmpty() ? true : false;
    }

    /**
     * 获取执行成功返回的结果集
     *
     * @return T 返回结果
     */
    public T getResult() {
        return result;
    }

    /**
     * 执行成功时，设置返回结果集
     *
     * @param result 结果集
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 获取执行成功返回信息
     *
     * @return 返回信息
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * 执行成功时，设置返回信息
     *
     * @param resultMessage 返回信息
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * 获取错误信息列表
     *
     * @return 错误信息列表
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * 设置错误信息
     *
     * @param errorMessages 错误信息列表
     */
    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * 添加单个错误信息
     *
     * @param errorMessage 错误信息
     */
    public void addErrorMessage(String errorMessage) {
        errorMessages.add(errorMessage);
    }
}
