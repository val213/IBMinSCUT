module.exports = {
  /**
   * Application configuration section
   * https://pm2.keymetrics.io/docs/usage/application-declaration/
   */
  apps: [
    {
      name: 'nuxt-app', // 应用名称
      script: 'npm',    // 启动脚本，对于 Nuxt.js 使用 npm
      args: 'run start', // 传递给脚本的参数，通常是启动命令
      cwd: '/usr/share/nginx/html/ibminscut', // 工作目录
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
};