<template>
 <div>
   <el-container>
      <el-aside width="20%">
         <el-link href="/"><</el-link>
         <el-menu :default-openeds="['1','2']">
            <el-sub-menu index="1">
               <template #title>部门列表</template>
               <el-menu-item-group>

                  <NuxtLink to="/department/technology">
                     <el-menu-item index="1-1">技术部</el-menu-item>
                  </NuxtLink>

                  <NuxtLink to="/department/propaganda">
                     <el-menu-item index="1-2">宣传部</el-menu-item>
                  </NuxtLink>

                  <NuxtLink to="/department/organization">
                     <el-menu-item index="1-3">组织部</el-menu-item>
                  </NuxtLink>

               </el-menu-item-group>
            </el-sub-menu>
            
            <el-sub-menu index="2">
                  <template #title>部门修改</template>
                  <el-menu-item-group>
                     <el-menu-item index="2-1">
                           <el-button type="primary" round @click="navigateTo('/department/add')">创建部门</el-button>
                        </el-menu-item>
                    
                        <el-menu-item index="2-2">
                           <el-button type="primary" round @click="navigateTo('/department/edit')">修改部门</el-button>
                        </el-menu-item>
                  
                        <el-menu-item index="2-3">
                           <el-button type="primary" round @click="navigateTo('/department/delete')">删除部门</el-button>
                        </el-menu-item>
                     
                  </el-menu-item-group>

            </el-sub-menu>
         </el-menu>
      </el-aside>

      <el-main>
         <NuxtPage/>
      </el-main>

   </el-container>
    
 </div>
   
</template>

<script lang="ts" setup name="Department">

</script>

<style scoped>
.container{
   flex: 1;
}

a{
  text-decoration: none;
}





</style>