package com.example.rebuy.business.account.model;

import org.litepal.crud.LitePalSupport;

/**
 * @author YangZhaoxin.
 * @since 2019/3/31 17:54.
 * email yangzhaoxin@hrsoft.net.
 */

public class User extends LitePalSupport{

    private int id;
    private String account;
    private String password;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
