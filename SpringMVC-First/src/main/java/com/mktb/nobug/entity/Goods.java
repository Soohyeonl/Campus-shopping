package com.mktb.nobug.entity;


import java.io.Serializable;
import java.sql.Date;

public class Goods implements Serializable {
    private int goods_id;
    private String goods_name;
    private String description;
    private int stock;
    private Date on_time;
    private double price;
    private String goods_picture;
    private int user_id;

    public Goods() {
    }

    public Goods(int goods_id, String goods_name, String description, int stock, Date on_time, double price, String goods_picture, int user_id) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.description = description;
        this.stock = stock;
        this.on_time = on_time;
        this.price = price;
        this.goods_picture = goods_picture;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", on_time=" + on_time +
                ", price=" + price +
                ", goods_picture='" + goods_picture + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getOn_time() {
        return on_time;
    }

    public void setOn_time(Date on_time) {
        this.on_time = on_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoods_picture() {
        return goods_picture;
    }

    public void setGoods_picture(String goods_picture) {
        this.goods_picture = goods_picture;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
