package com.mktb.nobug.service;

import com.mktb.nobug.entity.User;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserList();

    User getUserById(Integer id);

    void addUser(User user);

    void deleteUserById(Integer id);

    void updateUserPwd(Map<String, Object> newPwd);

    void updateUserNickName(Map<String, Object> newNickName);

    void updateUserPicture(Map<String, Object> objectMap);

    void updateUserPhone(Map<String, Object> objectMap);

    void updateUserType(Map<String, Object> objectMap);

    User getUserByPhone(@Param("phone") String phone);

    int getNextId();
}
