<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <h3>QnA작성</h3>
            </b-col>
        </b-row>
        <mate-input-item type="register" />
    </b-container>
</template>
<script>
import MateInputItem from "./item/MateInputItem.vue";

export default {
    name: "MateWrite",
    components: {
        MateInputItem,
    },
};
</script>

<style></style>
