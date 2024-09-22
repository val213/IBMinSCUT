<template>
  <div class="container">

   <div class="header">
    <div class="logo">
     <img src="~/assets/img/logo.png" alt="">
    </div>

    <el-button_group class="button_group">
      <el-button type="primary" plain round @click="navigateTo('/createactivity')">活动创建</el-button>
      <el-button type="primary" round @click="navigateTo('/manageactivity')">活动管理</el-button>
    </el-button_group>
  </div>

  <div class="activity-container">
   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

   <a href="/activity/details">
      <div class="activity-card">
        <el-card>
         <img src="~/assets/img/carousel1.avif" alt="">
         <div slot="header" class="clearfix">
           <span>活动名称</span>
         </div>
         <div class="text item">
           活动内容
         </div>
        </el-card>
      </div>
   </a>

  </div>
</div>
  
  
</template>

<script lang="ts" setup name="Activity">

</script>

<style scoped>

.container{
   width: 100%;
   height: 100%;

}


.header{
    display: flex;
    align-items: center;
    justify-content:center ;
    height: 75px;
    border-radius: 10px;
    background-color: #eff8fc;
}

.logo{
    margin: 60px;
}

.logo img{
    width: 200px;
}
.activity-container{
   display: grid;
   grid-template-columns: repeat(4,1fr);
   gap: 20px;
   width: 100%;
}

.activity-card{
   height:200px;
   margin:20px;
}

.activity-card img{
   width:250px;
}

</style>