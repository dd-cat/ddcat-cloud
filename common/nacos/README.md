###### 搜索镜像
```yml
docker search nacos
```

###### 拉取镜像(默认最新版本 现在最新版是2.0)
```yml
docker pull nacos/server
```

######  /data/nacos/conf下创建application.properties
```yml
server.servlet.contextPath=/nacos
server.port=8848

spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://192.168.164.128:3308/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user.0=root
db.password.0=123456

db.pool.config.connectionTimeout=30000
db.pool.config.validationTimeout=10000
db.pool.config.maximumPoolSize=20
db.pool.config.minimumIdle=2

acos.naming.empty-service.auto-clean=true
nacos.naming.empty-service.clean.initial-delay-ms=50000
nacos.naming.empty-service.clean.period-time-ms=30000

management.metrics.export.influx.enabled=false

server.tomcat.accesslog.enabled=true

server.tomcat.accesslog.pattern=%h %l %u %t "%r" %s %b %D %{User-Agent}i %{Request-Source}i

server.tomcat.basedir=

nacos.security.ignore.urls=/,/error,/**/*.css,/**/*.js,/**/*.html,/**/*.map,/**/*.svg,/**/*.png,/**/*.ico,/console-ui/public/**,/v1/auth/**,/v1/console/health/**,/actuator/**,/v1/console/server/**

nacos.core.auth.system.type=nacos

nacos.core.auth.enabled=false

nacos.core.auth.default.token.expire.seconds=18000

nacos.core.auth.default.token.secret.key=SecretKey012345678901234567890123456789012345678901234567890123456789

nacos.core.auth.caching.enabled=true

nacos.core.auth.enable.userAgentAuthWhite=true

nacos.core.auth.server.identity.key=
nacos.core.auth.server.identity.value=

nacos.istio.mcp.server.enabled=false
```
==主要修改mysql链接部分内容，其它参数具体详情可到官网查看==


###### 运行容器
```yml
docker run --env MODE=standalone --name nacos -d -p 8848:8848 -p 9848:9848 -p 9849:9849 -v /data/nacos/conf/application.properties:/home/nacos/conf/application.properties nacos/nacos-server
```

Nacos2.0版本相比1.X新增了gRPC的通信方式，因此需要增加2个端口。新增端口是在配置的主端口(server.port)基础上，进行一定偏移量自动生成。
|端口|	与主端口的偏移量	|描述
|  ----  | ----  | ----  |
|9848|	1000|	客户端gRPC请求服务端端口，用于客户端向服务端发起连接和请求
|9849|	1001|	服务端gRPC请求服务端端口，用于服务间同步等
==2.0启动 要开放 9848和9849端口==