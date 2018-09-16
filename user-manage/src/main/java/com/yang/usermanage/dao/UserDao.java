package com.yang.usermanage.dao;


import com.yang.usermanage.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findUsers();

    int addUser(User user);


}