'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  //开发环境
  FILE_API: '"http://172.28.0.1:9012/"',
  ADMIN_API: '"http://172.28.0.1:8849/api/v1/blog/admin"',
  PICTURE_API: '"http://172.28.0.1:9012"',
  WEB_API: '"http://172.28.0.1:9001"',
  Search_API: '"http://172.28.0.1:9013"',
  SPRING_BOOT_ADMIN: '"http://172.28.0.1:9020/wallboard"',
  SOLR_API: '"http://172.28.0.1:8983/solr"',
  Zipkin_Admin: '"http://172.28.0.1:9411/zipkin/"',
  SENTINEL_ADMIN: '"http://172.28.0.1:8070/sentinel/"',
  ELASTIC_SEARCH: '"http://172.28.0.1:5601"',
  EUREKA_API: '"http://172.28.0.1:8761"',
  RABBIT_MQ_ADMIN: '"http://172.28.0.1:15672"',
  DRUID_ADMIN: '"http://172.28.0.1:9001/druid/login.html"',
  BLOG_WEB_URL: '"http://172.28.0.1:8001"',

})
