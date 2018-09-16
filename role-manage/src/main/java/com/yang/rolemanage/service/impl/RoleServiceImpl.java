package com.yang.rolemanage.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.yang.rolemanage.client.UserClient;
import com.yang.rolemanage.dao.RoleDao;
import com.yang.rolemanage.entity.Role;
import com.yang.rolemanage.exception.UserException;
import com.yang.rolemanage.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;


    @Override
    public List<Role> findRoles() {

        List<Role> roles = roleDao.findRoles();

        return roles;
    }

    @Transactional(rollbackFor = Exception.class)
    @TxTransaction
    @Override
    public String addRole(Role role) throws UserException {
//        int i = 1/0;
        roleDao.addRole(role);
        return "新增角色和用户成功";

    }
}
