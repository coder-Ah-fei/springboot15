package com.yang.rolemanage.controller;

import com.yang.rolemanage.entity.Role;
import com.yang.rolemanage.exception.UserException;
import com.yang.rolemanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "findRoles")
    public List<Role> findRoles(){
        return roleService.findRoles();
    }

    @RequestMapping(value = "addRole")
    public String addRole(@RequestParam("id")int id, @RequestParam("name") String name){
        String s;
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        try{
            s = roleService.addRole(role);
        }catch (UserException ue){
            s = ue.getMessage();
        }

        return s;

    }

}
