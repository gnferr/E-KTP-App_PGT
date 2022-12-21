<template>
    <div id="listWarga">
        <div class="container">
            <div v-show="!viewSukses">
                <div class="mb-4">
                    <button v-show="!viewForm || title == 'Update'" class="btn text-light mr-2" 
                        style="background-color:#52734D;" @click="back">Back</button>
                    <button v-show="viewForm && title != 'Update'" class="btn text-light mr-2"
                        style="background-color:#52734D;" @click="reload">Back</button>
                    <button class="btn btn-primary" @click="addWarga" v-show="!viewForm">Tambah Anggota
                        Keluarga</button>
                    <button class="btn btn-success" v-show="UpdateBtn" @click="toggleUpdate">Update Anggota</button>
                </div>
                <div class="card" v-show="!viewForm">
                    <h4 class="card-header text-light">Daftar Anggota Keluarga</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Nik</th>
                                <th scope="col">Nama</th>
                                <th scope="col">Jenis Kelamin</th>
                                <th scope="col">Kepala Keluarga</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(item,index) in dataKeluarga" :key="item.id">
                                <td>{{index +1}}</td>
                                <td>{{item.nik}}</td>
                                <td>{{item.nama}}</td>
                                <td>{{item.jenis_kelamin}}</td>
                                <td>{{item.kepala_keluarga}}</td>
                                <td>
                                    <router-link :to="{name : 'detailWarga',params:{ide: item.id}}"><button
                                            class="btn btn-primary btn-sm mr-2">Detail</button></router-link>
                                    <button class="btn btn-danger btn-sm" @click="deleteWarga(item.id)">Delete</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div v-if="dataKeluarga.length < 1" class="d-flex justify-content-center p-3"
                        style="background-color:rgb(240, 240, 240)">Tidak Ada Data</div>
                </div>
                <div class="card" v-show="viewForm">
                    <h4 class="card-header text-light">{{title}} Anggota Keluarga</h4>
                    <div class="card-body">
                        <form @submit.prevent="inputWarga">
                            <div class="form-row mb-2">
                                <div class="col">
                                    <label>NIK</label>
                                    <input type="number" onKeyPress="if(this.value.length==9) return false;" id="nik"
                                        v-model="dataKeluarga2.nik" class="form-control" :disabled="readonly">
                                        <small v-show="small">Nik sudah digunakan mas!</small>
                                </div>
                                <div class="col">
                                    <label>Tanggal Lahir</label>
                                    <input type="date" v-model="dataKeluarga2.tanggal_lahir" class="form-control"
                                        :disabled="readonly">
                                </div>
                            </div>
                            <div class="form-row mb-2">
                                <div class="col">
                                    <label>Nama</label>
                                    <input type="text" v-model="dataKeluarga2.nama" id="fullname" class="form-control" maxlength="40"
                                        :disabled="readonly">
                                </div>
                                <div class="col">
                                    <label>Agama</label>
                                    <input type="text" v-model="dataKeluarga2.agama" maxlength="50" class="form-control"
                                        :disabled="readonly">
                                </div>
                            </div>
                            <div class="form-row mb-2">
                                <div class="col">
                                    <label>Jenis Kelamin</label>
                                    <select class="form-control" v-model="dataKeluarga2.jenis_kelamin"
                                        :disabled="readonly">
                                        <option></option>
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <label>Pendidikan</label>
                                    <input type="text" v-model="dataKeluarga2.pendidikan" maxlength="50" class="form-control"
                                        :disabled="readonly">
                                </div>
                            </div>
                            <div class="form-row mb-2">
                                <div class="col">
                                    <label>Tempat Lahir</label>
                                    <input type="text" v-model="dataKeluarga2.tempat_lahir" maxlength="50" name="provinsi"
                                        class="form-control" :disabled="readonly">
                                </div>
                                <div class="col">
                                    <label>Kepala Keluarga</label>
                                    <select class="form-control" v-model="dataKeluarga2.kepala_keluarga"
                                        :disabled="readonly">
                                        <option></option>
                                        <option value="Yes">Yes</option>
                                        <option value="No">No</option>
                                    </select>
                                </div>
                            </div>
                            <button v-show="UpdateShow" class="btn btn-danger text-light mt-2 mr-2" type="button" @click="reload">Cancel</button>
                            <button v-show="UpdateShow" class="btn text-light mt-2" type="submit" style="background-color:#52734D" @click="toggleKK">{{ButtonVal}}</button>
                            <button v-show="title == 'Tambah'" class="btn text-light mt-2" type="submit" style="background-color:#52734D" @click="toggleKK">{{ButtonVal}}</button>
                        </form>
                    </div>
                </div>
            </div>
            <Sukses :Sussy="SuksesVal" v-show="viewSukses"></Sukses>
        </div>
    </div>
