package com.jason.lee.annotation.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author huanli9
 * @description
 * @date 2020/11/26 16:39
 */
@Service
public class MyListenerService {

    /**
     * 方式二 自定义监听器
     * @param event
     */
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("MyListenerService监听的事件：" + event);
    }
}
