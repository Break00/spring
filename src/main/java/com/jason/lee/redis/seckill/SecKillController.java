package com.jason.lee.redis.seckill;

import com.jason.lee.redis.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author huanli9
 * @description
 * @date 2020/11/17 19:35
 */
@Controller
public class SecKillController {

    @Autowired
    private SecKillService service;

    @ResponseBody
    @RequestMapping(value = "secKill", method = RequestMethod.POST)
    public boolean secKill(String prodId) {
        String userId = new Random().nextInt(50000) + "";
        return service.doSecKillByScript(userId, prodId);
    }
}
