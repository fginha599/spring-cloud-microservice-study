package com.itmuch.cloud.controller;

import com.itmuch.cloud.model.User;
import com.itmuch.cloud.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return this.ribbonService.findById(id);
    }

    //     @GetMapping("/instance-info")
//    public ServiceInstance showInfo() {
//        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
//        return localServiceInstance;
//    }
    @GetMapping("/ribbon/instance-info")
    public ServiceInstance showInfo() {
        return this.ribbonService.showInfo();
    }
}
