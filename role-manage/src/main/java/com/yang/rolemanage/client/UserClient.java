package com.yang.rolemanage.client;

import com.yang.rolemanage.client.hystric.UserClientHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "USER-MANAGE", fallback = UserClientHystric.class)
public interface UserClient {

    @RequestMapping(value = "user/addUserForRole")
    String addUserForRole(@RequestParam("id") int id, @RequestParam("name") String name);

}
