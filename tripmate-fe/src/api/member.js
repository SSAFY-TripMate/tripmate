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

async function deleteMember(memberNo, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api.delete(`/members/${memberNo}`).then(success).catch(fail);
}

async function findMemberByToken(success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api.get(`/members`).then(success).catch(fail);
}

async function updateMember(member, success, fail) {
    api.defaults.headers["Authorization"] =
        sessionStorage.getItem("accessToken");
    await api
        .put(`/members/${member.memberNo}`, member)
        .then(success)
        .catch(fail);
}

export { join, login, deleteMember, findMemberByToken, updateMember };
