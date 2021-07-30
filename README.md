### DD-CAT微服务
* 基于SpringCloud alibaba管理系统
* 集成Sentinel、Nacos
* Sharding JDBC分库分表读写分离
* Seata分布式事务
* MyBatis Plus
* SpringSecurity OAuth2
* 集成PlumeLog实现分布式日志(==此处暂不实现==)
（基于log4j、log4j2、logback搜集日志，设置链路ID，方便查询关联日志，基于elasticsearch作为查询引擎）
[官方文档](https://gitee.com/plumeorg/plumelog/blob/master/FASTSTART.md)

#### 模块说明
```
ddcat-cloud
├── ddcat-auth -- 授权模块
├── ddcat-common -- 公共模块
├    ├── ddcat-api -- api模块
├    ├── ddcat-core -- 核心模块
├    ├── ddcat-nacos -- Nacos模块
├    ├── ddcat-redis -- Redis模块
├    └── ddcat-security -- 权限模块
├── ddcat-modules -- 业务模块
├    ├── ddcat-job -- 任务中心
├    ├── ddcat-mq -- 消息中心
└──  └── ddcat-system -- 系统管理 10001
├── ddcat-native
└──  └── ddcat-gateway -- 网关 10000
```
