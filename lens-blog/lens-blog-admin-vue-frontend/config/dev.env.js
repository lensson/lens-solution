'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  //开发环境
  FILE_API: '"/api/v1/blog/file"',
  ADMIN_API: '"/api/v1/blog/admin"',
  PICTURE_API: '"/api/v1/blog/file"',
  WEB_API: '"/api/v1/blog/web"',
  Search_API: '"/api/v1/blog/search"',
  SPRING_BOOT_ADMIN: '"/api/v1/blog/wallboard"',
  SOLR_API: '"/api/v1/solr"',
  Zipkin_Admin: '"/api/v1/zipkin/"',
  SENTINEL_ADMIN: '"/api/v1/sentinel/"',
  ELASTIC_SEARCH: '"/api/v1/kibana"',
  EUREKA_API: '"/api/v1/blog/eureka"',
  RABBIT_MQ_ADMIN: '"/api/v1/rabbitmq"',
  DRUID_ADMIN: '"http://172.28.0.1:9001/druid/login.html"',
  BLOG_WEB_URL: '"http://172.28.0.1:8001"',

})
