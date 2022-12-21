import http from "../http-common";

class kakaService {
    create(data) {
        return http.post("/kaka/insert", data);
    }

    getAll() {
        return http.get("/kaka/getKK");
    }

    updateKaka(id, data) {
        return http.put(`/kaka/update/${id}`, data);
    }

    deleteKaka(id) {
        return http.delete(`/kaka/delete/${id}`);
    }

    getById(id) {
        return http.get(`/kaka/getById/${id}`);
    }
}

export default new kakaService();
