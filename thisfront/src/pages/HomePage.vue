<template>
  <div id="Homepage">
    <Sidebar></Sidebar>
    <Main></Main>
  </div>
</template>

<script>
import Sidebar from '@/components/SidebarComponent.vue';
import Main from '@/components/MainComponent.vue';
export default {
    components: {
        Sidebar, Main
    }
}
</script>

<style>

</style>