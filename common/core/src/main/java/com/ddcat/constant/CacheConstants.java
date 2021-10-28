package com.ddcat.constant;

/**
 * 缓存的key 常量
 *
 * @author dd-cat
 */
public interface CacheConstants {
    /**
     * 用来存储oauth的token
     */
    String REDIS_TOKEN_KEY = "oauth:token:";
    /**
     * 字典
     */
    String DICT = "dict:";
    /**
     * 角色菜单
     */
    String ROLE_MENU = "role:menu:";
}
