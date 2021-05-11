package com.ddcat;

import com.ddcat.security.component.CatResourceServerConfigurerAdapter;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Import;

/**
 * 系统管理模块
 *
 * @author dd-cat
 */
@SpringCloudApplication
@EnableDubbo
@MapperScan("com.ddcat.system.mapper")
@Import({CatResourceServerConfigurerAdapter.class})
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
