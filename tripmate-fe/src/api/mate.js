import { apiInstance } from "@/api/index";

const api = apiInstance();

async function list(success, fail) {
    await api.get("/mates", null).then(success).catch(fail);
}
async function detail(data, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api.get(`/mates/${data.mateNo}`, null).then(success).catch(fail);
}

async function write(formData, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api
        .post("/mates", formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        })
        .then(success)
        .catch(fail);
}

async function modify(data, formData, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api
        .put(`/mates/${data.mateNo}`, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        })
        .then(success)
        .catch(fail);
}

async function remove(data, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api
        .delete(`/mates/${data.mateNo}`, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        })
        .then(success)
        .catch(fail);
}

export { list, detail, write, modify, remove };
