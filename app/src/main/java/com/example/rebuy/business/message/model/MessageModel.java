package com.example.rebuy.business.message.model;

/**
 * @author YangZhaoxin.
 * @since 2019/4/5 18:21.
 * email yangzhaoxin@hrsoft.net.
 */

public class MessageModel {

    private int portrait;
    private String name;
    private String content;
    private String date;
    private String time;

    public MessageModel() {
    }

    public MessageModel(int portrait, String name, String content, String date, String time) {
        this.portrait = portrait;
        this.name = name;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public int getPortrait() {
        return portrait;
    }

    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
