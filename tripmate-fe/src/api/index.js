import axios from "axios";

// axios.interceptors.request.use(
//     function (config) {
//         // 요청을 보내기 전에 수행할 일
//         // ...
//         console.log("인터셉터 요청 전");
//         return config;
//     },
//     function (error) {
//         // 오류 요청을 보내기전 수행할 일
//         // ...
//         return Promise.reject(error);
//     }
// );

// member Instance
function apiInstance() {
    const instance = axios.create({
        baseURL: "http://70.12.50.84:9999",
        // baseURL: "http://localhost:9999",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    });
    return instance;
}

export { apiInstance };
