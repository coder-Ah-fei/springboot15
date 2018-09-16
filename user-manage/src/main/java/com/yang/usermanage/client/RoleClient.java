package com.yang.usermanage.client;

import com.yang.usermanage.client.hystric.RoleClientHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ROLE-MANAGE", fallback = RoleClientHystric.class)
public interface RoleClient {

    @RequestMapping(value = "role/addRole")
    String addRole(@RequestParam(value = "id")int id, @RequestParam(value = "name")String name);

}