</template>

<script>
    import Sukses from './Sukses.vue';
    import wargaService from '@/services/wargaService';
    export default {
        name: "MainWarga",
        methods: {
            back() {
                window.history.go(-1)
            },
            reload() {
                location.reload();
            },
            toggleUpdate() {
                this.readonly = false
                this.UpdateBtn = false
                this.UpdateShow = true
            },
            inputWarga() {
                let data = this.dataKeluarga2;
                if (this.ButtonVal == 'Submit') {
                    wargaService.create(data)
                        .then(
                            response => {
                                console.log(response.data);
                                this.viewForm = false
                                this.SuksesVal = "Inputed"
                                this.viewSukses = true
                            }
                        )
                        .catch(e => {
                            let error = e.response.data.trace;
                            if (error.includes("Duplicate entry")) {
                            console.log('Nik Sudah ada')
                            this.small = true
                            
                    }
                        });
                } else {
                    wargaService.updateWarga(data.id, data)
                        .then(response => {
                            console.log(response.data);
                            this.SuksesVal = "Updated"
                            this.viewSukses = true
                        })
                        .catch(e => {
                            console.log(e);
                        })
                }
            },
            addWarga() {
                this.viewForm = true
            },
            getWarga() {
                wargaService.getAll()
                    .then(response => {
                        this.dataKeluarga = response.data;
                        console.log(this.dataKeluarga);
                    })
                    .catch(e => {
                        console.log(e);
                    })
            },
            deleteWarga(id) {
                if (confirm("Apakah anda yakin ingin menghapus?")) {
                    wargaService.deleteWarga(id)
                        .then(response => {
                            console.log(response.data);
                            this.SuksesVal = "Deleted"
                            this.viewSukses = true
                        })
                        .catch(e => {
                            console.log(e);
                        });
                } else {
                    alert("Hapus dibatalkan!")
                }
            },
            getByKaka(id_kk) {
                wargaService.getIdKaka(id_kk)
                    .then(response => {
                        this.dataKeluarga = response.data;
                        console.log(this.dataKeluarga);
                    })
                    .catch(e => {
                        console.log(e);
                    })
            },
            toggleKK() {
                this.dataKeluarga2.id_kk = this.$route.params.id;

            },
            getDataWarga(id) {
                wargaService.getById(id)
                    .then(response => {
                        this.dataKeluarga2 = response.data;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    })
            }

        },
        data() {
            return {
                dataKeluarga: {
                    "id": '',
                    "agama": '',
                    "id_kk": '',
                    "jenis_kelamin": '',
                    "kepala_keluarga": '',
                    "nama": '',
                    "nik": '',
                    "pendidikan": '',
                    "tanggal_lahir": '',
                    "tempat_lahir": ''
                },
                dataKeluarga2: {
                    "id":'',
                    "agama": '',
                    "id_kk": '',
                    "jenis_kelamin": '',
                    "kepala_keluarga": '',
                    "nama": '',
                    "nik": '',
                    "pendidikan": '',
                    "tanggal_lahir": '',
                    "tempat_lahir": ''
                },
                ButtonVal: "Submit",
                viewForm: false,
                viewSukses: false,
                SuksesVal: "Input",
                title: "Tambah",
                readonly: true,
                UpdateBtn: false,
                UpdateShow: false,
                small: false

            }
        },
        mounted() {
            this.getByKaka(this.$route.params.id);
            if (this.$route.name == 'detailWarga') {
                this.getDataWarga(this.$route.params.ide)
                this.viewForm = true
                this.ButtonVal = "Update"
                this.title = "Update"
                this.UpdateBtn = true
            } else if (this.title == 'Tambah') {
                this.readonly = false
            }
        },
        components: {
            Sukses
        }
    }
</script>

<style scoped>
    #listWarga {
        margin-left: 200px;
        margin-top: 5px;
        padding-top: 20px;
    }

    .card-header {
        background-color: #52734D;
    }

    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    small {
        color:red;
        font-family: monospace;
    }
</style>