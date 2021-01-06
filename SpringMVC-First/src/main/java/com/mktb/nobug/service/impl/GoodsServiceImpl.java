package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.GoodsDao;
import com.mktb.nobug.entity.Goods;
import com.mktb.nobug.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods selectById(int goods_id) {
        return goodsDao.selectById(goods_id);
    }

    @Override
    public List<Goods> getGoodsList() {
        return goodsDao.getGoodsList();
    }

    @Override
    public void addGood(Goods good) {
        goodsDao.addGood(good);
    }

    @Override
    public void deleteGood(int goods_id) {
        goodsDao.deleteGood(goods_id);
    }

    @Override
    public void updateGoodsName(Map<String, Object> newName) {
        goodsDao.updateGoodsName(newName);
    }

    @Override
    public void updateGoodsDescription(Map<String, Object> newDescription) {
        goodsDao.updateGoodsDescription(newDescription);
    }

    @Override
    public void updateGoodsStock(Map<String, Object> newStock) {
        goodsDao.updateGoodsStock(newStock);
    }

    @Override
    public void updateGoodsOntime(Map<String, Object> newOnTime) {
        goodsDao.updateGoodsOntime(newOnTime);
    }

    @Override
    public void updateGoodsPrice(Map<String, Object> newPice) {
        goodsDao.updateGoodsPrice(newPice);
    }

    @Override
    public void updateGoodsPicture(Map<String, Object> newPictrue) {
        goodsDao.updateGoodsPicture(newPictrue);
    }

    @Override
    public int getNextId() {
        return goodsDao.getNextId();
    }

    @Override
    public List<Goods> getGoodsBySellerId(int id) {
        return goodsDao.getGoodsBySellerId(id);
    }

}
