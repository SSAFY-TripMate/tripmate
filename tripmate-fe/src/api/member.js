import { apiInstance } from "@/api/index";

const api = apiInstance();

async function join(member, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api.post(`/members/join`, member).then(success).catch(fail);
}

async function login(member, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api.post(`/members/login`, member).then(success).catch(fail);
}

export { join, login };
