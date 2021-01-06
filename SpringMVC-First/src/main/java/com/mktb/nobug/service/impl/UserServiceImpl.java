package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.UserDao;
import com.mktb.nobug.entity.User;
import com.mktb.nobug.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUserPwd(Map<String, Object> newPwd) {
        userDao.updateUserPwd(newPwd);
    }

    @Override
    public void updateUserNickName(Map<String, Object> newNickName) {
        userDao.updateUserNickName(newNickName);
    }

    @Override
    public void updateUserPicture(Map<String, Object> objectMap) {
        userDao.updateUserPicture(objectMap);
    }

    @Override
    public void updateUserPhone(Map<String, Object> objectMap) {
        userDao.updateUserPhone(objectMap);
    }

    @Override
    public void updateUserType(Map<String, Object> objectMap) {
        userDao.updateUserType(objectMap);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public int getNextId() {
        return userDao.getNextId();
    }
}
