package com.itmuch.cloud.controller;

import com.itmuch.cloud.client.UserFeignClient;
import com.itmuch.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.userFeignClient.findByIdFeign(id);
        return user;
    }
    @GetMapping("/feign/instance-info")
    public ServiceInstance showInfo() {
        return this.userFeignClient.showInfo();
    }
}
