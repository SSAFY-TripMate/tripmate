import { apiInstance } from "@/api/index";

const api = apiInstance();

async function list(data, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");

    await api
        .get(
            `/mates?pg=${data.pg}&spp=${data.spp}&start=${data.start}&order=${data.order}&word=${data.word}` +
                (data.author != null ? `&author=${data.author}` : ""),
            null
        )
        .then(success)
        .catch(fail);
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

async function commentList(mateNo, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api.get(`/mates/${mateNo}/comments`).then(success).catch(fail);
}

async function writeComment(comment, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api
        .post(`/mates/${comment.mateNo}/comments`, comment)
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

async function deleteComment(data, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api
        .delete(`/mates/${data.mateNo}/comments/${data.mateCommentNo}`)
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

export {
    list,
    detail,
    write,
    commentList,
    deleteComment,
    writeComment,
    modify,
    remove,
};
