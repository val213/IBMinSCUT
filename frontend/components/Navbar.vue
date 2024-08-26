<template>
        <div class="header">

                <div class="logo">
                    <img src="~/assets/img/logo.png" alt="">
                </div>

                <ul class="navitems">
                    <li v-for="item in itemlist" :key="item.id">
                        <el-link href="/" type="primary">{{ item.name }}</el-link>
                    </li>
                </ul>

                <!-- 登陆及注册 -->
               <el-button_group class="button_group">
                <el-button type="primary" round @click="to_Login" v-if="!ifLogined.if_logined">登录</el-button>
                <el-button type="primary" round plain @click="to_Register" v-if="!ifLogined.if_logined">注册</el-button>
               </el-button_group>

                <!-- 登陆后的头像和弹出框 -->
               <el-popover 
               placement="bottom" 
               width="auto" 
               :v-model:visible="ifLogined.if_logined"
               :disabled="!ifLogined.if_logined"   
               >
                <template #reference>
                    <el-avatar :src="avatar" v-if="ifLogined.if_logined" :size="50"/>
                </template>
                <div class="details">
                    <div class="detail">
                        <el-button type="primary" round plain @click="to_UserProfile">个人资料</el-button>
                    </div>
                    <div class="detail">
                        <el-button type="primary" round plain @click="Logout">退出登录</el-button>
                    </div>
                </div>
               </el-popover>
        </div>
</template>

<script setup lang="ts" name="Navbar">
import {useIfLogin} from '@/store/ifLogin'
import {useIfLogined} from '@/store/ifLogined'
import avatar from '~/assets/img/avatar.png'

const ifLogin=useIfLogin()
const ifLogined=useIfLogined()

const to_Login=()=>{
    ifLogin.if_login=true
}

const to_Register=()=>{
    return navigateTo('/register')
}
const Logout=()=>{
    ifLogined.if_logined=false
}
const to_UserProfile=()=>{
    return navigateTo('/userprofile')
}

const itemlist=[
    {id:1,name:"Activities"},
    {id:2,name:"Projects/Contests"},
    {id:3,name:"We"},
    {id:4,name:"Board"},
    {id:5,name:"Articles"}
]


</script>

<style scoped>

.index-container{
   flex:1;
}

.header{
    display: flex;
    align-items: center;
    justify-content:center ;
    height: 75px;
    border-radius: 20px;
    background-color: #eff8fc;
}

.logo{
    margin: 60px;
}

.logo img{
    width: 200px;
}

/*导航栏链接*/ 
.navitems{
    display: flex;
    align-items: center;
    justify-content:center ;
    margin: 60px;
    list-style: none;
}

.navitems li{
    margin:30px;
}

/*头像弹出框*/ 
.details{
    margin: 20px;
    display: flex;
    align-items: center;
    flex-direction: column;
    justify-content: center;
}

.detail{
    margin: 10px;
}

</style>