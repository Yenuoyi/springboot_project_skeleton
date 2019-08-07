package com.example.skeleton.domain.timer.wechat;

/**
 * @author yebing
 */
public class RequestNewsArticles {
    /**
     * 标题，不超过128个字节，超过会自动截断
     */
    private String title;
    /**
     * 描述，不超过512个字节，超过会自动截断
     */
    private String description;
    /**
     * 点击后跳转的链接。
     */
    private String url;
    /**
     * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
     */
    private String picurl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
