package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.OrdersViewDao;
import com.mktb.nobug.entity.OrdersView;
import com.mktb.nobug.service.OrdersViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderViewService")
public class OrdersViewServiceImpl implements OrdersViewService {
    @Autowired
    private OrdersViewDao ordersViewDao;

    @Override
    public List<OrdersView> getAllOrders(int id) {
        return ordersViewDao.getAllOrders(id);
    }
}
