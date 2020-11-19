package com.jason.lee.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huanli9
 * @description
 * @date 2020/11/19 16:19
 */
public class TestCluster {
    public static void main(String[] args) {
        // redis集群搭建教程：https://blog.csdn.net/qq_36163918/article/details/109812995
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("127.0.0.1",6379));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("username", "admin");
        System.out.println(cluster.get("username"));
        cluster.close();
    }
}
