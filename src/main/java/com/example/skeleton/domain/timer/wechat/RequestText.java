package com.example.skeleton.domain.timer.wechat;

import java.util.List;

/**
 * @author yebing
 */
public class RequestText {
    /**
     * 文本内容，最长不超过2048个字节，必须是utf8编码
     */
    private String content;
    /**
     * userid的列表，提醒群中的指定成员(@某个成员)，@all表示提醒所有人，如果开发者获取不到userid，可以使用mentioned_mobile_list
     */
    private List<String> mentioned_list;
    /**
     * 手机号列表，提醒手机号对应的群成员(@某个成员)，@all表示提醒所有人
     */
    private List<String> mentioned_mobile_list;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getMentioned_list() {
        return mentioned_list;
    }

    public void setMentioned_list(List<String> mentioned_list) {
        this.mentioned_list = mentioned_list;
    }

    public List<String> getMentioned_mobile_list() {
        return mentioned_mobile_list;
    }

    public void setMentioned_mobile_list(List<String> mentioned_mobile_list) {
        this.mentioned_mobile_list = mentioned_mobile_list;
    }
}
