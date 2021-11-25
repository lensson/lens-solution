# lens-compose

Port List

``` lua

---- Database ----
lens-mariadb:                   172.28.0.11     33306:3306
lens-mariadb-adminer:           172.28.0.12     38080:8080
lens-redis:                     172.28.0.13     6379:6379
---- Infra ----
lens-nginx:                     172.28.0.80     80:80           443:443 
lens-rabbitmq:                  172.28.0.23     5672:5672       15672:15672
lens-nacos:                     172.28.0.21     8848:8848       9555:9555
lens-gateway:                   172.28.0.49     8849:8849
lens-auth:                      172.28.0.50     8850:8850
lens-nsgateway:                 172.28.0.51     8851:8851
lens-sentinel:                  172.28.0.24     8718:8080       8719:8719
lens-solr:                      172.28.0.25     8983:8983
---- Blog ----

lens-blog-vue-frontend:         172.28.0.181    8001:80
lens-blog-admin-vue-frontend:   172.28.0.182    8002:80
lens-blog-backend:              172.28.0.101    9001:9001
lens-blog-admin-backend:        172.28.0.102    9002:9002
lens-blog-picture:              172.28.0.112    9012:9012
lens-blog-search:               172.28.0.113    9013:9013
lens-blog-spider:               172.28.0.114    9014:9014
lens-blog-sms:                  172.28.0.111    9011:9011
lens-blog-monitor:              172.28.0.120    9020:9020



```

| Docker容器                   | 内部IP       | 外部端口/内部端口 | 域名                   | Memo   |
| ---------------------------- | ------------ | ----------------- | ---------------------- | ------ |
| **---- Database ----**       | ——————       | ——————            | ——————                 | —————— |
| lens-mariadb                 | 172.28.0.11  | 33306:3306        |                        |        |
| lens-mariadb-adminer         | 172.28.0.12  | 38080:8080        | db.malakj.com          |        |
| lens-redis                   | 172.28.0.13  | 6379:6379         |                        |        |
| **---- Infra ----**          | ——————       | ——————            | ——————                 | —————— |
| lens-nginx                   | 172.28.0.80  | 80:80             | ***                    |        |
|                              |              | 443:443           |                        |        |
| lens-nacos                   | 172.28.0.21  | 8848:8848         | nacos.malakj.com/nacos |        |
|                              |              | 9555:9555         |                        |        |
| lens-zipkin                  | 172.28.0.22  | 9411:9411         | malakj.com/zipkin      |        |
| lens-rabbitmq                | 172.28.0.23  | 5672:5672         |                        |        |
|                              |              | 15672:15672       |                        |        |
| lens-sentinel                | 172.28.0.24  | 8718:8080         |                        |        |
|                              |              | 8719:8719         |                        |        |
|                              |              |                   |                        |        |
| lens-solr                    | 172.28.0.25  | 8983:8983         |                        |        |
| lens-gateway                 | 172.28.0.49  | 8849:8849         |                        |        |
| lens-auth                    | 172.28.0.50  | 8850:8850         |                        |        |
| lens-nsgateway               | 172.28.0.51  | 8851:8851         |                        |        |
| **---- Blog ----**           | ——————       | ——————            | ——————                 | —————— |
| lens-blog-vue-frontend       | 172.28.0.181 | 8001:80           | blog.malakj.com        |        |
| lens-blog-backend            | 172.28.0.101 | 9001:9001         |                        |        |
| lens-blog-admin-vue-frontend | 172.28.0.182 | 8002:80           |                        |        |
| lens-blog-admin-backend      | 172.28.0.102 | 9002:9002         | admin.blog.malakj.com  |        |
| lens-blog-sms                | 172.28.0.111 | 9011:9011         |                        |        |
| lens-blog-picture            | 172.28.0.112 | 9012:9012         |                        |        |
| lens-blog-search             | 172.28.0.113 | 9013:9013         |                        |        |
| lens-blog-spider             | 172.28.0.114 | 9014:9014         |                        |        |
| lens-blog-monitor            | 172.28.0.120 | 9020:9020         |                        |        |
| **---- WX ----**             | ——————       | ——————            | ——————                 | —————— |
| lens-gzh-server              | 172.28.0.131 | 9031:9031         |                        |        |
| lens-gzh-frontend            | 172.28.0.171 | 8071:8071         | admin.gzh.malakj.com   |        |
|                              |              |                   |                        |        |
|                              |              |                   |                        |        |
|                              |              |                   |                        |        |
|                              |              |                   |                        |        |
|                              |              |                   |                        |        |
|                              |              |                   |                        |        |
|                              |              |                   |                        |        |



