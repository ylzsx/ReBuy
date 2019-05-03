package com.example.rebuy.business.home.model;

/**
 * @author YangZhaoxin.
 * @since 2019/4/7 9:32.
 * email yangzhaoxin@hrsoft.net.
 */

public class LookAroundModel {

    private String content;
    private boolean auction;
    private boolean exchange;
    private boolean sell;
    private int price;
    private int people;

    public LookAroundModel() {
    }

    public LookAroundModel(String content, boolean auction, boolean exchange, boolean sell, int price, int people) {
        this.content = content;
        this.auction = auction;
        this.exchange = exchange;
        this.sell = sell;
        this.price = price;
        this.people = people;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
