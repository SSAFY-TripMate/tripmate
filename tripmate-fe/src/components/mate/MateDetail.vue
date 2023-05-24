<template>
    <b-container class="bv-example-row mt-3">
        <!-- <mate-input-item type="detail" /> -->

        <b-row class="mb-1">
            <b-col style="text-align: left">
                <b-row class="mb-3">
                    <b-col class="center">
                        <b-img
                            :src="mate.thumbnailUrl"
                            fluid
                            alt="Responsive image"
                            class="thumbnail"
                        ></b-img>
                    </b-col>
                </b-row>

                <div class="mt-5 mb-5">
                    <h2>{{ mate.title }}</h2>
                </div>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <div>도시</div>
                    </b-col>
                    <b-col cols="10" class="menu-select">
                        <div>{{ mate.sidoCode | sidoName(this.sidos) }}</div>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <div>여행 테마</div>
                    </b-col>
                    <b-col cols="10" class="menu-select">
                        <div>
                            {{
                                mate.preferenceNo
                                    | preferenceName(this.preferences)
                            }}
                        </div>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <div>여행 기간</div>
                    </b-col>
                    <b-col cols="10" class="menu-select">
                        <datepicker-ui
                            range
                            lang="KOR"
                            firstDayOfWeek="sunday"
                            placeholder="여행 기간을 선택해주세요."
                            v-model="selectedDate"
                            disabled
                        ></datepicker-ui>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <div for="capacity-form">모집 인원</div>
                    </b-col>
                    <b-col cols="10" class="menu-select">
                        {{ mate.capacity | personCnt }}
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <div for="capacity-form">연결 방법</div>
                    </b-col>
                    <b-col cols="10" class="menu-select">
                        <div class="text">{{ mate.contact }}</div>
                    </b-col>
                </b-row>

                <br />
                <br />

                <div id="content-group" label-for="content">
                    <div class="text">
                        {{ mate.content }}
                    </div>
                </div>

                <br />
                <br />

                <div class="bottom-right mt-5 mb-3">
                    <b-button
                        v-if="this.mate.author == true"
                        type="button"
                        variant="primary"
                        class="m-1"
                        @click="deleteMate"
                    >
                        삭제
                    </b-button>

                    <router-link
                        v-if="this.mate.author == true"
                        :to="'/mate/modify/' + mate.mateNo"
                    >
                        <b-button type="button" variant="primary" class="m-1">
                            수정
                        </b-button>
                    </router-link>

                    <b-button
                        type="submit"
                        variant="primary"
                        class="m-1"
                        :to="'/mate/'"
                        >목록</b-button
                    >
                </div>
            </b-col>
        </b-row>

        <comment-input-item :mateNo="mate.mateNo"></comment-input-item>
        <comment-list-item
            v-for="(comment, index) in comments"
            :key="index"
            :comment="comment"
        ></comment-list-item>
    </b-container>
</template>

<script>
import CommentInputItem from "@/components/comment/item/CommentInputItem.vue";
import CommentListItem from "../comment/item/CommentListItem.vue";
import { sidoList } from "@/api/area";
import { preferenceList } from "@/api/preference";
import {
    yyyyMMdd,
    age,
    gender,
    hashtag,
    sidoName,
    preferenceName,
    personCnt,
} from "@/api/mateFilters";

import { detail, commentList, remove } from "@/api/mate";

export default {
    name: "MateDetail",
    components: { CommentInputItem, CommentListItem },
    data() {
        return {
            mate: {},
            isUserid: false,
            sidos: [],
            preferences: [],
            selectedDate: [new Date(), ""],
            fileRecords: [],
            comments: [],
        };
    },

    created() {
        this.getMate();
        this.getComments();
        sidoList(
            (res) => {
                if (res.status == 200) {
                    this.sidos = res.data;
                    return;
                } else {
                    alert("sido 리스트 에러");
                }
            },
            (error) => {
                alert("sido 리스트 에러" + error);
            }
        );
        preferenceList(
            (res) => {
                if (res.status == 200) {
                    this.preferences = res.data;
                    return;
                } else {
                    alert("preferences 리스트 에러");
                }
            },
            (error) => {
                alert("preferences 리스트 에러" + error);
            }
        );
    },
    filters: {
        yyyyMMdd: yyyyMMdd,
        age: age,
        gender: gender,
        hashtag: hashtag,
        sidoName: sidoName,
        preferenceName: preferenceName,
        personCnt: personCnt,
    },
    methods: {
        deleteMate() {
            if (confirm("정말 삭제하시나요?")) {
                let data = {
                    mateNo: this.$route.params.mateno,
                };

                remove(
                    data,
                    (res) => {
                        if (res.status == 200) {
                            this.$router.push({ name: "matelist" });
                            return;
                        } else {
                            alert("동행 삭제 에러");
                        }
                    },
                    (error) => {
                        alert("동행 삭제 에러" + error);
                    }
                );
            }
        },
        getMate() {
            let data = {
                mateNo: this.$route.params.mateno,
            };
            detail(
                data,
                (res) => {
                    if (res.status == 200) {
                        this.mate = res.data;
                        this.selectedDate = [
                            this.mate.startDate,
                            this.mate.endDate,
                        ];
                        this.isUserid = true;
                        return;
                    } else {
                        alert("동행 detail 에러");
                    }
                },
                (error) => {
                    alert("동행 detail 에러" + error);
                    // this.$router.push({ name: "home" });
                }
            );
            this.selectedDate = [this.mate.startDate, this.mate.endDate];
            this.isUserid = true;
        },
        getComments() {
            // TODO: 댓글 axios
            commentList(
                this.$route.params.mateno,
                (res) => {
                    this.comments = res.data;
                },
                (error) => {
                    alert("댓글 불러오기 실패" + error);
                }
            );

            // this.comments = [
            //     {
            //         mateCommentNo: 1,
            //         mateNo: 1,
            //         content: "내용1",
            //         memberNo: 1,
            //         createdTime: "2023-05-18 18:00:00",
            //         member: {
            //             nickname: "김싸피",
            //             birth: "2023-05-18 09:00:00",
            //             gender: "M",
            //         },
            //     },
            //     {
            //         mateCommentNo: 2,
            //         mateNo: 2,
            //         content: "내용2",
            //         memberNo: 1,
            //         createdTime: "2023-05-18 18:00:00",
            //         member: {
            //             nickname: "김싸피",
            //             birth: "2023-05-18 09:00:00",
            //             gender: "F",
            //         },
            //     },
            //     {
            //         mateCommentNo: 3,
            //         mateNo: 3,
            //         content: "내용3",
            //         memberNo: 3,
            //         createdTime: "2023-05-18 18:00:00",
            //         member: {
            //             nickname: "김싸피",
            //             birth: "2023-05-18 09:00:00",
            //             gender: "F",
            //         },
            //     },
            // ];
        },
    },
};
</script>

<style>
.flex-form {
    display: flex;
    margin-bottom: 0;
}
.menu {
    margin: auto 1rem auto 0px;
    text-align: left;
}
.menu > div {
    margin: 0px;
    /* text-align: center; */
}
.menu-select {
    text-align: left;
    margin: auto;
}
.bottom-right {
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
}
.v-calendar .input-field input {
    min-width: 320px;
}
.text {
    white-space: break-spaces;
}

.v-calendar .input-field input:disabled {
    color: black;
    background-color: white;
}

.center {
    text-align: center;
}
.thumbnail {
    max-width: 100%;
    max-height: 500px;
}
</style>
