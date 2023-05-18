<template>
    <b-row class="mb-1">
        <b-col style="text-align: left">
            <b-form>
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
    </b-row>
</template>

<script>
import axios from "axios";

export default {
    name: "MateDetail",

    data() {
        return {
            mateItem: {},
        };
    },

    created() {
        this.getMateItem();
    },
    methods: {
        async getMateItem() {
            let mateNo = this.$route.params.mateno;
            let res = await axios.get(`http://localhost:9999/mate/${mateNo}`);
            this.mateItem = res.data;
        },

        async deleteMateItem() {
            if (confirm("정말로 삭제?")) {
                this.$router.push({ name: "matedelete" });
            }
        },
        moveModify() {
            console.log("AAAAA");
            this.$router.push({
                name: "matemodify",
                params: { mateno: this.$route.params.mateno },
            });
        },
    },
};
</script>

<style></style>
