package com.mktb.nobug.service.impl;

import com.mktb.nobug.dao.UserAddressDao;
import com.mktb.nobug.entity.UserAddress;
import com.mktb.nobug.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public UserAddress getUserAddressByUserId(int id) {
        return userAddressDao.getUserAddress(id);
    }

    @Override
    public int getNextId() {
        return userAddressDao.getNextId();
    }

    @Override
    public boolean updateUserAddress(int address_id, String newaddress) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_address_id", address_id);
        hashMap.put("new_address", newaddress);

        userAddressDao.updateAddress(hashMap);
        return true;
    }

    @Override
    public boolean addAddress(UserAddress userAddress) {
        userAddressDao.addAddress(userAddress);
        return true;
    }
}
