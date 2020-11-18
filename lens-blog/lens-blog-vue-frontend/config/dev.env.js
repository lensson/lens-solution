'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  VUE_MOGU_WEB: '"http://localhost:8001"',
  PICTURE_API: '"http://localhost:9012"',
	WEB_API: '"http://localhost:9001"',
	ELASTICSEARCH: '"http://localhost:9200"',

})
