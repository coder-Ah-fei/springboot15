package com.yang.usermanage.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.yang.usermanage.client.RoleClient;
import com.yang.usermanage.dao.UserDao;
import com.yang.usermanage.entity.User;
import com.yang.usermanage.exception.RoleException;
import com.yang.usermanage.service.UserService;
import feign.FeignException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RoleClient roleClient;


    @Override
    public List<User> findUsers() {

        List<User> users = userDao.findUsers();

        return users;
    }

    @Transactional(rollbackFor = Exception.class)
    @TxTransaction(isStart = true)
    @Override
    public String addUser(User user) throws RoleException{
        String s = "添加用户和角色成功";
        userDao.addUser(user);
        try{
            roleClient.addRole(2, "role2");
        }catch (FeignException fe){
            System.out.println("==========================");
            fe.getMessage();
            System.out.println("==========================");
            s = "添加用户和角色失败";
            throw new RoleException("添加role出错");
        }
        return s;
    }

    @Transactional(rollbackFor = Exception.class)
    @TxTransaction()
    @Override
    public String addUserForRole(User user) {
        String s = "添加用户和角色成功";
        userDao.addUser(user);
        return s;
    }
}
