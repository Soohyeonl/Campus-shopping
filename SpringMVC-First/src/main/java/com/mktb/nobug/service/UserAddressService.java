package com.mktb.nobug.service;

import com.mktb.nobug.entity.UserAddress;

public interface UserAddressService {
    UserAddress getUserAddressByUserId(int id);

    int getNextId();

    boolean updateUserAddress(int address_id, String newaddress);

    boolean addAddress(UserAddress userAddress);
}
