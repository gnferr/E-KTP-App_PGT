<template>
    <div class="container-fluid">
        <div id="register">
            <div class="col-12 d-flex justify-content-center text-light p-3"
                style="background-color:#52734D;font-size: xx-large;font-family:monospace;border-radius: 10px 10px 0px 0px;">
                "Sign Up"</div>
            <div class="d-flex">
                <div class="col-8 border-right pb-5">
                    <form @submit.prevent="regisValid" id="daftar">
                        <div class="mb-5"></div>
                        <div class="form-group">
                            <label class="badge badge-success">Nama Lengkap</label>
                            <input type="text" v-model="dataUser.nama" id="namalengkap" class="form-control"
                                placeholder="Enter nama lengkap" >
                        </div>
                        <div class="form-group">
                            <label class="badge badge-success">Email</label>
                            <input type="email" v-model="dataUser.email" id="email" class="form-control"
                                placeholder="Enter email" required>
                            <small v-show="error.email">Email sudah digunakan!</small>
                        </div>
                        <div class="form-group">
                            <label class="badge badge-success">Password</label>
                            <input type="password" class="form-control" v-model="dataUser.password" id="password"
                                placeholder="Password" @input="input">
                            <small v-show="alert">Password tidak boleh kosong!</small>
                        </div>
                        <div class="form-group">
                            <label class="badge badge-success">Confirm Password</label>
                            <input type="password" id="repassword" v-model="repass" class="form-control"
                                placeholder="Confirm password">
                            <small v-show="error.pass">Password tidak sama!</small>
                        </div>
                        <div class="mt-4">
                            <button class="btn btn-danger" onclick="window.location.reload()">Login</button> |
                            <button class="btn btn-primary">Register</button>
                        </div>
                    </form>
                </div>
                <div class="foto col-4 d-flex justify-content-center font-italic">
                    Ini Foto E-KTP
                </div>

            </div>
        </div>

    </div>
</template>

<script>
    import userService from '@/services/userServices'
    export default {
        name: 'RegisterComponent',
        data() {
            return {
                dataUser: {
                    "nama": null,
                    "email": null,
                    "password": null
                },
                loginData:[],
                error:{
                    "email": false,
                    "pass":false
                },
                repass: null,
                inputan: '',
                alert: false,
            }
        },
        methods: {
            regisValid() {
                let data = this.dataUser;
                this.error={};
                for(let i = 0 ; i < this.loginData.length;i++){
                    if(this.loginData[i].email == this.dataUser.email){
                        this.error.email = true;
                        this.alert = false
                    }
                }
                
                if (this.dataUser.password != this.repass) {
                    this.error.pass = true
                    this.alert = false
                    console.log('pw tidak sesuai');    
             
                } 
                
                if(this.inputan == '' || this.inputan == null){
                    this.alert = true
                } 

                if(Object.keys(this.error).length === 0){
                    userService.create(data)
                        .then(response => {
                            console.log(response);
                            alert('Berhasil Registrasi akun!!')
                            location.reload();
                            
                        })
                }
                
            },
            input(event) {
                this.inputan = event.target.value;
            },
            getAll(){
                userService.getAll()
                 .then(response => {
                    this.loginData = response.data;
                 })
            }

        },
        mounted(){
            this.getAll();
        }
    }
</script>

<style scoped>
    #register {
        margin: 20px 150px 0px 150px;
        background-color: white;
        box-shadow: 4px 6px 8px 5px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }

    .foto {
        margin: 0px 10px 0px 0px;
        border-left: 1px solid #52734D;
        padding-top: 12rem;
    }

    small {
        font-family: monospace;
        color: red;
    }
</style>
