<template>
    <div>
        <div class="login-form">
            <fieldset>
                <h3 class="login-title">로그인</h3>

                <div class="login-input">
                    <div>
                        <input
                            type="text"
                            name="userAccount"
                            class="inp"
                            placeholder="이메일 / 전화번호"
                        />
                    </div>

                    <div>
                        <input
                            type="password"
                            name="userPassword"
                            placeholder="비밀번호"
                        />
                    </div>
                </div>

                <label class="checkbox mt-3"
                    ><input type="checkbox" name="autoLogin" /><span
                        >로그인 상태 유지</span
                    ></label
                >

                <b-button
                    class="login-btn mb-2"
                    type="button"
                    size="lg"
                    variant="success"
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
                    <a href="/member/register">회원가입</a>
                </div>
            </fieldset>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style>
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

input[type="text"],
input[type="password"],
input[type="number"] {
    display: inline-block;
    width: 100%;
    font-size: 15px;
    line-height: 20px;
    padding: 30px 20px;
    background: rgb(255, 255, 255);
    border: 1px solid;
    border-radius: 5px;
    box-sizing: border-box;
    vertical-align: top;
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
