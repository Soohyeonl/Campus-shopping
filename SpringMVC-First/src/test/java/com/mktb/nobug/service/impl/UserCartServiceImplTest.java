package com.mktb.nobug.service.impl;

import com.mktb.nobug.service.UserCartService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserCartServiceImplTest extends TestCase {

    public void testGetNextId() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserCartService userCartService = applicationContext.getBean("userCartService", UserCartService.class);

        Integer nextId = userCartService.getNextId();

        System.out.println(nextId);
    }

    public void testGetGoodStock() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserCartService userCartService = applicationContext.getBean("userCartService", UserCartService.class);

        Integer goodStock = userCartService.getGoodStock(1);

        System.out.println(goodStock);
    }
}