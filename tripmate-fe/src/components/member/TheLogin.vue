<template>
    <div>
        <div class="login-form">
            <fieldset>
                <h3 class="login-title">로그인</h3>

                <div class="login-input" @keyup.enter="loginMember">
                    <div>
                        <input
                            type="text"
                            class="id input-join"
                            placeholder="아이디"
                            onfocus="this.placeholder = ''"
                            onblur="this.placeholder='아이디'"
                            v-model="id"
                        />
                    </div>

                    <div>
                        <input
                            type="password"
                            placeholder="비밀번호"
                            onfocus="this.placeholder = ''"
                            onblur="this.placeholder='비밀번호'"
                            v-model="password"
                            class="input-join"
                        />
                    </div>
                </div>

                <label class="checkbox mt-3"
                    ><input
                        type="checkbox"
                        name="autoLogin"
                        class="input-join input-login-check"
                    /><span>로그인 상태 유지</span></label
                >

                <b-button
                    class="login-btn mb-2"
                    type="button"
                    size="lg"
                    variant="success"
                    @click="loginMember"
                >
                    로그인
                </b-button>

                <div class="login-option">
                    <div class="login-search">
                        <a href="#">이메일 찾기</a>

                        <a class="login-search-password" href="#"
                            >비밀번호 찾기</a
                        >
                    </div>
                    <router-link to="/members/join">회원가입</router-link>
                </div>
            </fieldset>
        </div>
    </div>
</template>

<script>
import { login } from "@/api/member.js";

export default {
    data() {
        return {
            id: null,
            password: null,
        };
    },

    methods: {
        moveHome() {
            this.$router.push("/");
        },
        loginMember() {
            let member = {
                id: this.id,
                password: this.password,
            };

            login(
                member,
                (res) => {
                    let accessToken = res.headers.authorization;
                    alert("로그인 성공");
                    this.tokenSave(accessToken);
                    this.moveHome();
                },
                (error) => {
                    console.log(error);
                    alert("로그인 실패");
                }
            );
        },

        tokenSave(accessToken) {
            sessionStorage.setItem("accessToken", accessToken);
        },
    },
};
</script>

<style scoped>
.login-form {
    width: 400px;
    margin: 0px auto;
    padding: 146px 0px 0px;
    box-sizing: border-box;
    margin-bottom: 200px;
}

.login-title {
    font-size: 28px;
    font-weight: 600;
    color: var(--color-black);
    text-align: center;
    margin-bottom: 52px;
}

.login-input {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

.login-input :focus {
    border: 3px solid green;
}

.input-join {
    display: inline-block;
    width: 100%;
    font-size: 15px;
    line-height: 20px;
    padding: 20px 20px;
    background: rgb(255, 255, 255);
    border: 1px solid #ced4da;
    border-radius: 5px;
    box-sizing: border-box;
    vertical-align: top;
}

.checkbox {
    display: flex;
    align-items: center;
    gap: 10px;
}

.input-login-check {
    display: flex;
    max-width: 20px;
}
.checkbox span {
    font-size: 15px;
    line-height: 22px;
    box-sizing: border-box;
    color: var(--color-lightGray);
}

.login-btn {
    display: flex;
    width: 100%;
    justify-content: center;
}

.login-option {
    display: flex;
    justify-content: space-between;
}

.login-search {
    display: flex;
    gap: 10px;
}
</style>
