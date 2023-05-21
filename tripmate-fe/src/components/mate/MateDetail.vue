<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <h3>동행 찾기 Detail</h3>
            </b-col>
        </b-row>
        <mate-input-item type="detail" />
        <comment-input-item></comment-input-item>
        <comment-list-item
            v-for="(comment, index) in comments"
            :key="index"
            :comment="comment"
        ></comment-list-item>
    </b-container>
</template>

<script>
import MateInputItem from "@/components/mate/item/MateInputItem.vue";
import CommentInputItem from "@/components/comment/item/CommentInputItem.vue";
import CommentListItem from "../comment/item/CommentListItem.vue";
// import axios from "axios";

export default {
    name: "MateDetail",
    components: { MateInputItem, CommentInputItem, CommentListItem },
    data() {
        return {
            mateItem: {},
            comments: {},
        };
    },

    created() {
        // this.getMateItem();
        this.getComments();
    },
    methods: {
        // async getMateItem() {
        //     let mateNo = this.$route.params.mateno;
        //     let res = await axios.get(`http://localhost:9999/mate/${mateNo}`);
        //     this.mateItem = res.data;
        // },
        // async deleteMateItem() {
        //     if (confirm("정말로 삭제?")) {
        //         this.$router.push({ name: "matedelete" });
        //     }
        // },
        // moveModify() {
        //     this.$router.push({
        //         name: "matemodify",
        //         params: { mateno: this.$route.params.mateno },
        //     });
        // },
        getComments() {
            // TODO: 댓글 axios
            this.comments = [
                {
                    mateCommentNo: 1,
                    mateNo: 1,
                    content: "내용1",
                    memberNo: 1,
                    createdTime: "2023-05-18 18:00:00",
                    member: {
                        nickname: "김싸피",
                        birth: "2023-05-18 09:00:00",
                        gender: "M",
                    },
                },
                {
                    mateCommentNo: 2,
                    mateNo: 2,
                    content: "내용2",
                    memberNo: 1,
                    createdTime: "2023-05-18 18:00:00",
                    member: {
                        nickname: "김싸피",
                        birth: "2023-05-18 09:00:00",
                        gender: "F",
                    },
                },
                {
                    mateCommentNo: 3,
                    mateNo: 3,
                    content: "내용3",
                    memberNo: 3,
                    createdTime: "2023-05-18 18:00:00",
                    member: {
                        nickname: "김싸피",
                        birth: "2023-05-18 09:00:00",
                        gender: "F",
                    },
                },
            ];
        },
    },
};
</script>

<style></style>
