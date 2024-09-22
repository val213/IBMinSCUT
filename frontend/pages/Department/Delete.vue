<template>
    <div class="container">
        <el-radio-group v-model="delete_part" >
            <el-radio label="technologu">技术部</el-radio>
            <el-radio label="propagdanda">宣传部</el-radio>
            <el-radio label="organization">组织部</el-radio>
        </el-radio-group>
        <br>

        <el-button type="primary" round plain style="margin:0 auto;">删除</el-button>
    </div>
      
   </template>
   
   <script lang="ts" setup name="Delete">

   const delete_part=ref('')
   
   </script>
   
   <style scoped>
   
   </style>