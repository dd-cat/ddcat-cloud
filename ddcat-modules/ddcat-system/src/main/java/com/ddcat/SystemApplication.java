package com.ddcat;

import cn.dev33.satoken.spring.SaTokenSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 系统管理模块
 *
 * @author dd-cat
 */
@SaTokenSetup    // sa-token权限验证
@EnableCaching // 启用缓存
@SpringCloudApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
