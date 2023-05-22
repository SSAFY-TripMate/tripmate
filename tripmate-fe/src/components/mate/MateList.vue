<template>
    <div>
        <div class="header-btn">
            <the-search-box-item
                :searchHolder="'검색할 키워드를 적어주세요'"
            ></the-search-box-item>
            <b-form-group id="order-group" class="flex-form">
                <b-form-radio-group
                    buttons
                    button-variant="primary"
                    class="radio-group"
                    style="display: block"
                    v-model="order"
                >
                    <b-form-radio value="id" class="m-1 radiobtn">
                        <b-badge variant="light" class="badge-color">
                            최신순
                        </b-badge>
                    </b-form-radio>
                    <b-form-radio value="start_date" class="m-1 radiobtn">
                        <b-badge variant="light" class="badge-color">
                            여행 출발 순
                        </b-badge>
                    </b-form-radio>
                </b-form-radio-group>
            </b-form-group>
            <b-button class="btn" @click="moveWrite()">글쓰기</b-button>
        </div>
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
import TheSearchBoxItem from "../item/TheSearchBoxItem.vue";
import MateListItem from "./item/MateListItem.vue";
// import axios from "axios";

export default {
    components: {
        MateListItem,
        TheSearchBoxItem,
    },
    data() {
        return {
            mateList: [],
            order: "id",
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
            // let res = await axios.get("http://localhost:9999/mate/list");
            // this.mateList = await res.data;
            this.mateList = [
                {
                    mateNo: 1,
                    sidoCode: "서울", // code를 서울로 변환해야함
                    startDate: "2023-05-18 09:00:00",
                    endDate: "2023-05-18 18:00:00",
                    preferenceNo: 1,
                    capacity: 10,
                    contact: "example@gmail.com",
                    title: "테스트 제목",
                    content:
                        "내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. ",
                    hit: 1,
                    commentCount: 5,
                    createdTime: "2023-05-18 18:00:00",
                    thumbnail: {
                        imageFolder: "src/upload",
                        imageOriginName: "dog",
                        imageSaveName: "1235323dog",
                        imageType: ".png",
                    },
                    member: {
                        nickname: "김싸피",
                        birth: "1998-05-18 09:00:00",
                        gender: "M",
                    },
                },
                {
                    mateNo: 1,
                    sidoCode: "서울", // code를 서울로 변환해야함
                    startDate: "2023-05-18 09:00:00",
                    endDate: "2023-05-18 18:00:00",
                    preferenceNo: 1,
                    capacity: 10,
                    contact: "example@gmail.com",
                    title: "테스트 제목",
                    content:
                        "내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. ",
                    hit: 1,
                    commentCount: 5,
                    createdTime: "2023-05-18 18:00:00",
                    thumbnail: {
                        imageFolder: "src/upload",
                        imageOriginName: "dog",
                        imageSaveName: "1235323dog",
                        imageType: ".png",
                    },
                    member: {
                        nickname: "김싸피",
                        birth: "1998-05-18 09:00:00",
                        gender: "M",
                    },
                },
                {
                    mateNo: 1,
                    sidoCode: "서울", // code를 서울로 변환해야함
                    startDate: "2023-05-18 09:00:00",
                    endDate: "2023-05-18 18:00:00",
                    preferenceNo: 1,
                    capacity: 10,
                    contact: "example@gmail.com",
                    title: "테스트 제목",
                    content:
                        "내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. ",
                    hit: 1,
                    commentCount: 5,
                    createdTime: "2023-05-18 18:00:00",
                    thumbnail: {
                        imageFolder: "src/upload",
                        imageOriginName: "dog",
                        imageSaveName: "1235323dog",
                        imageType: ".png",
                    },
                    member: {
                        nickname: "김싸피",
                        birth: "1998-05-18 09:00:00",
                        gender: "M",
                    },
                },
                {
                    mateNo: 1,
                    sidoCode: "서울", // code를 서울로 변환해야함
                    startDate: "2023-05-18 09:00:00",
                    endDate: "2023-05-18 18:00:00",
                    preferenceNo: 1,
                    capacity: 10,
                    contact: "example@gmail.com",
                    title: "테스트 제목",
                    content:
                        "내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. ",
                    hit: 1,
                    commentCount: 5,
                    createdTime: "2023-05-18 18:00:00",
                    thumbnail: {
                        imageFolder: "src/upload",
                        imageOriginName: "dog",
                        imageSaveName: "1235323dog",
                        imageType: ".png",
                    },
                    member: {
                        nickname: "김싸피",
                        birth: "1998-05-18 09:00:00",
                        gender: "M",
                    },
                },
                {
                    mateNo: 1,
                    sidoCode: "서울", // code를 서울로 변환해야함
                    startDate: "2023-05-18 09:00:00",
                    endDate: "2023-05-18 18:00:00",
                    preferenceNo: 1,
                    capacity: 10,
                    contact: "example@gmail.com",
                    title: "테스트 제목",
                    content:
                        "내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. ",
                    hit: 1,
                    commentCount: 5,
                    createdTime: "2023-05-18 18:00:00",
                    thumbnail: {
                        imageFolder: "src/upload",
                        imageOriginName: "dog",
                        imageSaveName: "1235323dog",
                        imageType: ".png",
                    },
                    member: {
                        nickname: "김싸피",
                        birth: "1998-05-18 09:00:00",
                        gender: "M",
                    },
                },
                {
                    mateNo: 1,
                    sidoCode: "서울", // code를 서울로 변환해야함
                    startDate: "2023-05-18 09:00:00",
                    endDate: "2023-05-18 18:00:00",
                    preferenceNo: 1,
                    capacity: 10,
                    contact: "example@gmail.com",
                    title: "테스트 제목",
                    content:
                        "내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. 내용입니다. ",
                    hit: 1,
                    commentCount: 5,
                    createdTime: "2023-05-18 18:00:00",
                    thumbnail: {
                        imageFolder: "src/upload",
                        imageOriginName: "dog",
                        imageSaveName: "1235323dog",
                        imageType: ".png",
                    },
                    member: {
                        nickname: "김싸피",
                        birth: "1998-05-18 09:00:00",
                        gender: "M",
                    },
                },
            ];
        },
    },
};
</script>

<style type="text/css">
@import url("/public/css/common.css");
</style>
<style scoped>
.header-btn {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 1em;
    margin-top: 3em;
}
.btn {
    margin-left: auto;
}

.mate-list {
    margin: auto;
    max-width: 1040px;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    /* gap: 24px; */
    box-sizing: border-box;

    display: flex;
    justify-content: flex-start;
    flex-wrap: wrap;
}

.flex-form {
    display: flex;
    margin-bottom: 0;
}
.radiobtn {
    outline: none;
    border-radius: 5px !important;
    border-color: var(--color-reset-button);
    background: var(--color-reset-button) !important;
}
.radiobtn.active {
    border-color: var(--color-active-button);
    background: var(--color-active-button) !important;
}
.badge-color {
    background: none;
}
.btn-primary.disabled,
.btn-primary:disabled {
    border-color: var(--color-reset-button);
}
*.disabled,
*:disabled {
    opacity: 1 !important;
}

/* .btn-primary:not(:disabled):not(.disabled):active,
.btn-primary:not(:disabled):not(.disabled).active,
.show > .btn-primary.dropdown-toggle {
    border-color: var(--color-active-button);
    background: var(--color-active-button) !important;
}
.btn-primary:not(.active),
.btn-primary:not(:active) {
    border-color: var(--color-reset-button);
    background: var(--color-reset-button) !important;
} */
</style>
