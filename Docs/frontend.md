#### **官网首页结构**

主要组件：首页App.vue，登录页面Login.vue，更新页面UpdateProfile.vue，注册页面Register.vue，信息展示页面UserProfile.vue，导航栏Navbar.vue。

由于大型的企业级官网项目多采用react框架，使用vue的较少，在github上寻找到的基于vue的开源项目基本都将登录等页面专门放置在pages目录下通过路由访问，没有找到具体的弹窗的设置，因此决定将本项目的登录等页面通过路由访问，需要设置弹窗的页面可通过自行设置css样式实现。

其中Navbar.vue作为全局组件位于components目录，Login.vue需要实现窗口化页面效果，同样作为全局组件放置于components目录下，UpdateProfile.vue，Register.vue，UserProfile.vue作为路由组件位于pages目录下，在index.vue中Navbar.vue全局放置进行导航访问路由组件。

关于弹窗设置，弹窗周围的虚化页面同样属于路由组件里的布局，在css中进行设置。

点击登录显示登陆弹窗，登陆后会更新Navbar的显示，关闭登录和注册按键，显示登陆后的用户头像，并且鼠标悬浮能够显示弹出框，显示退出登录和UserProfile.vue的跳转按键，在UserProfile.vue中会显示用户信息、头像以及退出登录和更新个人信息的跳转按键

