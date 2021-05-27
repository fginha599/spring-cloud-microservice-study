package com.itmuch.cloud.service;

import com.itmuch.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;

    public User findById(Long id) {// http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    public ServiceInstance showInfo() {
//        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        ServiceInstance localServiceInstance = this.restTemplate.getForObject("http://microservice-provider-user/instance-info", ServiceInstance.class);
        return localServiceInstance;
    }
}

