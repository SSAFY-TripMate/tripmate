import { apiInstance } from "@/api/index";

const api = apiInstance();

async function sidoList(success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");

    await api.get(`/area/sidos`, null).then(success).catch(fail);
}

export { sidoList };
