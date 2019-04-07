package com.example.rebuy.business.main.model;

/**
 * @author YangZhaoxin.
 * @since 2019/4/4 23:31.
 * email yangzhaoxin@hrsoft.net.
 */

public class AuctionModel {

    private String content;
    private double price;
    private String deadline;
    private int personNum;
    private boolean favorite = false;

    public AuctionModel() {
    }

    public AuctionModel(String content, double price, String deadline, int personNum) {
        this.content = content;
        this.price = price;
        this.deadline = deadline;
        this.personNum = personNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
