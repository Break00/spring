package com.jason.lee.redis.seckill;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2020/11/17 19:40
 */
@Service
public class SecKillService {

    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    // Lua脚本
    private static String secKillScript = "local userId=KEYS[1];\n" +
            "local prodId=KEYS[2];\n" +
            "local keyStore='SecKill_'..prodId;\n" +
            "local keyUser=keyStore..'_'..userId;\n" +
            "local userExists=redis.call(\"sismember\",keyUser,userId);\n" +
            "if tonumber(userExists)==1 then\n" +
            "\treturn 2;\n" +
            "end\n" +
            "local num=redis.call(\"get\",keyStore);\n" +
            "if tonumber(num)<=0 then\n" +
            "\treturn 0;\n" +
            "else\n" +
            "\tredis.call(\"decr\",keyStore); \n" +
            "\tredis.call(\"sadd\",keyUser,userId); \n" +
            "end\n" +
            "return 1;";

    public boolean doSecKill(String userId, String prodId) {
        String keyStore = "SecKill_" + prodId;
        String keyUser = "SecKill_" + prodId + "_User";
        // 监视库存
        jedis.watch(keyStore);
        // 获取库存
        String store = jedis.get(keyStore);
        // 秒杀未开始
        if (StringUtils.isBlank(store)) {
            System.out.println("秒杀未开始！");
            jedis.close();
            return false;
        }
        // 秒杀成功
        if (jedis.sismember(keyUser, userId)) {
            System.out.println("秒杀成功，不能再参与!");
        }
        // 判断库存
        if (Integer.parseInt(store) <= 0) {
            System.out.println("秒杀结束！");
            jedis.close();
            return false;
        }
        // 秒杀 开启事务——解决超卖问题，但会引发库存遗留问题
        Transaction transaction = jedis.multi();
        transaction.decr(keyStore);
        transaction.sadd(keyUser, userId);
        List<Object> list = transaction.exec();
        if (list == null || list.size() == 0) {
            System.out.println("秒杀失败！");
            jedis.close();
            return false;
        }
        jedis.close();
        System.out.println("秒杀成功！");
        return true;
    }

    public boolean doSecKillByScript(String userId, String prodId) {
        JedisPool jedisPool = GenerateJedisPool.jedisPool;
        Jedis jedis = jedisPool.getResource();
        String sha1 = jedis.scriptLoad(secKillScript);
        Object result = jedis.evalsha(sha1,2,userId,prodId);
        String s = String.valueOf(result);
        if("0".equals(s)){
            System.err.println("已抢空！");
        }else if("1".equals(s)){
            System.out.println("秒杀成功！");
        }else if("2".equals(s)){
            System.err.println("该用户已抢过！");
        }else {
            System.err.println("抢购异常！");
        }
        jedis.close();
        return true;
    }

    private static class GenerateJedisPool{
        public static JedisPool jedisPool;
        static {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            // jedis实例数
            poolConfig.setMaxTotal(100);
            // 空闲实例数
            poolConfig.setMaxIdle(20);
            // 最大等待毫秒数
            poolConfig.setMaxWaitMillis(10 * 1000);
            // 是否检查jedis可用性
            poolConfig.setTestOnBorrow(true);
            jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        }
    }
}
