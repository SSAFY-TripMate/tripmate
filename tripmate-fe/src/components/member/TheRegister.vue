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
                    </div>

                    <b-form-select
                        class="register-gender"
                        v-model="selected"
                        :options="options"
                    ></b-form-select>

                    <!-- 생년월일 -->
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
                    <a href="/member/login">로그인</a>
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
        };
    },
};
</script>

<style scope>
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
}

.register-input {
    display: flex;
    flex-direction: column;
    gap: 15px;
    margin-bottom: 15px;
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
    padding: 30px 20px;
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

.checkbox {
    display: flex;
    align-items: center;
    gap: 10px;
}

input[type="checkbox"] {
    display: flex;
    max-width: 20px;
}

.checkbox span {
    font-size: 15px;
    line-height: 22px;
    box-sizing: border-box;
    color: var(--color-lightGray);
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
