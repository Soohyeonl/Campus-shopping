package com.mktb.nobug.entity;

import java.io.Serializable;
import java.sql.Date;

public class SellOrder implements Serializable {
    private int order_id;
    private int buyer_id;
    private int goods_id;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public Date getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(Date cancel_time) {
        this.cancel_time = cancel_time;
    }

    public Date getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Date delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Date getDone_time() {
        return done_time;
    }

    public void setDone_time(Date done_time) {
        this.done_time = done_time;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
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

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int quantity;
    private Date order_time;
    private int order_state;
    private double order_price;
    private Date cancel_time;
    private Date delivery_time;
    private Date done_time;
    private int seller_id;
    private Date pay_time;

    private String goods_name;
    private String description;
    private Date on_time;
    private double price;
    private String goods_picture;

    private String user_phone;

    private String address;

    public SellOrder() {
    }

    @Override
    public String toString() {
        return "SellOrder{" +
                "order_id=" + order_id +
                ", buyer_id=" + buyer_id +
                ", goods_id=" + goods_id +
                ", quantity=" + quantity +
                ", order_time=" + order_time +
                ", order_state=" + order_state +
                ", order_price=" + order_price +
                ", cancel_time=" + cancel_time +
                ", delivery_time=" + delivery_time +
                ", done_time=" + done_time +
                ", seller_id=" + seller_id +
                ", pay_time=" + pay_time +
                ", goods_name='" + goods_name + '\'' +
                ", description='" + description + '\'' +
                ", on_time=" + on_time +
                ", price=" + price +
                ", goods_picture='" + goods_picture + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public SellOrder(int order_id, int buyer_id, int goods_id, int quantity, Date order_time, int order_state, double order_price, Date cancel_time, Date delivery_time, Date done_time, int seller_id, Date pay_time, String goods_name, String description, Date on_time, double price, String goods_picture, String user_phone, String address) {
        this.order_id = order_id;
        this.buyer_id = buyer_id;
        this.goods_id = goods_id;
        this.quantity = quantity;
        this.order_time = order_time;
        this.order_state = order_state;
        this.order_price = order_price;
        this.cancel_time = cancel_time;
        this.delivery_time = delivery_time;
        this.done_time = done_time;
        this.seller_id = seller_id;
        this.pay_time = pay_time;
        this.goods_name = goods_name;
        this.description = description;
        this.on_time = on_time;
        this.price = price;
        this.goods_picture = goods_picture;
        this.user_phone = user_phone;
        this.address = address;
    }

    public SellOrder(Orders orders, Goods goods,User user, UserAddress userAddress) {
        this.order_id = orders.getOrder_id();
        this.buyer_id = orders.getBuyer_id();
        this.goods_id = orders.getGoods_id();
        this.quantity = orders.getQuantity();
        this.order_time = orders.getOrder_time();
        this.order_state = orders.getOrder_state();
        this.order_price = orders.getOrder_price();
        this.cancel_time = orders.getCancel_time();
        this.delivery_time = orders.getDelivery_time();
        this.done_time = orders.getDone_time();
        this.seller_id = orders.getSeller_id();
        this.pay_time = orders.getPay_time();

        this.goods_name = goods.getGoods_name();
        this.description = goods.getDescription();
        this.on_time = goods.getOn_time();
        this.price = goods.getPrice();
        this.goods_picture = goods.getGoods_picture();

        this.user_phone = user.getUser_phone();
        this.address = userAddress.getAddress();
    }
}
