package com.mktb.nobug.service.impl;

import com.mktb.nobug.service.OrdersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class OrdersServiceImplTest {

    @Test
    public void getOrdersList() {
    }

    @Test
    public void adduOrders() {
    }

    @Test
    public void deleteOrders() {
    }

    @Test
    public void updatePayTime() {
    }

    @Test
    public void updateCancelTime() {
    }

    @Test
    public void updateDeliveryTime() {
    }

    @Test
    public void updateDoneTime() {
    }

    @Test
    public void getnextId() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService ordersServiec = applicationContext.getBean("ordersService", OrdersService.class);

        Integer integer = ordersServiec.getnextId();

        System.out.println(integer);
    }
}