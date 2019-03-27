package com.example.skeleton.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Wrapper<T> implements Serializable {
    private static final long serialVersionUID = 4893280118017319089L;
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "OK";
    public static final int SUCCESS_NODATA_CODE = 2200;
    public static final String SUCCESS_NODATA_MESSAGE = "没有任务! ";
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "内部异常";
    public static final int ILLEGAL_ARGUMENT_CODE_ = 100;
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";
    public static final int RFTIME_OUT_CODE_ = 600;
    public static final String RFTIME_OUT_MESSAGE = "调用超时";
    public static final int RF_CIPHERTEXT_CODE_ = 700;
    public static final String RF_CIPHERTEXT_MESSAGE = "密文错误";
    private int code;
    private String message;
    private T result;

    public static int getSuccessCode() {
        return 200;
    }

    public static String getSuccessMessage() {
        return "OK";
    }

    public static int getSuccessNodataCode() {
        return 2200;
    }

    public static String getSuccessNodataMessage() {
        return "没有任务! ";
    }

    public static int getErrorCode() {
        return 500;
    }

    public static String getErrorMessage() {
        return "内部异常";
    }

    public static int getIllegalArgumentCode() {
        return 100;
    }

    public static String getIllegalArgumentMessage() {
        return "参数非法";
    }

    public static int getRftimeOutCode() {
        return 600;
    }

    public static String getRftimeOutMessage() {
        return "调用超时";
    }

    public static int getRfCiphertextCode() {
        return 700;
    }

    public static String getRfCiphertextMessage() {
        return "密文错误";
    }

    public Wrapper() {
        this(200, "OK");
    }

    public Wrapper(int code, String message) {
        this.code(code).message(message);
    }

    public Wrapper(int code, String message, T result) {
        this.code(code).message(message).result(result);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Wrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    public Wrapper<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public Wrapper<T> result(T result) {
        this.setResult(result);
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return 200 == this.code;
    }
}
