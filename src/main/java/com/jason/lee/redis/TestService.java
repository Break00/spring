package com.jason.lee.redis;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author huanli9
 * @description
 * @date 2020/11/17 13:56
 */
@Service
public class TestService {
    private Random random = new Random();
    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    public String generateVerifyCode(int length) {
        String code = "";
        for (int i = 0; i < length; i++) {
            code += random.nextInt(10);
        }
        return code;
    }

    public void setex(String key, String value, int seconds) {
        jedis.setex(key, seconds, value);
    }

    public long incr(String key) {
        return jedis.incr(key);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public void expire(String key, int seconds) {
        jedis.expire(key, seconds);
    }

    public void del(String key) {
        jedis.del(key);
    }

    public void close() {
        jedis.close();
    }

}
