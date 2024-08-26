<template>
    <div class="container">

        <div class="left">
            <div class="detail">
                <el-avatar :src="avatar" :size="400"/>
            </div>
            <div class="detail">
                <el-button type="primary" round plain @click="to_UpdateProfile" style="margin: 0 auto;">更新资料</el-button>
            </div>
            <div class="detail">
                <el-button type="primary" round @click="Logout" style="margin: 0 auto;">退出登录</el-button>
            </div>
            <div class="detail">
                <el-button type="primary" round plain @click="to_main" style="margin: 0 auto;">返回首页</el-button>
            </div>
        </div>

        <div class="right">
            <el-descriptions
            title="个人资料"
            :column="1"
            size="large"
            >
            <el-descriptions-item label="用户名:">111</el-descriptions-item>
            <el-descriptions-item label="邮箱:">111</el-descriptions-item>
            <el-descriptions-item label="注册时间:">111</el-descriptions-item>

            </el-descriptions>


        </div>

    </div>
</template>

<script setup lang="ts" name="UserProfile">
import avatar from '~/assets/img/avatar.png'
import { useIfLogin } from '~/store/ifLogin';
import { useIfLogined } from '~/store/ifLogined';

const ifLogin=useIfLogin()
const ifLogined=useIfLogined()
const to_UpdateProfile=()=>{
    navigateTo("/updateprofile")
}

const Logout=()=>{
    if(ifLogined.if_logined===true){
        ifLogined.if_logined=false
        navigateTo("/")
    }
}
const to_main=()=>{
    navigateTo("/")
}

</script>

<style scoped>
.container{
    display: flex;
    width: 100%;
    height: 100%;
    padding: 20px;
    align-items: center;
    justify-content: center;
}

.left{
    width: 30%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.left .detail{
    margin: 30px;
}

.right{
    width: 70%;
    height: 100%;
}

</style>