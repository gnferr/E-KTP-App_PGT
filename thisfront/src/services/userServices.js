import http from "../http-common";

class userService {
    create(data) {
        return http.post("/user/insert", data);
    }

    getAll(){
        return http.get("/user/getAll");
    }

    Login(data){
        return http.post("/user/login",data);
    }
}

export default new userService();
