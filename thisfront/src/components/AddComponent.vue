<template>
    <div id="add">
        <div class="p-3" v-if="!viewForm">
            <router-link to="/Home"><button class="btn mb-4 mr-2 text-light"
                    style="background-color:#52734D;">Back</button></router-link>
            <button v-show="updateBtn" @click="updateToggle" class="btn btn-success mb-4 mr-2 text-light">Update Kartu
                Keluarga</button>
            <router-link v-show="title != 'Tambah'" :to="{name:'listAnggota'}"><button
                    class="btn btn-primary mb-4 text-light">Lihat Anggota Keluarga</button></router-link>
            <div class="card">
                <div class="card-header text-light font-weight-bold">
                    Form {{title}} Kartu Keluarga
                </div>
                <div class="card-body">
                    <form @submit.prevent="inputKaka">
                        <div class="form-row">
                            <div class="col">
                                <label>Nomor Kartu Keluarga</label>
                                <input type="number" onKeyPress="if(this.value.length==8) return false;" id="nik"
                                    v-model="dataKaka.nomor_kk" class="form-control" :disabled="!disable" >
                                    <small v-show="smal">Nomor Kartu Keluarga sudah digunakan!</small>
                            </div>
                        </div>
                        <div class="form-row mt-2">
                            <div class="col">
                                <label>Alamat</label>
                                <textarea type="text" v-model="dataKaka.alamat" maxlength="50" id="alamat"
                                    class="form-control" rows="4" :disabled="!disable" @input="inputV"></textarea >
                                    
                            </div>
                        </div>
                        <div class="form-row mt-2">
                            <div class="col">
                                <label>RT</label>
                                <input type="number" pattern="/^-?\d+\.?\d*$/"
                                    onKeyPress="if(this.value.length==2) return false;" v-model="dataKaka.rt"
                                    class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                            <div class="col">
                                <label>RW</label>
                                <input type="number" pattern="/^-?\d+\.?\d*$/"
                                    onKeyPress="if(this.value.length==2) return false;" v-model="dataKaka.rw"
                                    class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                        </div>
                        <div class="form-row mt-2">
                            <div class="col">
                                <label>Desa / Kelurahan</label>
                                <input type="text" v-model="dataKaka.desa_kelurahan" name="desa" maxlength="50"
                                    class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                            <div class="col">
                                <label>Kecamatan</label>
                                <input type="text" v-model="dataKaka.kecamatan" name="desa" maxlength="50"
                                    class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                        </div>
                        <div class="form-row mt-2">
                            <div class="col">
                                <label>Kabupaten / Kota</label>
                                <input type="text" v-model="dataKaka.kabupaten_kota" name="desa" maxlength="50"
                                    class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                            <div class="col">
                                <label>Provinsi</label>
                                <input type="text" v-model="dataKaka.provinsi" id="provinsi" maxlength="20"
                                    class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                            <div class="col">
                                <label>Kode Pos</label>
                                <input type="number" pattern="/^-?\d+\.?\d*$/"
                                    onKeyPress="if(this.value.length==6) return false;" id="zip"
                                    v-model="dataKaka.kode_pos" class="form-control" :disabled="!disable" @input="inputV">
                                    
                            </div>
                        </div>
                        <button v-show="updateShow" type="button" class="btn btn-danger mt-3 mr-2 text-light"
                            @click="iniCancel">Cancel</button>
                        <button v-show="updateShow" class="btn mt-3 text-light" style="background-color:#52734D;"
                            type="submit">{{buttonVal}}</button>
                        <button v-show="title == 'Tambah'" class="btn mt-3 text-light" style="background-color:#52734D;"
                            type="submit">{{buttonVal}}</button>
                        </form>
                        <small v-show="smali">Semua data harus diisi!</small>
                </div>
            </div>

        </div>
        <Success style="margin-left:20%;" :Sukses="successVal" v-else></Success>
    </div>
</template>

<script>
    import kakaService from '@/services/kakaService';
    import Success from './Success.vue';
    export default {
        name: "AddComponent",
        data() {
            return {
                dataKaka: {
                    "alamat": null,
                    "desa_kelurahan": null,
                    "kabupaten_kota": null,
                    "kecamatan": null,
                    "kode_pos": null,
                    "nomor_kk": null,
                    "provinsi": null,
                    "rt": null,
                    "rw": null
                },
                buttonVal: "Submit",
                viewForm: false,
                successVal: "Inputed",
                title: "Tambah",
                disable: false,
                updateShow: false,
                updateBtn: false,
                inputVw:'',
                smal: false,
                smali:false,
                iniData: {
                    "alamat": '',
                    "desa_kelurahan": '',
                    "kabupaten_kota": '',
                    "kecamatan": '',
                    "kode_pos": '',
                    "nomor_kk": '',
                    "provinsi": '',
                    "rt": '',
                    "rw": ''
                }

            }
        },
        methods: {
            inputKaka() {
                let data = this.dataKaka;
                if (this.buttonVal === "Submit") {
                    if(this.inputVw == '') {
                        this.smali = true
                    } else {
                    kakaService.create(data)
                        .then(response => {
                            console.log(response.data);
                            this.viewForm = true
                            this.successVal = "Inputed"
                        })
                        .catch(e => {
                            let error = e.response.data.trace;
                            if (error.includes("Duplicate entry")) {
                            console.log('Nik Sudah ada')
                            this.smal = true
                    }
                        });
                    }
                } else {
                    kakaService.updateKaka(data.id, data)
                        .then(response => {
                            console.log(response.data);
                            this.viewForm = true;
                            this.successVal = "Updated"
                        })
                        .catch(e => {
                            let error = e.response.data.trace;
                            if (error.includes("Duplicate entry")) {
                            console.log('Sudah ada')
                            this.smal = true
                    }
                        });
                }
            },
            getKakaId(id) {
                kakaService.getById(id)
                    .then(response => {
                        this.dataKaka = response.data;
                        console.log(this.dataKaka);
                    })
                    .catch(e => {
                        console.log(e);
                    })
            },
            updateToggle() {
                this.disable = true
                this.updateShow = true
                this.updateBtn = false
            },
            iniCancel() {
                location.reload();
            },
            inputV(event){
                this.inputVw = event.target.value
            },
            getAll(){
                kakaService.getAll()
                    .then(response => {
                        this.iniData = response.data;
                        console.log(this.iniData);
                        for (let index = 0; index < this.iniData.length; index++) { 
                        this.test = this.iniData[index]        
                }
                    })
                    .catch(e => {
                        console.log(e);

                    })
                }
        },
        components: {
            Success
        },
        props: ['propsKaka'],
        mounted() {
            this.getAll();
            if (this.$route.name == 'detailKK') {
                this.getKakaId(this.$route.params.id);
                this.buttonVal = "Update";
                this.title = "Update";
                this.updateBtn = true
            } else if (this.title == "Tambah") {
                this.disable = true
            }

        }
    }
</script>

<style scoped>
    #add {
        border-radius: 10px;
        margin: 5px;
        margin-left: 200px;
        width: 82.5%;
    }

    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    .card-header {
        background-color: #52734D;

    }
    small {
        font-family: monospace;
        color: red;
    }
</style>