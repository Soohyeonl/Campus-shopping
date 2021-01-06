package com.mktb.nobug.entity;

import java.io.Serializable;

public class UserAddress implements Serializable {
    private int user_address_id;
    private int user_id;
    private String address;

    @Override
    public String toString() {
        return "UserAddress{" +
                "user_address_id=" + user_address_id +
                ", user_id=" + user_id +
                ", address='" + address + '\'' +
                '}';
    }

    public UserAddress() {
    }

    public UserAddress(int user_address_id, int user_id, String address) {
        this.user_address_id = user_address_id;
        this.user_id = user_id;
        this.address = address;
    }

    public int getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(int user_address_id) {
        this.user_address_id = user_address_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
