package com.itmuch.cloud.client;

import com.itmuch.cloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使⽤@FeignClient("microservice-provider-user")注解绑定micros
 * ervice-provider-user服务，还可以使⽤url参数指定⼀个URL。
 *
 * @author eacdy
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);
}
