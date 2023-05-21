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
                    <font-awesome-icon icon="fa-solid fa-trash" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
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
    methods: {},
};
</script>

<style>
.comment-footer {
    display: flex;
    justify-content: flex-end;
}
</style>
