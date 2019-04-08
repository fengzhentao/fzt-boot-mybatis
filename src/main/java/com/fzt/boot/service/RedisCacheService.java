package com.fzt.boot.service;


/**
 * @Description redis缓存服务
 * @Author fengzt
 * @Date 2019/4/8
 **/
public interface RedisCacheService {

    void setString(String key, String value);

    String getString(String key);

    void setObject(String key, Object value);

    Object getObject(String key);
}
