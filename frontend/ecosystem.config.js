module.exports = {
  /**
   * Application configuration section
   * https://pm2.keymetrics.io/docs/usage/application-declaration/
   */
  apps: [
    {
      name: 'my-nuxt-app', // 应用名称
      script: 'nuxt.js',   // 启动脚本，对于 Nuxt.js 通常是 nuxt.js 或 nuxt-ts (如果使用 TypeScript)
      args: 'start',       // 传递给脚本的参数，通常是启动命令
      instances: 1,        // 启动的实例数量
      autorestart: true,   // 当应用崩溃时自动重启
      watch: false,        // 是否监视文件变化并自动重启应用（通常在开发模式下使用）
      max_memory_restart: '1G', // 当内存使用超过这个值时重启应用
      env: {
        NODE_ENV: 'production' // 设置环境变量
      },
      env_production: {
        NODE_ENV: 'production'
      }
    }
  ],

  /**
   * Deployment section
   * https://pm2.keymetrics.io/docs/usage/deployment/
   */
  deploy: {
    production: {
      user: 'username',      // SSH 用户名
      host: 'hostname',      // SSH 主机名或 IP 地址
      ref: 'origin/main',  // Git 仓库的分支
      repo: 'git@github.com:val213/IBMinSCUT.git',      // Git 仓库的 URL
      path: '/var/www/app',  // 远程服务器上的部署路径
      'post-deploy': 'npm install && pm2 startOrReload ecosystem.config.js --env production' // 部署后执行的命令
    }
  }
};
