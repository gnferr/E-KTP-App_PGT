<template>
  <div id="Sukses">
    <div class="card w-75">
      <div class="card-header text-light">
        Successfully !
      </div>
      <div class="card-body ">
        <h5 class="card-title">Data Anggota Keluarga has been successfully {{Sussy}}!</h5>
        <button v-show="Sussy == 'Inputed'" class="btn btn-sm text-light" @click="iniReload">Back</button>
        <button v-show="Sussy == 'Updated'" class="btn btn-sm text-light" @click="back">Back</button>
        <button v-show="Sussy == 'Deleted'" class="btn btn-sm text-light" @click="iniReload">Back</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "SuksesComponent",
    props: ['Sussy'],
    methods: {
      iniReload() {
        location.reload();
      },
      back() {
        window.history.go(-1)
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