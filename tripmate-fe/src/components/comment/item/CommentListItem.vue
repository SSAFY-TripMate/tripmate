<template>
    <div class="d-flex">
        <div class="p-2">
            <font-awesome-icon icon="fa-solid fa-share" flip="vertical" />
        </div>
        <div class="flex-fill">
            <div class="card mt-2">
                <div class="card-header">
                    <div style="display: flex">
                        <div class="mr-3">
                            <font-awesome-icon icon="fa-solid fa-user" />
                        </div>
                        <div class="ml">
                            {{ comment.member.nickname }}
                        </div>
                        <div style="margin-left: auto">
                            <font size="2">{{ comment.createdTime }}</font>
                        </div>
                    </div>
                    <!-- <tr>
                                <td>
                                    <font size="2">2020-09-14 22:41:11</font>
                                </td>
                            </tr> -->
                </div>
                <div class="card-body">
                    <p class="card-text">{{ comment.content }}</p>
                </div>
                <div class="card-footer comment-footer">
                    <font-awesome-icon
                        icon="fa-solid fa-trash"
                        @click="delComment"
                        type="button"
                    />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { deleteComment } from "@/api/mate";

export default {
    name: "CommentListItem",
    components: {},
    data() {
        return {};
    },
    props: {
        comment: Object,
    },
    setup() {},
    created() {},
    mounted() {},
    unmounted() {},
    methods: {
        delComment() {
            if (confirm("정말로 삭제 하시겠어요?")) {
                let data = {
                    mateNo: this.comment.mateNo,
                    mateCommentNo: this.comment.mateCommentNo,
                };
                deleteComment(
                    data,
                    () => {
                        this.$router.go(0);
                    },
                    (error) => {
                        if (error.response.data.message == "권한없음") {
                            alert("권한이 없습니다.");
                            this.$router.push("/members/login");
                            return;
                        }
                        alert("댓글 삭제 실패" + error);
                    }
                );
            }
        },
    },
};
</script>

<style scoped>
.comment-footer {
    display: flex;
    justify-content: flex-end;
}
</style>
