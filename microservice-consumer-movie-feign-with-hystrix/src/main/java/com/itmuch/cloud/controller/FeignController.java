package com.itmuch.cloud.controller;

import com.itmuch.cloud.client.UserFeignHystrixClient;
import com.itmuch.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    //    @Qualifier("microservice-provider-user")

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("feignHystrix/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.userFeignHystrixClient.findByIdFeign(id);
        return user;
    }

//    @GetMapping("/feign/instance-info")
//    public ServiceInstance showInfo() {
//        return this.userFeignHystrixClient.showInfo();
//    }
}
