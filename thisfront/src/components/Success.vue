<template>
  <div id="Sukses">
    <div class="card w-75">
      <div class="card-header text-light">
        Successfully !
      </div>
      <div class="card-body ">
        <h5 class="card-title">Data has been successfully {{Sukses}}!</h5>
        <router-link to="/Home" class="btn btn-sm text-light" v-show="Sukses != 'Deleted'">Back</router-link>
        <button class="btn btn-sm text-light" @click="iniReload" v-show="Sukses == 'Deleted'">Back</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "SuccessComponent",
    props: ['Sukses'],
    methods: {
      iniReload() {
        location.reload();
      }
    }
  }
</script>

<style scoped>
  .card-header {
    background-color: #52734D;
  }

  .btn {
    background-color: #52734D;
  }

  #Sukses {
    padding-top: 20%;
    margin-left: 200px;
  }
</style>