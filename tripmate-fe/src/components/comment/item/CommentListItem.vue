<template>
    <div class="d-flex">
        <div class="p-2">
            <i class="mt-3 fa fa-reply fa fa-rotate-180" aria-hidden="true"></i>
        </div>
        <div class="flex-fill">
            <div class="card mt-2">
                <div class="card-header">
                    <table>
                        <tbody>
                            <tr class="align-middle">
                                <td rowspan="2" class="pr-2">
                                    <i class="fa fa-user-o fa-2x"></i>
                                </td>
                                <td class="ml">11</td>
                            </tr>
                            <tr>
                                <td>
                                    <font size="2">2020-09-14 22:41:11</font>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <p class="card-text">삭제된 댓글입니다.</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "CommentInputItem",
    components: {},
    data() {
        return {
            sampleData: "",
        };
    },
    setup() {},
    created() {},
    mounted() {},
    unmounted() {},
    methods: {
        registComment() {},
    },
};
</script>

<style></style>
