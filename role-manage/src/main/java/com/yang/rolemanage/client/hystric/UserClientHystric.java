package com.yang.rolemanage.client.hystric;

import com.yang.rolemanage.client.UserClient;

public class UserClientHystric implements UserClient {
    @Override
    public String addUserForRole(int id, String name) {
        return "USER-MANAGE那边出错了";
    }
}
