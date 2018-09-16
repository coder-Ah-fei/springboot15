package com.yang.rolemanage.service;

import com.yang.rolemanage.entity.Role;

import java.util.List;

public interface RoleService {


    List<Role> findRoles();

    String addRole(Role role);
}
