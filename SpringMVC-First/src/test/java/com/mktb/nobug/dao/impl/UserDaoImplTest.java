package com.mktb.nobug.dao.impl;

import com.mktb.nobug.dao.UserDao;
import com.mktb.nobug.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest extends TestCase {

    public void testGetUserList() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        for (User user : userDao.getUserList()) {
            System.out.println(user);
        }
    }
}