package com.yang.usermanage.service;

import com.yang.usermanage.entity.User;

import java.util.List;

public interface UserService {


    List<User> findUsers();

    String addUser(User user);

    String addUserForRole(User user);

}
