package com.mktb.nobug.service;

import com.mktb.nobug.entity.UserCartView;

import java.util.List;

public interface UserCartViewService {
    List<UserCartView> getAllCartById(int id);
}
