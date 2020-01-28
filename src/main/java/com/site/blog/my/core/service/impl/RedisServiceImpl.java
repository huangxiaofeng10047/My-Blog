package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.service.RedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    @Override
    public String incr(final String key) {
        String incr = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                Long value = redisConnection.incr(serializer.serialize(key));
                return String.valueOf(value);
            }
        });
        return incr;
    }

    @Override
    public String get(final String key){
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }
}
