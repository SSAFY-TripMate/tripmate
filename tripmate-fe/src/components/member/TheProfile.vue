<template>
    <div>
        <b-container class="bv-example-row mt-5">
            <div class="my-mates">
                <p class="title">내 동행 글</p>
            </div>
            동행글이 오는 곳
        </b-container>

        <b-container class="bv-example-row mt-5">
            <div class="my-mates">
                <p class="title">내 정보 수정</p>
            </div>

            <div class="profile">
                <h5>닉네임</h5>
                <input type="text" name="nickNameInput" value="" />
            </div>

            <p class="description">TripMate에서 사용되는 이름입니다.</p>
            <hr />

            <div class="profile">
                <h5>비밀번호</h5>
                <input type="text" name="nickNameInput" value="" />
            </div>

            <p class="description">비밀번호를 변경할 수 있습니다.</p>
            <hr />

            <div class="btn">
                <b-button class="btn-done">완료</b-button>
                <b-button class="btn-quit">회원탈퇴</b-button>
            </div>
        </b-container>
    </div>
</template>

<script>
export default {};
</script>

<style>
.my-mates {
    display: flex;
}

.profile {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.title {
    font-size: 30px;
}

.description {
    font-size: 0.875rem;
    color: #868e96;
}

input {
    min-height: 3rem;
    padding: 12px;
}

.btn {
    border: none;
    display: flex;
    justify-content: right;
    gap: 5px;
}

.btn-done {
    background: #42b983;
}
.btn-quit {
    background: #ff3217;
}
</style>
