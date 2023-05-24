<template>
    <div class="card mb-2">
        <div class="card-header bg-light">
            <i class="fa fa-comment fa"></i> 댓글
        </div>
        <div class="card-body">
            <div class="list-group list-group-flush">
                <textarea
                    class="form-control"
                    id="exampleFormControlTextarea1"
                    rows="3"
                    type="text"
                    @keyup.enter="registComment"
                    v-model="content"
                ></textarea>
                <button
                    type="button"
                    class="btn btn-dark mt-3"
                    @click="registComment"
                >
                    등록
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import { writeComment } from "@/api/mate";

export default {
    name: "CommentInputItem",
    components: {},
    props: {
        mateNo: Number,
    },
    data() {
        return {
            content: "",
        };
    },
    setup() {},
    created() {},
    mounted() {},
    unmounted() {},
    methods: {
        registComment() {
            let comment = {
                mateNo: this.mateNo,
                content: this.content,
            };
            console.log(comment);
            writeComment(
                comment,
                () => {
                    alert("댓글 쓰기 성공");
                    this.$router.go(0);
                },
                (error) => {
                    alert("댓글 쓰기 실패" + error);
                }
            );
        },
    },
};
</script>

<style></style>
