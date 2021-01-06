package com.mktb.nobug.service;

import com.mktb.nobug.entity.UserCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserCartService {
    List<UserCart> getUserCartList();

    //根据userid查询购物车记录
    List<UserCart> getUserCartById(int id);

    //添加购物车记录
    void addUserCart(UserCart usercart);

    //根据购物车编号删除记录
    void deleteUserCart(int id);

    //根据购物车ID更新数量
    void updateGoodStock(Map<String, Object> map);

    Integer getNextId();

    Integer getGoodStock(int cart_id);

    void deleteByGoodsId(int user_id ,int goods_id);

    UserCart getByCartId(int cart_id);
}
