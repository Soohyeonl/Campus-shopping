package com.mktb.nobug.entity;
import java.io.Serializable;
import java.sql.Date;

public class UserCart implements Serializable {
    private int cart_id;
    private int user_id;
    private int goods_id;
    private int goods_stock;
    private Date input_time;
    private double total_price;

    public UserCart() {
    }

    public UserCart(int cart_id, int user_id, int goods_id, int goods_stock, Date input_time, double total_price) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.goods_id = goods_id;
        this.goods_stock = goods_stock;
        this.input_time = input_time;
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "usercart{" +
                "cart_id=" + cart_id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", goods_stock=" + goods_stock +
                ", input_time=" + input_time +
                ", total_price=" + total_price +
                '}';
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(int goods_stock) {
        this.goods_stock = goods_stock;
    }

    public Date getInput_time() {
        return input_time;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

}
