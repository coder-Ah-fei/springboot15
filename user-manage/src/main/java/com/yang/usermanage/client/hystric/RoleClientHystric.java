package com.yang.usermanage.client.hystric;

import com.yang.usermanage.client.RoleClient;

public class RoleClientHystric implements RoleClient {
    @Override
    public String addRole(int id, String name) {
        return "ROLE-MANAGE那边出错了";
    }
}
