package com.mktb.nobug.dao;

import com.mktb.nobug.entity.UserCartView;

import java.util.List;

public interface UserCartViewDao {
    List<UserCartView> getAllCartById(int id);
}
