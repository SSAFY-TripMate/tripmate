import { myApiInstance } from "@/api/index";

const myApi = myApiInstance();

async function join(member, success, fail) {
    await myApi.post(`/members/join`, member).then(success).catch(fail);
}

async function login(member, success, fail) {
    await myApi.post(`/members/login`, member).then(success).catch(fail);
}

export { join, login };
