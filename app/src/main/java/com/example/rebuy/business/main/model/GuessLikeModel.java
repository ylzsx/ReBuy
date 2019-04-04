package com.example.rebuy.business.main.model;

/**
 * @author YangZhaoxin.
 * @since 2019/4/4 12:56.
 * email yangzhaoxin@hrsoft.net.
 */

public class GuessLikeModel {

    private double price;
    private String content;
    private boolean auction;
    private boolean exchange;
    private boolean sell;

    public GuessLikeModel() {
    }

    public GuessLikeModel(double price, String content, boolean auction, boolean exchange, boolean sell) {
        this.price = price;
        this.content = content;
        this.auction = auction;
        this.exchange = exchange;
        this.sell = sell;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isAuction() {
        return auction;
    }

    public void setAuction(boolean auction) {
        this.auction = auction;
    }

    public boolean isExchange() {
        return exchange;
    }

    public void setExchange(boolean exchange) {
        this.exchange = exchange;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }
}
