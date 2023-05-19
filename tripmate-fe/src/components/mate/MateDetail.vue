<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <h3>동행 찾기 Detail</h3>
            </b-col>
        </b-row>
        <mate-input-item type="detail" />
        <comment-input-item></comment-input-item>
    </b-container>
</template>

<script>
import MateInputItem from "@/components/mate/item/MateInputItem.vue";
import CommentInputItem from "@/components/comment/item/CommentInputItem.vue";
// import axios from "axios";

export default {
    name: "MateDetail",
    components: { MateInputItem, CommentInputItem },
    data() {
        return {
            mateItem: {},
        };
    },

    created() {
        // this.getMateItem();
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
    },
};
</script>

<style></style>
