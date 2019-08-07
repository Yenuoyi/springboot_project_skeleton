package com.example.skeleton.domain.timer.wechat;

import com.example.skeleton.controller.TimerController;

/**
 * @author yebing
 */
public class RequestEntity {
    /**
     * 消息类型：text、markdown、image、news
     */
    private String msgtype;
    private RequestText text;
    private RequestMarkdown markdown;
    private RequestImage image;
    private RequestNews news;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public RequestText getText() {
        return text;
    }

    public void setText(RequestText text) {
        this.text = text;
    }

    public RequestMarkdown getMarkdown() {
        return markdown;
    }

    public void setMarkdown(RequestMarkdown markdown) {
        this.markdown = markdown;
    }

    public RequestImage getImage() {
        return image;
    }

    public void setImage(RequestImage image) {
        this.image = image;
    }

    public RequestNews getNews() {
        return news;
    }

    public void setNews(RequestNews news) {
        this.news = news;
    }
}
