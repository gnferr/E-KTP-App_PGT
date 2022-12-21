<template>
    <div>
        <Sidebar></Sidebar>
        <AddForm :propsKaka="dataKaka"></AddForm>
        <Main v-show="off" @UpdateKaka="updateKaka"></Main>
    </div>
</template>

<script>
import Main from '@/components/MainComponent.vue';
import Sidebar from '@/components/SidebarComponent.vue';
import AddForm from '@/components/AddComponent.vue';
export default {
    components:{
        AddForm,
        Sidebar,
        Main
    },
    data(){
        return{
            dataKaka: null,
            off: false
        }
    },
    methods: {
        updateKaka(item){
            this.dataKaka = item
        }
    }
}
</script>

<style>

</style>