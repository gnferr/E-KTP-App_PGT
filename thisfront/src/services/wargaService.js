import http from "@/http-common";

class wargaService {
    create(data) {
        console.log(data)
        return http.post("/warga/insert", data);
    }

    getAll() {
        return http.get("/warga/getWarga");
    }

    updateWarga(id, data) {
        return http.put(`/warga/update/${id}`, data);
    }

    deleteWarga(id) {
        return http.delete(`/warga/delete/${id}`);
    }

    getById(id) {
        return http.get(`/warga/getIdWarga/${id}`)
    }

    getIdKaka(id_kk) {
        return http.get(`/warga/getById/${id_kk}`)
    }

    deleteByKaka(id_kk) {
        return http.delete(`/warga/deleteByKaka/${id_kk}`)
    }
}

export default new wargaService();