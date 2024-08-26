<template>
   <div class="register-container">
    <div class="register-form">
        <el-form 
        ref="ruleformref"
        label-width="auto" 
        size="large" 
        :model="ruleform" 
        :rules="rules"
        >
            <el-form-item label="请输入用户名" prop="username">
                <el-input v-model="ruleform.username" type="text" placeholder="username" required/>
            </el-form-item>

            <el-form-item label="请输入密码" prop="password">
                <el-input v-model="ruleform.password" type="text" placeholder="password" show-password />
            </el-form-item>

            <el-form-item label="请再次输入密码" prop="confirm_password">
                <el-input v-model="ruleform.confirm_password" type="text" placeholder="confirm_password" show-password />
            </el-form-item>

            <el-form-item label="请输入邮箱" prop="mail">
                <el-input v-model="ruleform.mail" type="text" placeholder="mail" />
            </el-form-item>

            <el-form-item>
                <el-button type="primary" plain @click="to_main" style="margin: 0 auto;">返回</el-button>
                <el-button type="primary" @click="onsubmit(ruleformref)" style="margin: 0 auto;">注册</el-button>
            </el-form-item>

        </el-form>
    </div>  
   </div>
</template>

<script setup lang="ts" name="Register">
import type { FormInstance, FormRules } from 'element-plus';

const ruleformref=ref<FormInstance>()

const ruleform=reactive({
    password:'',
    confirm_password:'',
    username:'',
    mail:''
})

const checkname=(rule:any,value:any,callback:any)=>{
    if(value===''){
        callback(new Error('请输入用户名!'))
    }else{
        callback()
    }
}
const checkmail=(rule:any,value:any,callback:any)=>{
    if(value===''){
        callback(new Error('请输入邮箱!'))
    }else{
        callback()
    }
}

const checkpass=(rule:any,value:any,callback:any)=>{
    if(value===''){
        callback(new Error('请输入密码!'))
    }else{
        if(ruleform.confirm_password!==''){
            if (!ruleformref.value) return
            ruleformref.value.validateField('comfirm_password')
        }
        callback()
    }
}

const checkconfirm=(rule:any,value:any,callback:any)=>{
    if(value===''){
        callback(new Error('请再次输入密码!'))
    }else if(value!==ruleform.password){
        callback(new Error('两次输入密码不一致!'))
    }else{
        callback()
    }
}

const rules = reactive<FormRules<typeof ruleform>>({
  password: [{ validator: checkpass, trigger: 'blur' }],
  confirm_password: [{ validator: checkconfirm, trigger: 'blur' }],
  username: [{ validator: checkname, trigger: 'blur' }],
  mail: [{ validator: checkmail, trigger: 'blur' }]
})

const onsubmit=(formEl:FormInstance|undefined)=>{
   if(!formEl){
    return
   }
   formEl.validate((valid) => {
    if (valid) {
      //调用注册api,同时检查后台是否已有该账号
      navigateTo("/")
    } else {
        ElMessageBox.alert('请确认注册信息正确!', '提示')
    }
  })
}
const to_main=()=>{
    navigateTo("/")
}

</script>


<style scoped>

.register-container{
    flex:1;
    position: relative;
}

.register-form{
    position: absolute;
    top:20px;
    left: 30%;
    right: 30%;
}

</style>

