<template>
    <div class="card mb-2 mt-5">
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
