import axios from "axios";

// member Instance
function myApiInstance() {
    const instance = axios.create({
        baseURL: "http://localhost:9999",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    });
    return instance;
}

export { myApiInstance };
