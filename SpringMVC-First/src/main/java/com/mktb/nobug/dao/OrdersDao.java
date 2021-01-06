package com.mktb.nobug.dao;

import com.mktb.nobug.entity.Orders;

import java.util.List;
import java.util.Map;

public interface OrdersDao {

    List<Orders> GetOrdersList();

    void adduOrders(Orders order);

    void deleteOrders(int id);

    void updatePayTime(Map<String, Object> map);

    void updateCancelTime(Map<String, Object> map);

    void updateDeliveryTime(Map<String, Object> map);

    void updateDoneTime(Map<String, Object> map);

    Integer getnextId();

    List<Orders> getSellOrdersById(int id);

    Orders getOrderById(int id);
}
