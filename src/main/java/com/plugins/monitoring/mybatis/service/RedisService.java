package com.plugins.monitoring.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/3 16:58
 * @Description: redis
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @Description: 批量删除缓存
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove( key );
        }
    }

    /**
     * @Description: 批量删除缓存(通配符)
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys( pattern );
        if (keys.size() > 0)
            redisTemplate.delete( keys );
    }

    /**
     * @Description: 删除缓存
     */
    public void remove(final String key) {
        if (exists( key )) {
            redisTemplate.delete( key );
        }
    }

    /**
     * @Description: 判断缓存中是否有对应的value
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey( key );
    }

    /**
     * @Description: 读取缓存
     */
    public Object get(final String key) {
        return redisTemplate.opsForValue().get( key );
    }

    /**
     * @Description: 写入缓存
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set( key, (String) value );
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Description: 写入缓存(可以配置过期时间)
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set( key, (String) value );
            redisTemplate.expire( key, expireTime, TimeUnit.SECONDS );
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}