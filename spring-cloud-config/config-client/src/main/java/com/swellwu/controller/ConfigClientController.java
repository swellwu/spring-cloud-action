package com.swellwu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2018-02-08
 */
@RestController
@RefreshScope
@EnableEurekaClient
public class ConfigClientController {

    @Value("${name}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + name;
    }
}
