package com.jason.lee.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/17 13:46
 */
@Controller
public class TestController {

    @Resource
    private TestService service;

    public static final String VERIFY_CODE_PREFIX = "VerifyCode_";
    public static final String VERIFY_CODE_SUFFIX = "_Count";

    @ResponseBody
    @RequestMapping(value = "getVerifyCode", method = RequestMethod.POST)
    public String getVerifyCode(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            return "empty";
        }

        String key = VERIFY_CODE_PREFIX + phoneNumber;
        String countKey = key + VERIFY_CODE_SUFFIX;
        String s = service.get(countKey);

        if (StringUtils.isNotBlank(s) && Integer.parseInt(s) == 3) {
            return "limit";
        }

        String verifyCode = service.generateVerifyCode(6);
        service.setex(key, verifyCode, 60);
        service.incr(countKey);
        service.expire(countKey, 60 * 60 * 24);
        service.close();
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "verifyCode", method = RequestMethod.POST)
    public String verifyCode(String phoneNumber, String verifyCode) {
        String key = VERIFY_CODE_PREFIX + phoneNumber;
        String s = service.get(key);
        if (StringUtils.equals(verifyCode, s)) {
            service.close();
            return "true";
        }
        return "false";
    }
}
