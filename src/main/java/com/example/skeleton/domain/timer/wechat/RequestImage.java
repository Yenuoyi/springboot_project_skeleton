package com.example.skeleton.domain.timer.wechat;

/**
 * @author yebing
 */
public class RequestImage {
    /**
     * 图片内容的base64编码
     */
    private String base64;
    /**
     * 图片内容（base64编码前）的md5值
     */
    private String md5;

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
