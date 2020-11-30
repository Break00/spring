package com.jason.lee.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 15:13
 */
public class DeferredResultQueue {
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedDeque<>();

    public static void save(DeferredResult<Object> result){
        queue.offer(result);
    }

    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
