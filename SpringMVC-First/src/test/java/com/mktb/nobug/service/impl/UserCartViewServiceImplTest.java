package com.mktb.nobug.service.impl;

import com.mktb.nobug.entity.UserCartView;
import com.mktb.nobug.service.UserCartViewService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserCartViewServiceImplTest {

    @Test
    public void getAllCartById() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserCartViewService userCartViewService = applicationContext.getBean("userCartViewService", UserCartViewService.class);

        List<UserCartView> allCartById = userCartViewService.getAllCartById(1);

        for (UserCartView userCartView : allCartById) {
            System.out.println(userCartView);
        }
    }
}