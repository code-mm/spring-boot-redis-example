package com.my.app;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test1() {
        // 设置缓冲
        redisTemplate.opsForValue().set("test_1", "1");
        // 获取缓冲
        Object o = redisTemplate.opsForValue().get("test_1");
        System.out.println(o);
    }
}
