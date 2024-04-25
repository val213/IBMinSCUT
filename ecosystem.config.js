module.exports = {
    apps: [
      {
        name: 'IBMinSCUT',
        exec_mode: 'cluster',
        instances: 'max',
        script: './node_modules/nuxt/bin/nuxt.js',
        args: 'start',
        env:{
          HOST: '0.0.0.0',
          POST: 3000
        }
      }
    ]
  }
  