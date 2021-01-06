package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.UserDao;
import com.mktb.nobug.entity.User;
import com.mktb.nobug.service.UserService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest extends TestCase {

    public void testGetUserByPhone() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        User user = userService.getUserByPhone("1");
        System.out.println(user);
    }
}