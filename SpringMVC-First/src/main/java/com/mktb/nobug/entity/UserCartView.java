package com.mktb.nobug.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class UserCartView implements Serializable {
    private int cart_id;
    private int user_id;
    private int goods_id;
    private int goods_stock;
    private Date input_time;
    private double total_price;
    private String goods_name;
    private String description;
    private Date on_time;
    private double price;
    private String goods_picture;
    private int seller_id;
}
