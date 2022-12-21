<template>
    <div class="container-fluid">
        <div id="login" v-if="!viewForm">
            <div id="foto" class="d-flex justify-content-center font-italic">Foto E-KTP</div>
            <h4 class="d-flex justify-content-center mb-4" style="font-family:monospace;font-weight: 600;">"Selamat
                Datang"</h4>
            <form @submit.prevent="Login">
                <div class="inputGroup">
                    <input type="email" autocomplete="off" v-model="userData.email" @input="input">
                    <label for="name">Email</label>
                </div>
                <div class="inputGroup">
                    <input type="password" autocomplete="off" v-model="userData.password" @input="input">
                    <label for="name">Password</label>
                    <small v-show="alert">Email atau password anda salah!</small>
                    <small v-show="alert2">Data tidak boleh kosong !</small>
                </div>

                <button type="submit" class="btn col-12 font-weight-bold text-light mb-1">Login</button>
            </form>
            <hr>
            <p class="d-flex justify-content-center mb-4">Tidak memiliki akun?<a class="link"
                    @click="mauKemana()">daftar disini!</a></p>
        </div>
        <Register v-else></Register>
    </div>
</template>

<script>
    import userServices from '@/services/userServices';

    import Register from './Register.vue';
    export default {
        name: 'LoginComponent',
        components: {
            Register
        },
        data() {
            return {
                viewForm: false,
                off: false,
                userData: {
                    "email": '',
                    "password": ''
                },
                alert: false,
                alert2: false,
                inputan: '',
            }
        },
        methods: {
            mauKemana() {
                this.viewForm = true
            },
            Login() {
                let data = this.userData;
                userServices.Login(data)
                    .then(response => {
                        console.log(response.data);
                        this.alert = false
                        this.alert2 = false
                        alert('Berhasil Login!')
                        this.$router.push('/Home')
                    })
                    .catch(e => {
                        // let error = e.response.data.trace;
                        console.log(e);
                        if (this.inputan == '') {
                            this.alert2 = true;
                            this.alert = false;
                        } else {
                            this.alert = true;
                            this.alert2 = false;
                        }

                    })
            },
            input(event) {
                this.inputan = event.target.value;
            }
        }
    }
</script>

<style scoped>
    #login {
        margin: 20px 350px 0px 350px;
        background-color: white;
        padding: 2rem 2rem 1rem 2rem;
        box-shadow: 4px 6px 8px 5px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }

    form {
        margin-bottom: 2rem;
        margin-top: 3rem;
    }

    .btn {
        background-color: #52734D;
        border-radius: 20px;
    }

    #foto {
        border: 2px solid #52734D;
        padding: 50px 0px 50px 0px;
        margin-bottom: 2rem;
        border-radius: 10px;
    }

    small {
        color: red;
        font-family: monospace;
        display: flex;
        justify-content: center;
    }

    .inputGroup {
        font-family: 'Segoe UI', sans-serif;
        margin: 1em 0 1em 0;
        max-width: 100%;
        position: relative;
    }

    .inputGroup input {
        font-size: 100%;
        padding: 0.8em;
        outline: none;
        border: 2px solid rgb(200, 200, 200);
        background-color: transparent;
        border-radius: 25px;
        width: 100%;
    }

    .inputGroup label {
        font-size: 100%;
        position: absolute;
        left: 0;
        padding: 0.8em;
        margin-left: 0.5em;
        pointer-events: none;
        transition: all 0.3s ease;
        color: rgb(100, 100, 100);
    }

    .inputGroup :is(input:focus, input:valid)~label {
        transform: translateY(-50%) scale(.9);
        margin: 0em;
        margin-left: 1.3em;
        padding: 0.4em;
        background-color: white;
    }

    .inputGroup :is(input:focus, input:valid) {
        border-color: #dfdfdf;
    }
</style>