<template>
    <div>
        <div class="mate-preview">
            <p>동행을 찾고있어요</p>
            <p><router-link to="#">더보기</router-link></p>
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
import MateListItem from "@/components/mate/item/MateListItem.vue";

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
};
</script>

<style>
p {
    font-weight: bold;
}
.mate-preview {
    max-width: 1200px;
    height: 50px;
    display: flex;
    justify-content: space-between;
    padding: 0px 37px;
    margin-top: 50px;
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
</style>
