import LoginPage from '@/pages/LoginPage.vue'
import HomePage from '@/pages/HomePage.vue'
import AddPage from '@/pages/AddPage.vue'
import DetailKaka from '@/pages/DetailKaka.vue'
import MainWarga from '@/pages/ListWarga.vue'
import DetailWarga from '@/pages/DetailWarga.vue'

export default [
    {
        path: '',
        component: LoginPage
    },
    {
        path: '/home',
        component: HomePage
    },
    {
        path: '/addKK',
        component: AddPage
    },
    {
        path: '/detailKK/:id',
        name: 'detailKK',
        component: DetailKaka
    },
    {
        path: '/detailKK/:id/listAnggota',
        name: 'listAnggota',
        component: MainWarga
    },
    {
        path: '/detailKK/:id/listAnggota/detailAnggota/:ide',
        name: 'detailWarga',
        component: DetailWarga
    }
]