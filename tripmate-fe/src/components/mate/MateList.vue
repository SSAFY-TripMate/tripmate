<template>
    <div>
        <form>
            <input placeholder="Search" />
            <b-button type="submit">검색</b-button>
        </form>
        <b-button variant="outline-primary" @click="moveWrite()"
            >글쓰기</b-button
        >
        <div class="mate-list">
            <mate-list-item
                v-for="(mate, index) in mateList"
                :key="index"
                :mate="mate"
            ></mate-list-item>
        </div>
    </div>
</template>

<script>
import MateListItem from "./item/MateListItem.vue";
import axios from "axios";

export default {
    components: {
        MateListItem,
    },
    data() {
        return {
            mateList: [],
        };
    },

    created() {
        this.getMateList();

        // this.mateList = [
        //     {
        //         nickname: "다나카",
        //         title: "일본여행 오사카",
        //         content: "안녕하세요 일본여행갈 동행 구해요",
        //     },
        //     {
        //         nickname: "사용자2",
        //         title: "제목2",
        //         content: "내용2",
        //     },
        //     {
        //         nickname: "사용자3",
        //         title: "제목3",
        //         content: "내용3",
        //     },
        //     {
        //         nickname: "사용자4",
        //         title: "제목4",
        //         content: "내용4",
        //     },
        // ];
    },

    methods: {
        moveWrite() {
            this.$router.push({ name: "matewrite" });
        },
        async getMateList() {
            let res = await axios.get("http://localhost:9999/mate/list");
            this.mateList = await res.data;
        },
    },
};
</script>

<style>
.mate-list {
    margin: auto;
    max-width: 1180px;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 24px;
    box-sizing: border-box;
}
</style>
