package com.jason.lee.entity;

/**
 * @author huanli9
 * @description
 * @date 2020/12/22 13:53
 */
public enum UserStatus {
    /*
    * name —— LOGIN  枚举实例的名称
    * ordinal —— 0  枚举实例的索引
    * */
    LOGIN(100,"登录"),LOGOUT(200,"登出"), REMOVE(300, "移除");

    private Integer code;
    private String msg;

    UserStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static UserStatus getUserStatus(Integer code){
        switch (code){
            case 100:
                return LOGIN;
            case 200:
                return LOGOUT;
            case 300:
                return REMOVE;
            default:
                return LOGOUT;
        }
    }
}
