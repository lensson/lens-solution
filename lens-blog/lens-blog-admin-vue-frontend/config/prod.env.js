'use strict'
module.exports = {
  NODE_ENV: '"production"',

  //生产环境
  ADMIN_API: '"http://172.17.0.1:9002"',
  PICTURE_API: '"http://172.17.0.1:9012"',
  WEB_API: '"http://172.17.0.1:9001"',
  Search_API: '"http://172.17.0.1:9013"',
  SPRING_BOOT_ADMIN: '"http://172.17.0.1:9020/wallboard"',
  SOLR_API: '"http://172.17.0.1:8983/solr"',
  Zipkin_Admin: '"http://172.17.0.1:9411/zipkin/"',
  ELASTIC_SEARCH: '"http://172.17.0.1:5601"',
  EUREKA_API: '"http://172.17.0.1:8761"',
  RABBIT_MQ_ADMIN: '"http://172.17.0.1:15672"',
  DRUID_ADMIN: '"http://172.17.0.1:9002/druid/login.html"',
  // 有域名
  BLOG_WEB_URL: '"http://www.malakj.com"',
  // 没有域名
  // BLOG_WEB_URL: '"http://172.17.0.1:9527"',
}
