#### DD-CAT微服务

* 基于SpringCloud alibaba管理系统
* 集成Sentinel、Nacos
* Sharding JDBC分库分表读写分离
* Seata分布式事务
* MyBatis Plus
* SA-TOKEN
* 集成PlumeLog实现分布式日志(==此处暂不实现==)
  （基于log4j、log4j2、logback搜集日志，设置链路ID，方便查询关联日志，基于elasticsearch作为查询引擎）
  [官方文档](https://gitee.com/plumeorg/plumelog/blob/master/FASTSTART.md)

#### 模块说明

```
ddcat-cloud
├── auth -- 授权模块
├── common -- 公共模块
├    ├── api -- api模块
├    ├── core -- 核心模块
├    ├── nacos -- Nacos模块
├    ├── redis -- Redis模块
├    └── security -- 权限模块
├── modules -- 业务模块
├    ├── job -- 任务中心
├    ├── mq -- 消息中心
└──  └── system -- 系统管理 10001
├── native
└──  └── gateway -- 网关 10000
```

#### [文档地址](https://docusaurus-2-zyl-dream.vercel.app/docs/doc1) (搭建中)
