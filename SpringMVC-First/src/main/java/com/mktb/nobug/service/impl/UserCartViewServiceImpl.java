package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.UserCartViewDao;
import com.mktb.nobug.entity.UserCartView;
import com.mktb.nobug.service.UserCartViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userCartViewService")
public class UserCartViewServiceImpl implements UserCartViewService {
    @Autowired
    private UserCartViewDao userCartViewDao;

    @Override
    public List<UserCartView> getAllCartById(int id) {
        return userCartViewDao.getAllCartById(id);
    }
}
