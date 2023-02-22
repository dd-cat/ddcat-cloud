###### 拉取镜像
```yml
docker pull nacos/nacos-server
```

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
