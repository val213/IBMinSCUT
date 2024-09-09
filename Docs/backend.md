# UserDto文件 用户注册/登录功能 接受来自前端数据
1.用户邮箱/账号和密码等基本信息的存储
2.构造函数用于灵活创建对象
3.Getter/Setter方法用于外部获取对象的属性/修改属性
4.toString函数提供对象的字符串表示，方便日志查看。（隐藏了用户密码保护隐私）
5.重写equals 和 hashCode 方法，当比较/匹配两个对象是否相等时将通过属性值进行判断

# User文件 用于与数据库交互
1.主体部分与UserDto文件基本一致，存储User的基本属性，基本比较方法
2.映射到数据库的user表
3.添加了自增的id属性，这在数据库中也被需要

#### **controller,mapper,service**

# 获取用户基本信息
1.完成了：获取用户信息从数据库中获取对应用户的基本信息（用户名、邮箱、注册时间）。
2.

# 用户注册
1.接收用户名、密码、邮箱
2.检验用户是否已经存在
3.密码加密
4.将用户名、密码、邮箱存储到user表中（其他的信息如部门id、职位等信息先设置为空）
5.成功返回注册成功的信息，此时查看数据库将会添加新的用户信息，id自增

ps：为了存储加密后的密码，为部门信息等设置默认值，需要对数据库做以下修改：
ALTER TABLE user MODIFY password VARCHAR(255);
ALTER TABLE user MODIFY id INT AUTO_INCREMENT;
ALTER TABLE user MODIFY role_list VARCHAR(255) DEFAULT '';
ALTER TABLE user MODIFY current_role VARCHAR(50) DEFAULT '';
ALTER TABLE user MODIFY department_id VARCHAR(19) DEFAULT '';

# 用户登录
1.接收前端传送的用户名和密码，post请求
2.在数据库中查找对应的用户记录，select from
3.验证密码是否正确，比较加密后的密码是否一致
（登录的时候发现注册功能中的密码加密执行了两次，导致登录验证一直出错，已解决）
4.如果验证成功，生成 JWT 令牌并返回给前端。
5.如果验证失败，返回错误消息：401登录失败

# events 事件管理模块
api路径：`/api/events`，具体请参见接口文档。
该模块包含了几个简单的增删改查接口：
- 获取所有事件列表，包含基本信息
- 获取指定事件的详细信息
- 添加事件
- 删除事件
- 更新事件 

## dto
- EventDto：用于与前端进行事件数据的传输
- EventSimpleDto：用于返回给前端的事件基本信息，主要在获取事件列表时使用