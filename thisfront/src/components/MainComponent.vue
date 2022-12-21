<template>
  <div id="main">
    <div class="pl-3" v-if="!viewForm">
        <div>
            <div class="top text-light">
                <h4 class="font-weight-bold">Homepage</h4>
            </div>
            <div class="down"></div>
        </div>
        <div class="d-flex">
            <div class="cube mt-4 mr-3 p-3 font-weight-bold">
                <p>Jumlah Kartu Keluarga</p>
                <h3>{{dataKaka.length}}</h3>
            </div>
            <div class="cube mt-4 mr-3 p-3 font-weight-bold">
                <p>Jumlah Seluruh Warga</p>
                <h3>{{dataWarga.length}}</h3>
            </div>
        </div>
        <div class="mt-4">
            <div class="card">
                <h4 class="card-header d-flex justify-content-center text-light" style="background-color:#91C788">Daftar Kartu Keluarga</h4>
                <table class="table table-striped">
                    <thead>
                        <tr>
                        <th scope="col">No</th>
                        <th scope="col">Nomor KK</th>
                        <th scope="col">Alamat</th>
                        <th scope="col">Kota</th>
                        <th scope="col">Kode Pos</th>
                        <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item , index) in dataKaka" :key="item.id">
                            <td>{{index +1}}</td>
                            <td>{{item.nomor_kk}}</td>
                            <td>{{item.alamat}}</td>
                            <td>{{item.kabupaten_kota}}</td>
                            <td>{{item.kode_pos}}</td>
                            <td>
                                <router-link :to="{ name : 'detailKK', params:{id : item.id}}" @click.prevent="$emit('UpdateKaka',item)"><button class="btn btn-primary btn-sm mr-2" >Detail</button></router-link>
                                <button class="btn btn-danger btn-sm" @click="deleteKaka(item.id)" @click.prevent="$emit('Deleted')">Delete</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div v-if="dataKaka.length < 1" class="d-flex justify-content-center p-3" style="background-color:rgb(240, 240, 240)">Tidak Ada Data</div>
            </div>
        </div>
    </div>
    <Success style="margin-left:20%" v-else :Sukses="successVal"></Success>
  </div>
</template>

<script>
import kakaService from '@/services/kakaService';
import wargaService from '@/services/wargaService';
import Success from './Success.vue';

export default {
    name:"MainComponent",
    data(){
        return{
            dataKaka : '',
            viewForm: false,
            successVal:"Inputed",
            dataWarga: '',
        }
    },
    methods:{
        getKaka(){
            kakaService.getAll()
                .then(response => {
                    this.dataKaka = response.data;
                    console.log(this.dataKaka);
                })
                .catch(e => {
                    console.log(e);
                })
        },
        deleteKaka(id){
            if(confirm("Apakah anda yakin ingin menghapus?")){
                kakaService.deleteKaka(id)
                    .then(response => {
                        console.log(response.data);
                        this.viewForm = true
                        this.successVal = "Deleted"
                        wargaService.deleteByKaka(id)
                            .then(response => {
                                console.log(response.data);
                            })
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }else{
                alert("Hapus dibatalkan!")
            }

            
        },
        getWarga(){
            wargaService.getAll()
                .then(response => {
                    this.dataWarga = response.data;
                    console.log(this.dataWarga);
                })
                .catch(e => {
                    console.log(e);
                })
        }
    },
    mounted(){
        this.getKaka();
        this.getWarga();
    },
    components: {
        Success
    }
}
</script>

<style scoped>
#main {
    border-radius: 10px;
    margin:5px;
    margin-left:200px;
    width: 82.5%;
}

.cube {
    background-color:white;
    width: 25%;
    height: 100px;
    border-radius: 20px 20px 20px 20px;
}


</style>