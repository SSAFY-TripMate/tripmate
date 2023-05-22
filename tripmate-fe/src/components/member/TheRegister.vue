<template>
    <div>
        <div class="register-form">
            <fieldset>
                <h3 class="register-title">회원가입</h3>
                <b class="mb-2" style="display: flex">입력사항</b>
                <div class="register-input-outline">
                    <div class="register-input">
                        <div>
                            <input
                                type="text"
                                name="id"
                                class="inp"
                                placeholder="아이디"
                                onfocus="this.placeholder = ''"
                                onblur="this.placeholder='아이디'"
                            />
                        </div>

                        <div>
                            <input
                                type="password"
                                name="password"
                                placeholder="비밀번호"
                                onfocus="this.placeholder = ''"
                                onblur="this.placeholder='비밀번호'"
                            />
                        </div>

                        <div>
                            <input
                                type="password"
                                name="nickname"
                                placeholder="닉네임"
                                onfocus="this.placeholder = ''"
                                onblur="this.placeholder='닉네임'"
                            />
                        </div>

                        <div>
                            <input
                                type="password"
                                name="email"
                                placeholder="이메일"
                                onfocus="this.placeholder = ''"
                                onblur="this.placeholder='이메일'"
                            />
                        </div>

                        <b-form-select
                            class="register-gender"
                            v-model="selected"
                            :options="options"
                        ></b-form-select>

                        <datepicker-ui
                            class="register-birth"
                            lang="KOR"
                            firstDayOfWeek="sunday"
                            placeholder="생년월일"
                            v-model="birth"
                        ></datepicker-ui>
                    </div>
                </div>

                <b-button
                    class="register-btn mb-2"
                    type="button"
                    size="lg"
                    variant="success"
                >
                    회원가입
                </b-button>

                <div class="register-option">
                    <router-link to="/member/login">로그인</router-link>
                </div>
            </fieldset>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            selected: null,
            options: [
                { value: null, text: "성별" },
                { value: "M", text: "남" },
                { value: "F", text: "여" },
            ],

            birth: null,
        };
    },
};
</script>

<style>
.register-form {
    width: 400px;
    margin: 0px auto;
    padding: 146px 0px 0px;
    box-sizing: border-box;
    margin-bottom: 200px;
}

.register-title {
    font-size: 28px;
    font-weight: 600;
    color: var(--color-black);
    text-align: center;
    margin-bottom: 52px;
}

.register-input-outline {
    border: 1px solid #ced4da;
    padding: 20px;
    background: rgb(248, 248, 248);
    border-radius: 15px;
}

.register-input {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

.register-input :focus {
    border: 3px solid green;
}

input[type="text"],
input[type="password"],
input[type="number"] {
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

.register-gender {
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

.register-btn {
    display: flex;
    width: 100%;
    justify-content: center;
    margin-top: 20px;
}

.register-option {
    display: flex;
    flex-direction: row-reverse;
}
</style>
