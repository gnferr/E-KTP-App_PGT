<template>
   <div>
        <Sidebar></Sidebar>
        <MainWarga></MainWarga>
   </div>
</template>

<script>
import Sidebar from '@/components/SidebarComponent.vue';
import MainWarga from '@/components/MainWarga.vue';
export default {
    components: {
        MainWarga,
        Sidebar
    }
}
</script>

<style>

</style>