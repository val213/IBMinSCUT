<template>
   <div class="login-modal">
    <div class="modal-overlay" @click="closemodal"></div><!-- 遮罩 ---->
        <div class="modal-content"><!--表单-->
            <el-form label-width="auto">

                <el-form-item label="用户名">
                    <el-input v-model="username" type="text" placeholder="username"/>
                </el-form-item>

                <el-form-item label="密码">
                    <el-input v-model="password" type="password" placeholder="password" show-password/>
                    <el-link type="primary" href="/login">忘记密码？</el-link>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" round plain @click="closemodal" style="margin:0 auto;">返回</el-button>
                    <el-button type="primary" round @click="onsubmit" style="margin:0 auto;">登录</el-button>
                </el-form-item>

                <el-form-item>
                    <el-link type="primary" href="/register" style="margin: 0 auto;">没有账号？立刻注册一个~</el-link>
                </el-form-item>
                
            </el-form>
        </div>
    </div>
</template>

<script setup lang="ts" name="Login">
import {ref} from 'vue'
import {useIfLogin} from '@/store/ifLogin'
import { useIfLogined } from '~/store/ifLogined'

const ifLogined = useIfLogined()
const ifLogin = useIfLogin()

const username = ref<string>('')
const password = ref<string>('')

const closemodal = (): void => {
    ifLogin.ifLogin = false
}

const onsubmit = (): void => {
    if (username.value && password.value) {
        ifLogin.ifLogin = false
        ifLogined.ifLogined = true
    } else {
        ElMessageBox.alert('请输入完整信息!', '提示')
    }
}

</script>

<style scoped>
.login-modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .modal-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 1;
  
  }
  
  .modal-content {
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.3);
    z-index: 2;

  }

 

</style>