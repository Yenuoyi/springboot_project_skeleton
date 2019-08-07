package com.example.skeleton.domain.timer.wechat;

import com.example.skeleton.controller.TimerController;

import java.util.List;

/**
 * @author yebing
 */
public class RequestNews {
    /**
     * 图文消息，一个图文消息支持1到8条图文
     */
    private List<RequestNewsArticles> articles;

    public List<RequestNewsArticles> getArticles() {
        return articles;
    }

    public void setArticles(List<RequestNewsArticles> articles) {
        this.articles = articles;
    }
}
