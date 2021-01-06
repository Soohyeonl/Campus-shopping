package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.UserCartDao;
import com.mktb.nobug.entity.UserCart;
import com.mktb.nobug.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCartServiceImpl implements UserCartService {
    private UserCartDao userCartDao;

    @Override
    public List<UserCart> getUserCartList() {
        return userCartDao.getUserCartList();
    }

    @Override
    public List<UserCart> getUserCartById(int id) {
        return userCartDao.getUserCartById(id);
    }

    @Override
    public void addUserCart(UserCart usercart) {
        userCartDao.addUserCart(usercart);
    }

    @Override
    public void deleteUserCart(int id) {
        userCartDao.deleteUserCart(id);
    }

    @Override
    public void updateGoodStock(Map<String, Object> map) {
        userCartDao.updateGoodStock(map);
    }

    @Override
    public Integer getNextId() {
        return userCartDao.getnextId();
    }

    @Override
    public Integer getGoodStock(int cart_id) {
        return userCartDao.getGoodStock(cart_id);
    }

    @Override
    public void deleteByGoodsId(int user_id, int goods_id) {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("user_id", user_id);
        hashMap.put("goods_id", goods_id);

        userCartDao.deleteByGoodsId(hashMap);
    }

    @Override
    public UserCart getByCartId(int cart_id) {
        return userCartDao.getByCartId(cart_id);
    }

    public void setUserCartDao(UserCartDao userCartDao) {
        this.userCartDao = userCartDao;
    }
}
