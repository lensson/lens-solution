// const path = require('path')
//
// function resolve(dir) {
//   return path.join(__dirname, dir)
// }

const vueConfig = {
  publicPath: 'public',

  devServer: {
    port: 8002
  },
  lintOnSave: true
}

module.exports = vueConfig
