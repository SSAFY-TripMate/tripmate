<template>
    <div>
        <div class="mate-preview">
            <p>동행을 찾고있어요</p>
            <p><router-link to="#">더보기</router-link></p>
        </div>

        <div class="mate-list">
            <!-- <mate-list-item
                v-for="(mate, index) in mateList"
                :key="index"
                :mate="mate"
            ></mate-list-item> -->
            <mate-list></mate-list>
        </div>
    </div>
</template>

<script>
import MateList from "@/components/mate/MateList.vue";

export default {
    components: {
        MateList,
    },
    data() {
        return {
            mates: [],
        };
    },
    created() {},
};
</script>

<style>
p {
    font-weight: bold;
}
.mate-preview {
    max-width: 1200px;
    height: 50px;
    display: flex;
    justify-content: space-between;
    padding: 0px 37px;
    margin-top: 50px;
}

.mate-list {
    margin: auto;
    max-width: 1040px;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    /* gap: 24px; */
    box-sizing: border-box;

    display: flex;
    justify-content: flex-start;
    flex-wrap: wrap;
}
</style>
