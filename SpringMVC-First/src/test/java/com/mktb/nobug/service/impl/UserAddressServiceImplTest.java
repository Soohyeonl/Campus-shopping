package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.UserAddressDao;
import com.mktb.nobug.entity.UserAddress;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserAddressServiceImplTest {

    @Test
    public void getUserAddressByUserId() {
        ApplicationContext application = new  ClassPathXmlApplicationContext("applicationContext.xml");
        UserAddressDao userAddressDao = application.getBean("userAddressDao", UserAddressDao.class);
        UserAddress userAddress = userAddressDao.getUserAddress(9);
        System.out.println(userAddress);
    }
}