<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <b-alert show><h3>글목록</h3></b-alert>
            </b-col>
        </b-row>
        <b-row>
            <b-col
                ><b-alert show variant="danger">삭제처리중...</b-alert></b-col
            >
        </b-row>
    </b-container>
</template>

<script>
import axios from "axios";

export default {
    name: "MateDelete",
    created() {
        this.deleteMateItem();
        // deleteMate(
        //     mateno,
        //     ({ data }) => {
        //         let msg = "삭제 처리시 문제가 발생했습니다.";
        //         if (data === "success") {
        //             msg = "삭제가 완료되었습니다.";
        //         }
        //         alert(msg);
        //         // 현재 route를 /list로 변경.
        //         this.$router.push({ name: "matelist" });
        //     },
        //     (error) => {
        //         console.log(error);
        //     }
        // );
    },

    methods: {
        async deleteMateItem() {
            let mateno = this.$route.params.mateno;
            let res = await axios.delete(
                `http://localhost:9999/mate/${mateno}`
            );
            if (res.data === "success") {
                alert("삭제 성공");
                this.$router.push({ name: "matelist" });
            } else {
                alert("삭제 에러");
                this.$router.push({ name: "matelist" });
            }
        },
    },
};
</script>

<style></style>
