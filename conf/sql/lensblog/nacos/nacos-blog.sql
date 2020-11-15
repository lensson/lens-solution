INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (27, 'mogu-admin.yaml', 'dev', '#app
server:
  port: 8601

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号
signName: 蘑菇博客
#项目名称
PROJECT_NAME: 蘑菇博客

file:
  upload:
    path: D:/mogu_blog/data/

# 邮箱验证
moguBlog:
  email: mogublog@163.com

# 蘑菇博客登录默认密码
DEFAULE_PWD: mogu2018

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐

#spring
spring:
  jackson:
    serialization:
      INDENT_OUTPUT: true
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Shanghai
  jmx:
    default-domain: mogu_admin
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-admin
  security:
    user:
      name: user
      password: password123

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    # 初始化大小，最小，最大
    initialSize: 20
    minIdle: 5
    maxActive: 200

    #连接等待超时时间
    maxWait: 60000

    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000

    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000

    validationQuery: SELECT 1 FROM DUAL

    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180

    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: guest
    password: guest

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8601

##eureka相关配置
#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    registerWithEureka: true
#    fetchRegistry: true
#    serviceUrl:
#      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5
  
  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848


# 或者：
feign.hystrix.enabled: false #索性禁用feign的hystrix支持

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.commons.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

##jwt配置
tokenHead: bearer_
tokenHeader: Authorization
isRememberMeExpiresSecond: 259200 #记住账号为3天有效
audience:
  clientId: 098f6bcd4621d373cade4e832627b4f6
  base64Secret: MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=
  name: mogublog
  expiresSecond: 3600  #1个小时 3600
  refreshSecond: 300 # 刷新token的时间 5分钟', 'ce8eef81522776ceefe77d670af17d49', '2020-06-20 09:47:10', '2020-06-20 09:47:10', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', '蘑菇博客 admin  dev配置', null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (28, 'mogu-gateway.yaml', 'dev', 'server:
  port: 8607

spring:
  application:
    name: mogu-gateway
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
      config:
        server-addr: localhost:8848
        file-extension: yaml
        group: dev
', 'b3aafe1d3548e30b9a50e5b83e76322c', '2020-06-20 09:53:50', '2020-06-20 09:53:50', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (29, 'mogu-monitor.yaml', 'dev', 'server:
  port: 8606

spring:
  application:
    name: mogu-monitor
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      ui:
        title: 蘑菇博客监控中心
        brand: 蘑菇博客监控中心
      notify:
        mail:
          enabled: false
          # 服务上下线会自动发送邮件
          #from: mogublog@163.com
          #to: moxi0624@163.com

  #mail
  mail:
    username: mogublog@163.com
    password: a1313375 #授权码开启SMTP服务里设置
    host: smtp.163.com

    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
          ssl:
            enable: true

#eureka相关配置
#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    serviceUrl:
#      defaultZone: http://user:password123@localhost:8761/eureka
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    health-check-url-path: /actuator/health
#    metadata-map:
#      user.name: admin
#      user.password: 123456
#    lease-renewal-interval-in-seconds: 5

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848', '2fa47a5fe46b4bff73827e388adff194', '2020-06-20 09:54:17', '2020-06-20 09:54:17', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (30, 'mogu-picture.yaml', 'dev', '#app
server:
  port: 8602

file:
  upload:
    path: D:/mogu_blog/data/

#spring
spring:
  servlet:
    multipart:
      enabled: true
      max-file-size: 100MB # 修改单次文件上传文件大小不能超过100MB
      max-request-size: 500MB # 设置单次文件请求总大小不能超过500MB

  jmx:
    default-domain: mogu_picture
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-picture
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8602

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    #password: mogu2018  # 客户端没有设置密码，服务器中redis默认密码为 mogu2018

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_picture?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
  mvc:
    static-path-pattern: /upload/**
  resources:
    static-locations: classpath:/static/upload

# eureka:
#   client:
#     healthcheck:
#       enabled: true
#     registerWithEureka: true
#     fetchRegistry: true
#     serviceUrl:
#       defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#   instance:
#     prefer-ip-address: true
#     instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#     lease-renewal-interval-in-seconds: 5
#     appname: mogu-picture

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.picture.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false', 'ae1488fad68d12c0c21657b10cc786ee', '2020-06-20 09:54:42', '2020-06-20 09:54:42', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (31, 'mogu-sms.yaml', 'dev', '#app
server:
  port: 8604

#阿里大于
accessKeyId: XXXXXXXXXXXXXXXXXXXXX #修改成自己的
accessKeySecret: XXXXXXXXXXXXXXXXXXXXXXX #修改成自己的

#spring
spring:
  jmx:
    default-domain: mogu_sms
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-sms
  security:
    user:
      name: user
      password: password123
  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  #RabbitMq
  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: guest
    password: guest

  #mail
  mail:
    username: mogublog@163.com
    password: a1313375 #授权码开启SMTP服务里设置
    host: smtp.163.com
    default-encoding: UTF-8
    properties:
      mail:
        smtp:
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
          auth: true
          starttls:
            enable: false

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8604

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    serviceUrl:
#      defaultZone: http://user:password123@localhost:8761/eureka
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always', 'c305f6be9a4ba0cad2103891517aa4af', '2020-06-20 09:55:01', '2020-06-20 09:55:01', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (32, 'mogu-spider.yaml', 'dev', '#app
server:
  port: 8608

#spring
spring:
  jmx:
    default-domain: mogu_spider
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-spider
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8608

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    registerWithEureka: true
#    fetchRegistry: true
#    serviceUrl:
#      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5
#    appname: mogu-spider

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.spider.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false', '93264bdf76cc2b0384ce28d2f2463811', '2020-06-20 09:55:19', '2020-06-20 09:55:19', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (33, 'mogu-web.yaml', 'dev', '#app
server:
  port: 8603

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号

signName: 蘑菇博客
# 项目英文名
PROJECT_NAME_EN: moguBlog
#项目名称
PROJECT_NAME: 蘑菇博客

data:
  # 门户页面
  webSite:
    url: http://localhost:9527/#/
  # mogu_web网址，用于第三方登录回调
  web:
    url: http://127.0.0.1:8603

file:
  upload:
    path: D:/mogu_blog/data/

# 蘑菇博客登录默认密码
DEFAULE_PWD: mogu2018

#请求限制参数
request-limit:
  start: false # 是否开启请求限制，默认关闭
  amount: 100 # 100次
  time: 60000 # 1分钟

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  HOT_TAG_COUNT: 20 #热门标签数量
  FRIENDLY_LINK_COUNT: 20 #友情链接数
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐
  USER_TOKEN_SURVIVAL_TIME: 168 # toekn令牌存活时间, 7天  168 = 7*24

  # 原创模板
  ORIGINAL_TEMPLATE: 本文为蘑菇博客原创文章，转载无需和我联系，但请注明来自蘑菇博客 http://www.moguit.cn
  # 转载模板
  REPRINTED_TEMPLATE: 本着开源共享、共同学习的精神，本文转载自 %S ，版权归 %S 所有，如果侵权之处，请联系博主进行删除，谢谢~

#spring
spring:
  jmx:
    default-domain: mogu_web
  # freemarker相关配置
  freemarker:
    charset: utf-8
    suffix: .ftl
    content-type: text/html
    template-loader-path: classpath:/templates
  # jackson配置响应时间格式、时区
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Shanghai

  application:
    name: mogu-web
  security:
    user:
      name: user
      password: password123

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    # 初始化大小，最小，最大
    initialSize: 5
    minIdle: 5
    maxActive: 50

    #连接等待超时时间
    maxWait: 60000

    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000

    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000

    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180

    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  #Solr配置信息
  data:
    solr:
      host: http://localhost:8080/solr
      core: collection1
      repositories:
        enabled: true

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: guest
    password: guest

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8603

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

#eureka相关配置
#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    registerWithEureka: true
#    fetchRegistry: true
#    serviceUrl:
#      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848

# 或者：
feign.hystrix.enabled: false # 索性禁用feign的hystrix支持
# 设置feign调用超时时间
ribbon:
  ReadTimeout: 20000
  ConnectTimeout: 20000

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.commons.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

# 第三方登录，参考 http://moguit.cn/#/info?blogUid=fe9e352eb95205a08288f21ec3cc69e0
justAuth:
  clientId:
    gitee: ec2dba332701caa209935512c69fc7962530b8619acd9b6cb03106a7c13c1c5e # 改成自己的
    github: c99bfe31f8774ec8e242 # 改成自己的
    qq: XXXXXXXXXXXXXXX  # 改成自己的
  clientSecret:
    gitee: 993930de16b61b8146f7d30c693afd328b4d42116cf2da748f275077e4ef5e47 # 改成自己的
    github: ec088d14ab8076e2beed58fcb95e37a0fc586618 # 改成自己的
    qq: XXXXXXXXXXXXXXXXXX # 改成自己的', '233689198acc543aa89350d3f23058a2', '2020-06-20 09:56:24', '2020-06-20 09:56:24', null, '0:0:0:0:0:0:0:1', '', 'f431bd53-e6c6-451c-803c-b32712f38562', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (38, 'mogu-admin-dev.yaml', 'dev', '#app
server:
  port: 8601

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号
signName: 蘑菇博客
#项目名称
PROJECT_NAME: 蘑菇博客

file:
  upload:
    path: d:/mogu_data

# 邮箱验证
moguBlog:
  email: mogublog@163.com

# 蘑菇博客登录默认密码
DEFAULE_PWD: mogu2018

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐

#spring
spring:
  jackson:
    serialization:
      INDENT_OUTPUT: true
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Shanghai
  jmx:
    default-domain: mogu_admin
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-admin
  security:
    user:
      name: user
      password: password123

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    # 初始化大小，最小，最大
    initialSize: 20
    minIdle: 5
    maxActive: 200

    #连接等待超时时间
    maxWait: 60000

    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000

    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000

    validationQuery: SELECT 1 FROM DUAL

    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180

    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: guest
    password: guest

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8601

##eureka相关配置
#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    registerWithEureka: true
#    fetchRegistry: true
#    serviceUrl:
#      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5
  
  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848


# 或者：
feign.hystrix.enabled: false #索性禁用feign的hystrix支持

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.commons.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

##jwt配置
tokenHead: bearer_
tokenHeader: Authorization
isRememberMeExpiresSecond: 259200 #记住账号为3天有效
audience:
  clientId: 098f6bcd4621d373cade4e832627b4f6
  base64Secret: MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=
  name: mogublog
  expiresSecond: 3600  #1个小时 3600
  refreshSecond: 300 # 刷新token的时间 5分钟', '0e5ee980ae4d9f5725c718e7495ab593', '2020-06-20 10:20:17', '2020-06-20 09:15:35', null, '192.168.1.1', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (39, 'mogu-gateway-dev.yaml', 'dev', 'server:
  port: 8607

spring:
  application:
    name: mogu-gateway
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
      config:
        server-addr: localhost:8848
        file-extension: yaml
        group: dev
', 'b3aafe1d3548e30b9a50e5b83e76322c', '2020-06-20 10:20:17', '2020-06-20 10:20:17', null, '0:0:0:0:0:0:0:1', '', 'dev', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (40, 'mogu-monitor-dev.yaml', 'dev', 'server:
  port: 8606

spring:
  application:
    name: mogu-monitor
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      ui:
        title: 蘑菇博客监控中心
        brand: 蘑菇博客监控中心
      notify:
        mail:
          enabled: false
          # 服务上下线会自动发送邮件
          #from: mogublog@163.com
          #to: moxi0624@163.com

  #mail
  mail:
    username: mogublog@163.com
    password: a1313375 #授权码开启SMTP服务里设置
    host: smtp.163.com

    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
          ssl:
            enable: true

#eureka相关配置
#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    serviceUrl:
#      defaultZone: http://user:password123@localhost:8761/eureka
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    health-check-url-path: /actuator/health
#    metadata-map:
#      user.name: admin
#      user.password: 123456
#    lease-renewal-interval-in-seconds: 5

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848', '2fa47a5fe46b4bff73827e388adff194', '2020-06-20 10:20:17', '2020-06-20 10:20:17', null, '0:0:0:0:0:0:0:1', '', 'dev', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (41, 'mogu-picture-dev.yaml', 'dev', '#app
server:
  port: 8602

file:
  upload:
    path: D:/mogu_blog/data/

#spring
spring:
  servlet:
    multipart:
      enabled: true
      max-file-size: 100MB # 修改单次文件上传文件大小不能超过100MB
      max-request-size: 500MB # 设置单次文件请求总大小不能超过500MB

  jmx:
    default-domain: mogu_picture
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-picture
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8602

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    #password: mogu2018  # 客户端没有设置密码，服务器中redis默认密码为 mogu2018

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_picture?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
  mvc:
    static-path-pattern: /upload/**
  resources:
    static-locations: classpath:/static/upload

# eureka:
#   client:
#     healthcheck:
#       enabled: true
#     registerWithEureka: true
#     fetchRegistry: true
#     serviceUrl:
#       defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#   instance:
#     prefer-ip-address: true
#     instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#     lease-renewal-interval-in-seconds: 5
#     appname: mogu-picture

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.picture.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false', 'ae1488fad68d12c0c21657b10cc786ee', '2020-06-20 10:20:17', '2020-06-20 10:20:17', null, '0:0:0:0:0:0:0:1', '', 'dev', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (42, 'mogu-search-dev.yaml', 'dev', 'server:
  port: 8605
spring:
  application:
    name: mogu_search
  jmx:
    default-domain: mogu_search
  security:
    user:
      name: user
      password: password123
  data:
    elasticsearch:
      cluster-name: elasticsearch
      cluster-nodes: localhost:9300
  #    solr:
  #      host: http://localhost:8080/solr
  #      core: collection1
  #      repositories:
  #        enabled: true

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
      instance:
        service-base-url: http://localhost:8605

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    registerWithEureka: true
#    fetchRegistry: true
#    serviceUrl:
#      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always', 'f999a529bd3778e88f8f9f96434f7dc7', '2020-06-20 10:20:17', '2020-06-20 10:20:17', null, '0:0:0:0:0:0:0:1', '', 'dev', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (43, 'mogu-sms-dev.yaml', 'dev', '#app
server:
  port: 8604

#阿里大于
accessKeyId: XXXXXXXXXXXXXXXXXXXXX #修改成自己的
accessKeySecret: XXXXXXXXXXXXXXXXXXXXXXX #修改成自己的

#spring
spring:
  jmx:
    default-domain: mogu_sms
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-sms
  security:
    user:
      name: user
      password: password123
  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  #RabbitMq
  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: guest
    password: guest

  #mail
  mail:
    username: mogublog@163.com
    password: a1313375 #授权码开启SMTP服务里设置
    host: smtp.163.com
    default-encoding: UTF-8
    properties:
      mail:
        smtp:
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
          auth: true
          starttls:
            enable: false

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8604

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

#eureka:
#  client:
#    healthcheck:
#      enabled: true
#    serviceUrl:
#      defaultZone: http://user:password123@localhost:8761/eureka
#  instance:
#    prefer-ip-address: true
#    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
#    lease-renewal-interval-in-seconds: 5

  #nacos相关配置
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always', 'c305f6be9a4ba0cad2103891517aa4af', '2020-06-20 10:20:17', '2020-06-20 10:20:17', null, '0:0:0:0:0:0:0:1', '', 'dev', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (58, 'mogu-spider-dev.yaml', 'dev', '#app
server:
  port: 8608

#spring
spring:
  jmx:
    default-domain: mogu_spider
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-spider
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8608

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

eureka:
  client:
    healthcheck:
      enabled: true
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
  instance:
    prefer-ip-address: true
    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
    lease-renewal-interval-in-seconds: 5
    appname: mogu-spider

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.spider.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false', 'f86c184436ef51e51040f7f793a30b6f', '2020-06-20 10:45:53', '2020-06-20 10:45:53', null, '0:0:0:0:0:0:0:1', '', 'dev', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (59, 'mogu-web-dev.yaml', 'dev', '#app
server:
  port: 8603

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号

signName: 蘑菇博客
# 项目英文名
PROJECT_NAME_EN: moguBlog
#项目名称
PROJECT_NAME: 蘑菇博客

data:
  # 门户页面
  webSite:
    url: http://localhost:9527/#/
  # mogu_web网址，用于第三方登录回调
  web:
    url: http://127.0.0.1:8603

file:
  upload:
    path: D:/mogu_blog/data/

# 蘑菇博客登录默认密码
DEFAULE_PWD: mogu2018

#请求限制参数
request-limit:
  start: false # 是否开启请求限制，默认关闭
  amount: 100 # 100次
  time: 60000 # 1分钟

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  HOT_TAG_COUNT: 20 #热门标签数量
  FRIENDLY_LINK_COUNT: 20 #友情链接数
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐
  USER_TOKEN_SURVIVAL_TIME: 168 # toekn令牌存活时间, 7天  168 = 7*24

  # 原创模板
  ORIGINAL_TEMPLATE: 本文为蘑菇博客原创文章，转载无需和我联系，但请注明来自蘑菇博客 http://www.moguit.cn
  # 转载模板
  REPRINTED_TEMPLATE: 本着开源共享、共同学习的精神，本文转载自 %S ，版权归 %S 所有，如果侵权之处，请联系博主进行删除，谢谢~

#spring
spring:
  jmx:
    default-domain: mogu_web
  # freemarker相关配置
  freemarker:
    charset: utf-8
    suffix: .ftl
    content-type: text/html
    template-loader-path: classpath:/templates
  # jackson配置响应时间格式、时区
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Shanghai

  application:
    name: mogu-web
  security:
    user:
      name: user
      password: password123

  # DATABASE CONFIG
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    # 初始化大小，最小，最大
    initialSize: 5
    minIdle: 5
    maxActive: 50

    #连接等待超时时间
    maxWait: 60000

    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000

    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000

    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180

    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  #Solr配置信息
  data:
    solr:
      host: http://localhost:8080/solr
      core: collection1
      repositories:
        enabled: true

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    #password: mogu2018  # 客户端没有设置密码，服务器中redis默认密码为 mogu2018

  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: guest
    password: guest

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8603

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

#eureka相关配置
eureka:
  client:
    healthcheck:
      enabled: true
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
  instance:
    prefer-ip-address: true
    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
    lease-renewal-interval-in-seconds: 5

# 或者：
feign.hystrix.enabled: false # 索性禁用feign的hystrix支持
# 设置feign调用超时时间
ribbon:
  ReadTimeout: 20000
  ConnectTimeout: 20000

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.commons.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

# 第三方登录，参考 http://moguit.cn/#/info?blogUid=fe9e352eb95205a08288f21ec3cc69e0
justAuth:
  clientId:
    gitee: ec2dba332701caa209935512c69fc7962530b8619acd9b6cb03106a7c13c1c5e
    github: c99bfe31f8774ec8e242
    qq: XXXXXXXXXXXXXXX  # 改成自己的
  clientSecret:
    gitee: 993930de16b61b8146f7d30c693afd328b4d42116cf2da748f275077e4ef5e47
    github: ec088d14ab8076e2beed58fcb95e37a0fc586618
    qq: XXXXXXXXXXXXXXXXXX # 改成自己的

# uniapp相关配置
uniapp:
  qq:
    appid: 1110769790
    secret: zWZBLzBcekMUTP60
    grant_type: authorization_code', '030e258bb5ec438fca68d4c82724bd54', '2020-06-20 10:47:34', '2020-08-12 13:26:53', null, '183.218.60.51', '', 'dev', '蘑菇博客dev环境配置', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (70, 'mogu-admin-prod.yaml', 'prod', '#app
server:
  port: 8601

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号
signName: 蘑菇博客

#项目名称
PROJECT_NAME: 蘑菇博客

file:
  upload:
    path: /home/mogu_blog/mogu_data/

# 邮箱验证
moguBlog:
  email: mogublog@163.com

# 蘑菇博客后台登录默认密码
DEFAULE_PWD: mogu2018

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐

#spring
spring:
  jackson:
    serialization:
      INDENT_OUTPUT: true
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Shanghai
  jmx:
    default-domain: mogu_admin
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-admin
  security:
    user:
      name: user
      password: password123


  # DATABASE CONFIG
  datasource:
    username: root
    password: mogu2018
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    # 初始化大小，最小，最大
    initialSize: 20
    minIdle: 5
    maxActive: 200

    #连接等待超时时间
    maxWait: 60000

    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000

    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000

    validationQuery: SELECT 1 FROM DUAL

    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180

    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    password: mogu2018

  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: admin
    password: mogu2018

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8601

# 禁用feign的hystrix支持
feign.hystrix.enabled: false

#ribbon的超时时间 30秒
ribbon:
  ReadTimeout: 30000
  ConnectTimeout: 30000

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.commons.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

##jwt配置
tokenHead: bearer_
tokenHeader: Authorization
isRememberMeExpiresSecond: 259200 #记住账号为3天有效
audience:
  clientId: 098f6bcd4621d373cade4e832627b4f6
  base64Secret: MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=
  name: mogublog
  expiresSecond: 3600  #1个小时 3600
  refreshSecond: 300 # 刷新token的时间 5分钟', '5b7b5e7947af36da65ee02464b4e459e', '2020-06-20 09:28:52', '2020-09-18 13:30:52', null, '116.1.3.239', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (71, 'mogu-gateway-prod.yaml', 'prod', 'server:
  port: 8607

spring:
  application:
    name: mogu-gateway
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
      config:
        server-addr: localhost:8848
        file-extension: yaml
        group: dev
', 'b3aafe1d3548e30b9a50e5b83e76322c', '2020-06-20 09:28:52', '2020-06-20 09:28:52', null, '192.168.1.1', '', 'prod', null, null, null, 'yaml', null);
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (72, 'mogu-monitor-prod.yaml', 'prod', 'server:
  port: 8606

spring:
  application:
    name: mogu-monitor
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      ui:
        title: 蘑菇博客监控中心
        brand: 蘑菇博客监控中心
      notify:
        mail:
          enabled: false
          # 服务上下线会自动发送邮件
          from: mogublog@163.com
          to: moxi0624@163.com

  #mail
  mail:
    username: mogublog@163.com  # 改成自己的
    password: a1313375 #授权码开启SMTP服务里设置，改成自己的
    host: smtp.163.com

    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
          ssl:
            enable: true', '4ffa41149ca0c00d9878425afb834048', '2020-06-20 09:28:52', '2020-06-20 11:45:21', null, '192.168.1.1', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (73, 'mogu-picture-prod.yaml', 'prod', '#app
server:
  port: 8602

file:
  upload:
    path: /home/mogu_blog/mogu_data/

#spring
spring:
  servlet:
    multipart:
      enabled: true
      max-file-size: 100MB # 修改单次文件上传文件大小不能超过10MB
      max-request-size: 500MB # 设置单次文件请求总大小不能超过50MB

  jmx:
    default-domain: mogu_picture
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-picture
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8602

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    password: mogu2018
          
          
  # DATABASE CONFIG
  datasource:
    username: root
    password: mogu2018
    url: jdbc:mysql://localhost:3306/mogu_picture?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.picture.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false', '2ae44d1430720726f5e7ee3a38df26c9', '2020-06-20 09:28:52', '2020-08-22 09:25:51', null, '192.168.1.102', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (74, 'mogu-search-prod.yaml', 'prod', 'server:
  port: 8605
spring:
  application:
    name: mogu-search
  jmx:
    default-domain: mogu-search
  security:
    user:
      name: user
      password: password123
  data:
    #    elasticsearch:
    #      cluster-name: elasticsearch
    #      cluster-nodes: localhost:9300
    solr:
      host: http://localhost:8080/solr
      core: collection1
      repositories:
        enabled: true

  #  jackson:
  #    default-property-inclusion: non_null
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8605

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always', 'bd718705e45381fd75dcf0a35251be84', '2020-06-20 09:28:52', '2020-09-18 13:34:08', null, '116.1.3.239', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (75, 'mogu-sms-prod.yaml', 'prod', '#app
server:
  port: 8604

#阿里大于
accessKeyId: XXXXXXXXXXXXXXXXXXXXXXXXX #修改成自己的
accessKeySecret: XXXXXXXXXXXXXXXXXXXXXXXXXX #修改成自己的

#spring
spring:
  jmx:
    default-domain: mogu_sms
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-sms

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    password: mogu2018

  #RabbitMq
  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: admin
    password: mogu2018

  #mail
  mail:
    username: mogublog@163.com # 修改成自己的
    password: a1313375 #授权码开启SMTP服务里设置，这里修改成自己的
    host: smtp.163.com
    default-encoding: UTF-8
    properties:
      mail:
        smtp:
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
          auth: true
          starttls:
            enable: false
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8604

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always', 'c74122e9b40089504325fac44f11c5be', '2020-06-20 09:28:52', '2020-08-22 10:07:32', null, '192.168.1.102', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (76, 'mogu-spider-prod.yaml', 'prod', '#app
server:
  port: 8608

#spring
spring:
  jmx:
    default-domain: mogu_spider
  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: mogu-spider
  security:
    user:
      name: user
      password: password123
  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8608

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    password: mogu2018

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

  # DATABASE CONFIG
  datasource:
    username: root
    password: mogu2018
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.spider.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false', 'cb6fd0b8ad533cbd0c7f7675ed98ef70', '2020-06-20 09:28:52', '2020-06-20 11:41:24', null, '192.168.1.1', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (77, 'mogu-web-prod.yaml', 'prod', '#app
server:
  port: 8603

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号

signName: 蘑菇博客
# 项目英文名
PROJECT_NAME_EN: moguBlog
#项目名称
PROJECT_NAME: 蘑菇博客

data:
  # 门户页面
  webSite:
    url: http://nacosweb.moguit.cn/#/
  # mogu_web网址，用于第三方登录回调
  web:
    url: http://120.78.126.96:8603

file:
  upload:
    path: /home/mogu_blog/mogu_data/

# 蘑菇博客登录默认密码
DEFAULE_PWD: mogu2018

#请求限制参数
request-limit:
  start: false # 是否开启请求限制，默认关闭
  amount: 100 # 100次
  time: 60000 # 1分钟

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  HOT_TAG_COUNT: 20 #热门标签数量
  FRIENDLY_LINK_COUNT: 20 #友情链接数
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐
  USER_TOKEN_SURVIVAL_TIME: 168 # toekn令牌存活时间, 7天  168 = 7*24

  # 原创模板
  ORIGINAL_TEMPLATE: 本文为蘑菇博客原创文章，转载无需和我联系，但请注明来自蘑菇博客 http://www.moguit.cn
  # 转载模板
  REPRINTED_TEMPLATE: 本着开源共享、共同学习的精神，本文转载自 %S ，版权归 %S 所有，如果侵权之处，请联系博主进行删除，谢谢~

#spring
spring:
  jmx:
    default-domain: mogu_web
  # freemarker相关配置
  freemarker:
    charset: utf-8
    suffix: .ftl
    content-type: text/html
    template-loader-path: classpath:/templates
  # jackson配置响应时间格式、时区
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Shanghai

  application:
    name: mogu-web
  security:
    user:
      name: user
      password: password123

  # DATABASE CONFIG
  datasource:
    username: root
    password: mogu2018
    url: jdbc:mysql://localhost:3306/mogu_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    # 初始化大小，最小，最大
    initialSize: 5
    minIdle: 5
    maxActive: 50

    #连接等待超时时间
    maxWait: 60000

    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000

    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000

    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180

    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  #Solr配置信息
  data:
    solr:
      host: http://localhost:8080/solr
      core: collection1
      repositories:
        enabled: true

  #redis
  redis:
    host: 127.0.0.1 #redis的主机ip
    port: 6379
    password: mogu2018  # 客户端没有设置密码，服务器中redis默认密码为 mogu2018

  rabbitmq:
    host: 127.0.0.1 #rabbitmq的主机ip
    port: 5672
    username: admin
    password: mogu2018

  boot:
    admin:
      client:
        enabled: true
        url: http://localhost:8606
        username: user
        password: password123
        instance:
          service-base-url: http://localhost:8603

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://localhost:9411  # 指定了Zipkin服务器的地址

#eureka相关配置
eureka:
  client:
    healthcheck:
      enabled: true
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8761/eureka/
  instance:
    prefer-ip-address: true
    instance-id: ${spring.application.name}:${spring.cloud.client.ip-address}:${spring.application.instance_id:${server.port}}
    lease-renewal-interval-in-seconds: 5

# 或者：
feign.hystrix.enabled: false # 索性禁用feign的hystrix支持
# 设置feign调用超时时间
ribbon:
  ReadTimeout: 20000
  ConnectTimeout: 20000

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.moxi.mogublog.commons.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

# 第三方登录，参考 http://moguit.cn/#/info?blogUid=fe9e352eb95205a08288f21ec3cc69e0
justAuth:
  clientId:
    gitee: ec2dba332701caa209935512c69fc7962530b8619acd9b6cb03106a7c13c1c5e
    github: c99bfe31f8774ec8e242
    qq: 101880644  # 改成自己的
  clientSecret:
    gitee: 993930de16b61b8146f7d30c693afd328b4d42116cf2da748f275077e4ef5e47
    github: ec088d14ab8076e2beed58fcb95e37a0fc586618
    qq: cbc294d36dabeac4bf6c31ced8bf930f # 改成自己的

# uniapp相关配置
uniapp:
  qq:
    appid: 1110769790  # 改成自己的
    secret: zWZBLzBcekMUTP60  # 改成自己的
    grant_type: authorization_code', '6d847b13aff0e44add48eddadc3368ef', '2020-06-20 09:28:52', '2020-09-12 00:42:36', null, '116.1.3.234', '', 'prod', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (79, 'lens-blog-admin-backend.yaml', 'DEFAULT_GROUP', 'server:
  port: 9010

#阿里大于
templateCode: SMS_XXXXXX #短信模板编号
signName: 麻辣博客
#项目名称
PROJECT_NAME: 麻辣博客
# 邮箱验证
lensBlog:
  email: 67949049@qq.com

spring:
  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://172.17.0.1:9411  # 指定了Zipkin服务器的地址

  thymeleaf:
    cache: true   #关闭缓存
  application:
    name: lens-blog-admin-backend
  datasource:
    username: lens
    password: lens
    url: jdbc:mysql://172.17.0.1:33306/lens_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    # 初始化大小，最小，最大
    initialSize: 20
    minIdle: 5
    maxActive: 200
    #连接等待超时时间
    maxWait: 60000
    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000
    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
  rabbitmq:
    host: 172.17.0.1 #rabbitmq的主机ip
    port: 5672
    username: lens
    password: lens

# 或者：
feign.hystrix.enabled: false #索性禁用feign的hystrix支持

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always
      
#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.lens.blog.common.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false
    
##jwt配置
tokenHead: bearer_
tokenHeader: Authorization
isRememberMeExpiresSecond: 259200 #记住账号为3天有效
audience:
  clientId: 098f6bcd4621d373cade4e832627b4f6
  base64Secret: MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=
  name: lensblog
  expiresSecond: 3600  #1个小时 3600
  refreshSecond: 300 # 刷新token的时间 5分钟        ', 'f0b167096199ba5c1730f3b42364a6c7', '2020-11-12 00:47:37', '2020-11-12 06:21:57', null, '172.21.0.1', '', '', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (90, 'lens-blog-backend.yaml', 'DEFAULT_GROUP', 'server:
  port: 9009
#阿里大于
templateCode: SMS_XXXXXX #短信模板编号

signName: 麻辣博客
# 项目英文名
PROJECT_NAME_EN: lensBlog
#项目名称
PROJECT_NAME: 麻辣博客

data:
  # 门户页面
  webSite:
    url: http://localhost:9527/#/
  # mogu_web网址，用于第三方登录回调
  web:
    url: http://127.0.0.1:8603

file:
  upload:
    path: ~/containers/lens-blog-backend/data/files

# 蘑菇博客登录默认密码
DEFAULE_PWD: lens    

#请求限制参数
request-limit:
  start: false # 是否开启请求限制，默认关闭
  amount: 100 # 100次
  time: 60000 # 1分钟
  
spring:
  application:
    name: lens-blog-backend
  # DATABASE CONFIG
  datasource:
    username: lens
    password: lens
    url: jdbc:mysql://172.17.0.1:33306/lens_blog?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    # 初始化大小，最小，最大
    initialSize: 5
    minIdle: 5
    maxActive: 50
    #连接等待超时时间
    maxWait: 60000
    #配置隔多久进行一次检测(检测可以关闭的空闲连接)
    timeBetweenEvictionRunsMillis: 60000
    #配置连接在池中的最小生存时间
    minEvictableIdleTimeMillis: 300000
    dbcp:
      remove-abandoned: true
      #泄露的连接可以被删除的超时时间（秒），该值应设置为应用程序查询可能执行的最长时间
      remove-abandoned-timeout: 180
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    #配置监控统计拦截的filters，去掉后监控界面sql无法统计，''wall''用于防火墙
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  rabbitmq:
    host: 172.17.0.1 #rabbitmq的主机ip
    port: 5672
    username: lens
    password: lens
  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://172.17.0.1:9411  # 指定了Zipkin服务器的地址


management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

#mybatis
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.lens.blog.common.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: UUID
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: NOT_EMPTY
      #驼峰下划线转换
      column-underline: true
      #数据库大写下划线转换
      #capital-mode: true
      #逻辑删除配置
      logic-delete-value: 0
      logic-not-delete-value: 1
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false

# 第三方登录，参考 http://moguit.cn/#/info?blogUid=fe9e352eb95205a08288f21ec3cc69e0
justAuth:
  clientId:
    gitee: ec2dba332701caa209935512c69fc7962530b8619acd9b6cb03106a7c13c1c5e
    github: c99bfe31f8774ec8e242
    qq: XXXXXXXXXXXXXXX  # 改成自己的
  clientSecret:
    gitee: 993930de16b61b8146f7d30c693afd328b4d42116cf2da748f275077e4ef5e47
    github: ec088d14ab8076e2beed58fcb95e37a0fc586618
    qq: XXXXXXXXXXXXXXXXXX # 改成自己的

# uniapp相关配置
uniapp:
  qq:
    appid: 1110769790
    secret: zWZBLzBcekMUTP60
    grant_type: authorization_code    

#博客相关配置
BLOG:
  HOT_COUNT: 5 #热门博客数量
  HOT_TAG_COUNT: 20 #热门标签数量
  FRIENDLY_LINK_COUNT: 20 #友情链接数
  NEW_COUNT: 15 #最新博客数据
  FIRST_COUNT: 5 #一级推荐
  SECOND_COUNT: 2 #二级推荐
  THIRD_COUNT: 3 #三级推荐
  FOURTH_COUNT: 5 #四级推荐
  USER_TOKEN_SURVIVAL_TIME: 168 # toekn令牌存活时间, 7天  168 = 7*24
  # 原创模板
  ORIGINAL_TEMPLATE: 本文为蘑菇博客原创文章，转载无需和我联系，但请注明来自蘑菇博客 http://www.moguit.cn
  # 转载模板
  REPRINTED_TEMPLATE: 本着开源共享、共同学习的精神，本文转载自 %S ，版权归 %S 所有，如果侵权之处，请联系博主进行删除，谢谢~    ', 'a99df66349e8d01041bf855114db83de', '2020-11-12 05:02:58', '2020-11-13 01:22:10', null, '172.21.0.1', '', '', '', '', '', 'yaml', '');
INSERT INTO nacos.config_info (id, data_id, group_id, content, md5, gmt_create, gmt_modified, src_user, src_ip, app_name, tenant_id, c_desc, c_use, effect, type, c_schema) VALUES (101, 'lens-blog-sms.yaml', 'DEFAULT_GROUP', '#app
server:
  port: 9011

#阿里大于
accessKeyId: XXXXXXXXXXXXXXXXXXXXX #修改成自己的
accessKeySecret: XXXXXXXXXXXXXXXXXXXXXXX #修改成自己的

spring:
  thymeleaf:
    cache: true   #关闭缓存

  #RabbitMq
  rabbitmq:
    host: 172.17.0.1 #rabbitmq的主机ip
    port: 5672
    username: lens
    password: lens
 
  #mail
  mail:
    username: 67949049@qq.com 
    password: 77777777 #授权码开启SMTP服务里设置
    host: smtp.qq.com
    default-encoding: UTF-8
    properties:
      mail:
        smtp:
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
          auth: true
          starttls:
            enable: false    

  # sleuth 配置
  sleuth:
    web:
      client:
        enabled: true
    sampler:
      probability: 1.0 # 采样比例为: 0.1(即10%),设置的值介于0.0到1.0之间，1.0则表示全部采集。
  # zipkin 配置
  zipkin:
    base-url: http://172.17.0.1:9411  # 指定了Zipkin服务器的地址

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always    ', '0a2f70a25ab8146f00c78e5c90a797d7', '2020-11-13 00:31:21', '2020-11-13 00:55:27', null, '172.21.0.1', '', '', '', '', '', 'yaml', '');