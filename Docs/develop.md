# git 注意事项
0. 如果你对git不熟悉，请先自行稍微了解一些规范的 PR 流程。你需要知道如何创建分支，如何提交代码，如何拉取最新的代码以及 PR 等基本操作。
1. 请不要直接在 master 分支上进行开发，应该拉一个新的分支，然后在新分支上进行开发。
2. 开发完成后，将新分支PR到主分支。
3. 使用git的操作的时候，注意你的工作目录，不要在frontend目录下git push，应该在根目录下git push。
# 后端
## 数据库相关
前置知识：数据库基础知识，数据库表的创建，数据库表的增删改查操作。
### 数据库连接
数据库连接需要密码，但是**由于这类敏感信息不应该被上传到公共仓库**，所以你需要在 backend 目录下创建一个名为 `.env` 的文件，用于存放数据库连接的账号和密码，格式如下：
```shell
# .env
DB_USER=your_db_user
DB_PASSWORD=your_db_password
```
请你先提前在本地创建好一个数据库，然后将数据库的账号密码填写到 `.env` 文件中。
然后你可以尝试在 idea 中连接数据库，看看是否能够成功连接。

> 后续如果使用对象存储服务或者远程数据库在部署到服务器时，需要将新的数据库账号密码更新到 `.env` 文件中。
### 数据库表初始化
目前采取的策略是开发者在本地使用 `backend\TableSQL\CreateTable.sql` 中的 `.sql` 文件创建数据库表，然后在本地运行后端服务，进行开发和测试。
你可以将这个脚本复制到 mysql workbench 中的query console 打开，然后点击这个小闪电运行，就可以更新你的数据库表了。
![alt text](https://github.com/val213/IBMinSCUT/blob/main/Docs/image.png?raw=true)

更新好之后在 idea 里面刷新一下数据库，就可以看到新的表了。

# 前端
请查看 frontend\README.md .
