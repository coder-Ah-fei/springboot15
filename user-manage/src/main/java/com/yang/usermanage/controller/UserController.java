package com.yang.usermanage.controller;

import com.yang.usermanage.entity.User;
import com.yang.usermanage.exception.RoleException;
import com.yang.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findUsers")
    public List<User> findUsers(){
        return userService.findUsers();
    }

    @RequestMapping(value = "addUser")
    public String addUser(@RequestParam("id")int id, @RequestParam("name") String name){
        String s;
        User user = new User();
        user.setId(id);
        user.setName(name);
        try{
            s = userService.addUser(user);
        }catch (RoleException re){
            s = re.getMessage();
        }


        return s;

    }

    @RequestMapping(value = "addUserForRole")
    public String addUserForRole(@RequestParam("id")int id, @RequestParam("name") String name){
        String s;
        User user = new User();
        user.setId(id);
        user.setName(name);
        s = userService.addUser(user);

        return s;

    }


}
