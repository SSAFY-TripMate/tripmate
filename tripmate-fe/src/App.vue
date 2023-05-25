<template>
    <div id="app">
        <the-header-navbar></the-header-navbar>
        <router-view></router-view>

        <the-footer></the-footer>
    </div>
</template>

<script>
import TheHeaderNavbar from "@/components/common/TheHeaderNavbar.vue";
import TheFooter from "./components/common/TheFooter.vue";

export default {
    name: "App",
    components: {
        TheHeaderNavbar,
        TheFooter,
    },
};
</script>

<style>
@import url("/public/css/common.css");
@font-face {
    font-family: "KimjungchulGothic-Bold";
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/KimjungchulGothic-Bold.woff2")
        format("woff2");
    font-weight: 400;
    font-style: normal;
}
@font-face {
    font-family: "NanumSquareNeo-Variable";
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2")
        format("woff2");
    font-weight: normal;
    font-style: normal;
}

* {
    font-family: "NanumSquareNeo-Variable", sans-serif;
}

#app {
    font-family: "NanumSquareNeo-Variable", sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

nav {
    padding: 30px;
}

nav a {
    font-weight: bold;
    color: #2c3e50;
}

nav a.router-link-exact-active {
    color: #42b983 !important;
}
</style>
