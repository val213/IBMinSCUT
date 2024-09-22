<template>
    <div class="container">
        <el-form label-width="auto">

          <el-form-item label="活动名称">
             <el-input v-model="activityMessage.name" type="text"/>
          </el-form-item>

          <el-form-item label="活动ID">
             <el-input v-model="activityMessage.id" type="number" />
          </el-form-item>

          <el-form-item label="开始时间">
             <el-input v-model="activityMessage.startTime" type="date" />
          </el-form-item>

          <el-form-item label="结束时间">
             <el-input v-model="activityMessage.endTime" type="date" />
          </el-form-item>

          <el-form-item label="活动负责人">
             <el-input v-model="activityMessage.leader" type="string" />
          </el-form-item>

          <el-form-item >
             <el-button type="primary" round @click="" style="margin:0 auto;">创建活动</el-button>
             <el-button type="primary" round @click="navigateTo('/activity')" style="margin:0 auto;">取消</el-button>
          </el-form-item>

        </el-form>
    </div>

</template>
     
<script lang="ts" setup name="CreateActivity">

const activityMessage=reactive(
    {
        name:'',
        id:'',
        startTime:'',
        endTime:'',
        leader:'',
    }
)
     
</script>
     
<style scoped>
   
</style>