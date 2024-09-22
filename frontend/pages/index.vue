<template>
    <div class="index-container">
        <header>
            <Navbar/>
        </header>
        <Login v-if="ifLogin.ifLogin===true"/>
    </div>
   
</template>

<script lang="ts" setup name="index">
import {useIfLogin} from '@/store/ifLogin'

const ifLogin=useIfLogin()

</script>

<style scoped>


</style>