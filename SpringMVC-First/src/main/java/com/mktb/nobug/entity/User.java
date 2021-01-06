package com.mktb.nobug.entity;


import java.io.Serializable;


public class User implements Serializable {
    private Integer user_id;
    private String user_pwd;
    private String user_nick_name;
    private String user_picture;
    private String user_phone;
    private String user_type;

    public User() {
    }

    public User(Integer user_id, String user_pwd, String user_nick_name, String user_picture, String user_phone, String user_type) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_nick_name = user_nick_name;
        this.user_picture = user_picture;
        this.user_phone = user_phone;
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_nick_name='" + user_nick_name + '\'' +
                ", user_picture='" + user_picture + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_type='" + user_type + '\'' +
                '}';
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public void setUser_nick_name(String user_nick_name) {
        this.user_nick_name = user_nick_name;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public String getUser_nick_name() {
        return user_nick_name;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getUser_type() {
        return user_type;
    }
}
