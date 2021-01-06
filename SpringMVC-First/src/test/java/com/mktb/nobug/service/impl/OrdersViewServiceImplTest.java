package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.OrdersViewDao;
import com.mktb.nobug.entity.OrdersView;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class OrdersViewServiceImplTest {

    @Test
    public void getAllOrders() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersViewDao ordersViewDao = applicationContext.getBean("ordersViewDao", OrdersViewDao.class);

        List<OrdersView> allOrders = ordersViewDao.getAllOrders(1);
        for (OrdersView allOrder : allOrders) {
            System.out.println(allOrder);
        }
    }
}