package com.mktb.nobug.service;

import com.mktb.nobug.entity.Orders;
import com.mktb.nobug.entity.SellOrder;
import com.mktb.nobug.entity.User;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    List<Orders> GetOrdersList();

    void adduOrders(Orders order);

    void deleteOrders(int id);

    void updatePayTime(int order_id);

    void updateCancelTime(Map<String, Object> map);

    void updateDeliveryTime(int order_id);

    void updateDoneTime(int order_id);

    Integer getnextId();

    boolean addToOrders(int cart_id, int goods_id, int quantity, double order_price, int address_id, User user);

    List<SellOrder> mySellOrders(int seller_id);

    Orders getOrderById(int id);
}
