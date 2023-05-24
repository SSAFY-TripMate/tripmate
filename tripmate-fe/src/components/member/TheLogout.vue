<template>
    <div><h2>로그아웃 중...</h2></div>
</template>

<script>
export default {
    created() {
        sessionStorage.removeItem("accessToken");

        alert("로그아웃이 완료되었습니다.");
        this.moveHome();
    },

    methods: {
        moveHome() {
            this.$router.push("/");
        },
    },
};
</script>

<style scoped>
h2 {
    justify-content: center;
    padding: 50px;
}
</style>
