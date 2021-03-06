package com.itmuch.cloud.client;

import com.itmuch.cloud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使⽤@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，还可以使⽤url参数指定⼀个URL。
 *
 * @author eacdy
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignHystrixClient.HystrixClientFallback.class)
public interface UserFeignHystrixClient {
    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);


//    @RequestMapping("/instance-info")
//    ServiceInstance showInfo();


    @Component
    static class HystrixClientFallback implements UserFeignHystrixClient{

        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         * hystrix fallback方法
         *
         * @param id id
         * @return 默认的⽤户
         */
//    @Override
        public User findByIdFeign(Long id) {
            HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }

//        @Override
//        public ServiceInstance showInfo() {
//            return null;
//        }

    }

}
