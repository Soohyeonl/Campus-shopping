package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.*;
import com.mktb.nobug.entity.*;
import com.mktb.nobug.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserCartDao userCartDao;

    @Autowired
    private UserAddressDao userAddressDao;

    @Autowired
    private UserDao userDao;

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Override
    public List<Orders> GetOrdersList() {
        return ordersDao.GetOrdersList();
    }

    @Override
    public void adduOrders(Orders order) {
        ordersDao.adduOrders(order);
    }

    @Override
    public void deleteOrders(int id) {
        Orders orderById = ordersDao.getOrderById(id);
        Goods goods = goodsDao.selectById(orderById.getGoods_id());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("new_stock", goods.getStock() + orderById.getQuantity());
        hashMap.put("goods_id", goods.getGoods_id());
        ordersDao.deleteOrders(id);
        goodsDao.updateGoodsStock(hashMap);
    }

    @Override
    public void updatePayTime(int order_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("order_id", order_id);
        hashMap.put("pay_time", new Date(new java.util.Date().getTime()));
        hashMap.put("order_state", 1);
        ordersDao.updatePayTime(hashMap);
    }


    @Override
    public void updateCancelTime(Map<String, Object> map) {
        ordersDao.updateCancelTime(map);
    }

    @Override
    public void updateDeliveryTime(int order_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("order_id", order_id);
        hashMap.put("delivery_time", new Date(new java.util.Date().getTime()));
        hashMap.put("order_state", 2);
        ordersDao.updateDeliveryTime(hashMap);
    }

    @Override
    public void updateDoneTime(int order_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("order_id", order_id);
        hashMap.put("done_time", new Date(new java.util.Date().getTime()));
        hashMap.put("order_state", 3);
        ordersDao.updateDoneTime(hashMap);
    }

    @Override
    public Integer getnextId() {
        return ordersDao.getnextId();
    }

    @Override
    public boolean addToOrders(int cart_id, int goods_id, int quantity, double order_price, int address_id, User user) {
        Goods goods = goodsDao.selectById(goods_id);
        if (goods.getStock() - quantity < 0) {
            return false;
        } else {
            Orders orders = new Orders(ordersDao.getnextId(), user.getUser_id(), goods_id, quantity,
                    new Date(new java.util.Date().getTime()), 0, order_price,
                    null, null, null, goods.getUser_id(), null, address_id);

            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("new_stock", goods.getStock() - quantity);
            hashMap.put("goods_id", goods.getGoods_id());
            goodsDao.updateGoodsStock(hashMap);

            userCartDao.deleteUserCart(cart_id);

            ordersDao.adduOrders(orders);
        }

        return true;
    }

    @Override
    public List<SellOrder> mySellOrders(int seller_id) {
        List<Orders> sellOrdersById = ordersDao.getSellOrdersById(seller_id);
        List<SellOrder> sellOrders = new ArrayList<>();

        for (Orders orders : sellOrdersById) {
            Goods goods = goodsDao.selectById(orders.getGoods_id());
            User userById = userDao.getUserById(orders.getBuyer_id());
            UserAddress userAddress = userAddressDao.getUserAddress(orders.getAddress_id());
            SellOrder sellOrder = new SellOrder(orders, goods, userById, userAddress);
            sellOrders.add(sellOrder);
        }
        return sellOrders;
    }

    @Override
    public Orders getOrderById(int id) {
        return ordersDao.getOrderById(id);
    }


}
