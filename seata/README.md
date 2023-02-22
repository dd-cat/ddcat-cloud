# Seata 分布式事务 搭建指南
搭建教程参考 https://seata.io/zh-cn/docs/ops/deploy-by-docker-compose.html

# 导入配置
sh nacos-config.sh -h localhost -p 8848 -g SEATA_GROUP -t f4b1bcc5-1b20-47af-81f7-6147aaea0f7d -u nacos -w nacos
