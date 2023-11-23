package com.my.app.controller;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping(value = "test_set")
    public String test_set(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "SUCCESS";
    }

    @GetMapping(value = "test_get")
    public String test_get(
            @RequestParam("key") String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }
}
