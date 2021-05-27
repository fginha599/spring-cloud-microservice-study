package com.itmuch.cloud.service;

import com.itmuch.cloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    /**
     * 使⽤@HystrixCommand注解指定当该⽅法发⽣异常时调⽤的⽅法
     *
     * @param id id
     * @return 通过id查询到的⽤户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/ " + id, User.class);
    }

    /**
     * hystrix fallback⽅法
     *
     * @param id id
     * @return 默认的⽤户
     */
    public User fallback(Long id) {
        RibbonHystrixService.LOGGER.info("异常发⽣，进⼊fallback⽅法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}
