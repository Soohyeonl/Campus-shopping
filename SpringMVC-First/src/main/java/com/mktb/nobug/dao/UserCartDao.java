package com.mktb.nobug.dao;


import com.mktb.nobug.entity.UserCart;

import java.util.List;
import java.util.Map;

public interface UserCartDao {
    //获取全部查询
    List<UserCart> getUserCartList();

    //根据userid查询购物车记录
    List<UserCart> getUserCartById(int id);

    //添加购物车记录
    void addUserCart(UserCart usercart);

    //根据购物车编号删除记录
    void deleteUserCart(int id);

    //根据购物车ID更新数量
    void updateGoodStock(Map<String, Object> map);

    Integer getnextId();

    Integer getGoodStock(int cart_id);

    void deleteByGoodsId(Map<String, Object> map);

    UserCart getByCartId(int cart_id);
}