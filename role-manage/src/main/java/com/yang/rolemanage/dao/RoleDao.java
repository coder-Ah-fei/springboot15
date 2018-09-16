package com.yang.rolemanage.dao;


import com.yang.rolemanage.entity.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findRoles();

    int addRole(Role role);


}