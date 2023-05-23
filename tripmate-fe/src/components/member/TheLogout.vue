<template>
    <div><h2>로그아웃 중...</h2></div>
</template>

<script>
export default {
    created() {
        sessionStorage.removeItem("accessToken");
        this.moveHome();
    },

    methods: {
        moveHome() {
            this.$router.push("/");
        },
    },
};
</script>

<style>
h2 {
    justify-content: center;
    padding: 50px;
}
</style>
