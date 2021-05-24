# Seata 分布式事务 搭建指南
搭建教程参考 https://blog.csdn.net/qq_40548741/article/details/117219071?spm=1001.2014.3001.5501
下载地址 https://github.com/seata/seata/releases

###### 修改file.conf

```
## transaction log store, only used in seata-server
store {
  ## store mode: file、db、redis
  mode = "db"

  ## database store property
  db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp)/HikariDataSource(hikari) etc.
    datasource = "druid"
    ## mysql/oracle/postgresql/h2/oceanbase etc.
    dbType = "mysql"
    driverClassName = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://192.168.164.128:3306/seata"
    user = "root"
    password = "123456"
    minConn = 5
    maxConn = 100
    globalTable = "global_table"
    branchTable = "branch_table"
    lockTable = "lock_table"
    queryLimit = 100
    maxWait = 5000
  }
}
```

###### 修改registry.conf

```
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "nacos"
  loadBalance = "RandomLoadBalance"
  loadBalanceVirtualNodes = 10

  nacos {
    application = "seata-server"
    serverAddr = "127.0.0.1:8848"
    group = "SEATA_GROUP"
    namespace = ""
    cluster = "default"
    username = "nacos"
    password = "nacos"
  }

}

config {
  # file、nacos 、apollo、zk、consul、etcd3
  type = "nacos"

  nacos {
    serverAddr = "127.0.0.1:8848"
    namespace = ""
    group = "SEATA_GROUP"
    username = "nacos"
    password = "nacos"
  }
}
```

修改config.txt文件配置 导入配置到nacos中

```
sh nacos-config.sh -h localhost -p 8848 -g SEATA_GROUP -t 465a28fb-e8f1-48ba-ae78-9dd9d77d166e -u nacos -w nacos
```

docker运行命令

```
docker run --name seata-server \
        -d -p 8091:8091 \
        -e SEATA_IP=192.168.164.128 \
        -e SEATA_PORT=8091 \
        -v /data/seata/conf/file.conf:/seata-server/resources/file.conf  \
        -v /data/seata/conf/registry.conf:/seata-server/resources/registry.conf  \
        seataio/seata-server
```


##### 说明：
db_undo_log.sql 文件中的undo_log表要添加到业务库中，就是要用分布式事务的数据库中

db_store.sql 文件中的表是高可用方式用到的