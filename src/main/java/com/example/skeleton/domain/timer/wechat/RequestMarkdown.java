package com.example.skeleton.domain.timer.wechat;

/**
 * @author yebing
 */
public class RequestMarkdown {
    /**
     * markdown内容，最长不超过4096个字节，必须是utf8编码
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
