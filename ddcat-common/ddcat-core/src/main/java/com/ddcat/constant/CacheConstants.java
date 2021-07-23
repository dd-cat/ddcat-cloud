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

    /**
     * 菜单信息缓存
     */
    String MENU_DETAILS = "menu_details";

    /**
     * 用户信息缓存
     */
    String USER_DETAILS = "user_details";

    /**
     * 字典信息缓存
     */
    String DICT_DETAILS = "dict_details";

    /**
     * 参数缓存
     */
    String PARAMS_DETAILS = "params_details";

}
