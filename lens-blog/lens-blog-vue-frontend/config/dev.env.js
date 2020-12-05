'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  VUE_MOGU_WEB: '"/api/v1/blog/web"',
  PICTURE_API: '"/api/v1/blog/file"',
	WEB_API: '"/api/v1/blog/web"',
	ELASTICSEARCH: '"/api/v1/es"',

})
