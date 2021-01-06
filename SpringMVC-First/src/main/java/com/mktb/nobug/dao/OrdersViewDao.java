package com.mktb.nobug.dao;

import com.mktb.nobug.entity.OrdersView;

import java.util.List;

public interface OrdersViewDao {
    List<OrdersView> getAllOrders(int id);
}
