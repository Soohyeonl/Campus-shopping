package com.mktb.nobug.dao;

import com.mktb.nobug.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    Goods selectById(int goods_id);

    List<Goods> getGoodsList();

    void addGood(Goods good);

    void deleteGood(int goods_id);


    void updateGoodsName(Map<String, Object> newName);

    void updateGoodsDescription(Map<String, Object> newDescription);

    void updateGoodsStock(Map<String, Object> newStock);

    void updateGoodsOntime(Map<String, Object> newOnTime);

    void updateGoodsPrice(Map<String, Object> newPice);

    void updateGoodsPicture(Map<String, Object> newPictrue);

    Integer getNextId();

    List<Goods> getGoodsBySellerId(int id);
//    void updateGood(Goods good);
//    List<Goods> findByName(String goods_name); //模糊查询
//    int getTotal();
}
