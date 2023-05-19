<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <h3>동행 찾기 Detail</h3>
            </b-col>
        </b-row>
        <mate-input-item type="detail" />
    </b-container>
    <!-- <b-row class="mb-1">
        <b-col style="text-align: left">
            <b-form>

                <b-form-group id="title-group" label="제목:" label-for="title">
                    <b-form-input
                        id="title"
                        v-model="this.mateItem.title"
                        type="text"
                        readonly
                    ></b-form-input>
                </b-form-group>

                <b-form-group
                    id="content-group"
                    label="내용:"
                    label-for="content"
                >
                    <b-form-textarea
                        id="content"
                        v-model="this.mateItem.content"
                        rows="10"
                        max-rows="15"
                        readonly
                    ></b-form-textarea>
                </b-form-group>

                <b-button
                    type="submit"
                    variant="primary"
                    class="m-1"
                    @click="moveModify"
                    >수정</b-button
                >
                <b-button @click="deleteMateItem" variant="danger" class="m-1"
                    >삭제</b-button
                >
            </b-form>
        </b-col>
    </b-row> -->
</template>

<script>
import MateInputItem from "@/components/mate/item/MateInputItem.vue";
// import axios from "axios";

export default {
    name: "MateDetail",
    components: { MateInputItem },
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
