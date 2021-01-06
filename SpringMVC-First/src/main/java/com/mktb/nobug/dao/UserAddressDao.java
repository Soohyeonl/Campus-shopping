package com.mktb.nobug.dao;

import com.mktb.nobug.entity.UserAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserAddressDao {
    UserAddress selectByUserAddressId(int user_address_id);

    List<UserAddress> getAddressList();

    void addAddress(UserAddress address);

    void deleteAddress(int user_address_id);

    void updateAddress(Map<String, Object> newAddress);

    UserAddress getUserAddress(int id);

    int getNextId();
}
