package com.mktb.nobug.service;

import com.mktb.nobug.dao.OrdersViewDao;
import com.mktb.nobug.entity.OrdersView;

import java.util.List;

public interface OrdersViewService {
    List<OrdersView> getAllOrders(int id);
}
