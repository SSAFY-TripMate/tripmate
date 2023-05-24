<template>
    <div>
        <div class="join-form">
            <fieldset>
                <h3 class="join-title">회원가입</h3>
                <b class="mb-2" style="display: flex">입력사항</b>
                <div class="join-input-outline">
                    <div class="join-input">
                        <div>
                            <input
                                type="text"
                                class="inp"
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
                            />
                        </div>

                        <div>
                            <input
                                type="text"
                                placeholder="닉네임"
                                onfocus="this.placeholder = ''"
                                onblur="this.placeholder='닉네임'"
                                v-model="nickname"
                            />
                        </div>

                        <div>
                            <input
                                type="email"
                                maxlength="64"
                                pattern=".+@bestcnd\.co\.kr"
                                placeholder="이메일"
                                onfocus="this.placeholder = ''"
                                onblur="this.placeholder='이메일'"
                                v-model="email"
                            />
                        </div>

                        <b-form-select
                            class="join-gender"
                            v-model="gender"
                            :options="options"
                        ></b-form-select>

                        <datepicker-ui
                            class="join-birth"
                            lang="KOR"
                            firstDayOfWeek="sunday"
                            placeholder="생년월일"
                            v-model="birth"
                        ></datepicker-ui>
                    </div>
                </div>

                <b-button
                    class="join-btn mb-2"
                    type="button"
                    size="lg"
                    variant="success"
                    @click="joinMember"
                >
                    회원가입
                </b-button>

                <div class="join-option">
                    <router-link to="/members/login">로그인</router-link>
                </div>
            </fieldset>
        </div>
    </div>
</template>

<script>
import { join } from "@/api/member.js";

export default {
    data() {
        return {
            options: [
                { value: null, text: "성별" },
                { value: "M", text: "남" },
                { value: "F", text: "여" },
            ],

            id: null,
            password: null,
            nickname: null,
            email: null,
            gender: null,
            birth: null,
        };
    },
    methods: {
        moveLogin() {
            this.$router.push("/members/login");
        },
        moveHome() {
            this.$router.push("/");
        },
        joinMember() {
            let member = {
                id: this.id,
                password: this.password,
                nickname: this.nickname,
                email: this.email,
                gender: this.gender,
                birth: this.birth,
            };

            join(
                member,
                (res) => {
                    if (res.status == 201) {
                        alert("회원가입 성공");
                        this.moveLogin();
                        return;
                    } else {
                        alert("회원가입 에러: " + res);
                    }
                },
                (error) => {
                    if (error.response.data.message === "Invalid token") {
                        alert("권한이 없습니다.");
                        this.moveHome();
                    } else {
                        alert("회원가입 실패");
                    }
                }
            );
        },
    },
};
</script>

<style scoped>
.join-form {
    width: 400px;
    margin: 0px auto;
    padding: 146px 0px 0px;
    box-sizing: border-box;
    margin-bottom: 200px;
}

.join-title {
    font-size: 28px;
    font-weight: 600;
    color: var(--color-black);
    text-align: center;
    margin-bottom: 52px;
}

.join-input-outline {
    border: 1px solid #ced4da;
    padding: 20px;
    background: rgb(248, 248, 248);
    border-radius: 15px;
}

.join-input {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

.join-input :focus {
    border: 3px solid green;
}

input[type="text"],
input[type="password"],
input[type="email"] {
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

.join-gender {
    height: 62px;
    font-weight: 700;
    padding: 0.375rem 1.75rem 0.375rem 20px;
    padding: 6px 25px 6px 20px;
}

.v-calendar .input-field input {
    padding-right: 128px;
}

.v-calendar .calendar .days-selection,
.v-calendar .calendar .selected-field {
    padding-left: 52px;
    padding-right: 59px;
}

.join-btn {
    display: flex;
    width: 100%;
    justify-content: center;
    margin-top: 20px;
}

.join-option {
    display: flex;
    flex-direction: row-reverse;
}
</style>
