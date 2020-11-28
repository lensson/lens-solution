'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  VUE_MOGU_WEB: '"http://172.17.0.1:8001"',
  PICTURE_API: '"http://172.17.0.1:9012"',
	WEB_API: '"http://172.17.0.1:9001"',
	ELASTICSEARCH: '"http://172.17.0.1:9200"',
  
})
