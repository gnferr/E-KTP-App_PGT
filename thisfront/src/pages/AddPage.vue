<template>
  <div>
    <Sidebar></Sidebar>
    <AddForm></AddForm>
  </div>
</template>

<script>
import Sidebar from '@/components/SidebarComponent.vue';
import AddForm from '@/components/AddComponent.vue';
export default {
    components: {
        Sidebar,
        AddForm
    }
}
</script>

<style>

</style>