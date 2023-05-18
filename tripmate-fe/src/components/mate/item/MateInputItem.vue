<template>
    <b-row class="mb-1">
        <b-col style="text-align: left">
            <b-form @submit="onSubmit" @reset="onReset">
                <!-- <b-form-group
                    id="userid-group"
                    label="작성자 id:"
                    label-for="userid"
                    description="작성자를 입력하세요."
                >
                    <b-form-input
                        id="userid"
                        :disabled="isUserid"
                        v-model="article.id"
                        type="text"
                        required
                        placeholder="작성자 입력..."
                    ></b-form-input>
                </b-form-group> -->

                <b-form-group
                    id="title-group"
                    label="제목:"
                    label-for="title"
                    description="제목을 입력하세요."
                >
                    <b-form-input
                        id="title"
                        v-model="mate.title"
                        type="text"
                        required
                        placeholder="제목 입력..."
                    ></b-form-input>
                </b-form-group>

                <b-form-group
                    id="content-group"
                    label="내용:"
                    label-for="content"
                >
                    <b-form-textarea
                        id="content"
                        v-model="mate.content"
                        placeholder="내용 입력..."
                        rows="10"
                        max-rows="15"
                    ></b-form-textarea>
                </b-form-group>

                <b-button
                    type="submit"
                    variant="primary"
                    class="m-1"
                    v-if="this.type === 'register'"
                    >글작성</b-button
                >
                <b-button type="submit" variant="primary" class="m-1" v-else
                    >글수정</b-button
                >
                <b-button type="reset" variant="danger" class="m-1"
                    >초기화</b-button
                >
            </b-form>
        </b-col>
    </b-row>
</template>

<script>
// import { writeArticle, modifyArticle, getArticle } from "@/api/board";
import axios from "axios";

export default {
    name: "MateInputItem",
    data() {
        return {
            mate: {
                mateNo: "",
                memberNo: 1, //this.mate.memberNo,
                title: "",
                content: "",
            },
            isUserid: false,
        };
    },
    props: {
        type: String,
        // mate: Object,
    },
    created() {
        if (this.type === "modify") {
            let param = this.$route.params.mateno;
            axios
                .get(`http://localhost:9999/mate/${param}`)
                .then(({ data }) => {
                    this.mate = data;
                })
                .catch((error) => {
                    console.log(error);
                });
            this.isUserid = true;
        }
    },
    methods: {
        onSubmit(event) {
            event.preventDefault();
            let err = true;
            let msg = "";
            // !this.mate.id &&
            //     ((msg = "작성자 입력해주세요"),
            //     (err = false),
            //     this.$refs.userid.focus());
            // err &&
            !this.mate.title &&
                ((msg = "제목 입력해주세요"),
                (err = false),
                this.$refs.title.focus());
            err &&
                !this.mate.content &&
                ((msg = "내용 입력해주세요"),
                (err = false),
                this.$refs.content.focus());
            if (!err) alert(msg);
            else
                this.type === "register"
                    ? this.registArticle()
                    : this.modifyArticle();
        },
        onReset(event) {
            event.preventDefault();
            this.mate.mateNo = 0;
            this.mate.title = "";
            this.mate.content = "";
            this.movewrite();
        },
        registArticle() {
            let param = {
                memberNo: this.mate.memberNo,
                title: this.mate.title,
                content: this.mate.content,
            };
            axios
                .post("http://localhost:9999/mate", param)
                .then(({ data }) => {
                    let msg = "등록 처리시 문제가 발생했습니다.";
                    if (data === "success") {
                        msg = "등록이 완료되었습니다.";
                    }
                    alert(msg);
                    this.$router.push({ name: "matelist" });
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        modifyArticle() {
            // let param = {
            //     mateNo: this.mate.mateNo,
            //     sidoCode: this.mate.sido,
            //     startDate: this.mate.startDate,
            //     endDate: this.mate.endDate.
            //     memberNo: this.mate.memberNo,
            //     title: this.mate.title,
            //     content: this.mate.content,
            // };
            console.log(this.mate);
            console.log(this.mate.sidoNo);
            axios
                .put("http://localhost:9999/mate", this.mate)
                .then(({ data }) => {
                    let msg = "수정 처리시 문제가 발생했습니다.";
                    if (data === "success") {
                        msg = "수정이 완료되었습니다.";
                    }
                    alert(msg);
                    this.$router.push({
                        name: "matedetail",
                        query: { mateno: this.mate.mateno },
                    });
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        movewrite() {
            this.$router.push({ name: "matewrite" });
        },
    },
};
</script>

<style></style>
