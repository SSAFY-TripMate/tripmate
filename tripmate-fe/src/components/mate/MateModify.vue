<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <h3>QnA 수정</h3>
            </b-col>
        </b-row>
        <mate-input-item type="modify" />
    </b-container>
</template>
<script>
import MateInputItem from "./item/MateInputItem.vue";

export default {
    name: "MateModify",
    components: {
        MateInputItem,
    },
};
</script>

<style></style>
