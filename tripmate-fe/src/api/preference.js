import { apiInstance } from "@/api/index";

const api = apiInstance();

async function preferenceList(success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");

    await api.get(`/mates/preferences`, null).then(success).catch(fail);
}

export { preferenceList };
