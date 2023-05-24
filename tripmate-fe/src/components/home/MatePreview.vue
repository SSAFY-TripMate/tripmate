<template>
    <div>
        <div class="mate-preview">
            <p>동행을 찾고있어요</p>
            <p><router-link to="#">더보기</router-link></p>
        </div>

        <div class="mate-list">
            <mate-list-item
                v-for="(mate, index) in mates"
                :key="index"
                :mate="mate"
                :sidos="sidos"
                :preferences="preferences"
            ></mate-list-item>
        </div>
    </div>
</template>

<script>
import { list } from "@/api/mate";
import MateListItem from "../mate/item/MateListItem.vue";
import { sidoList } from "@/api/area";
import { preferenceList } from "@/api/preference";

export default {
    components: { MateListItem },
    data() {
        return {
            mates: [],
            sidos: [],
            preferences: [],
            page: {
                pg: 1,
                spp: 8,
                total: 0,
                start: 0,
                order: "mate_no",
                word: "",
            },
        };
    },
    created() {
        sidoList(
            (res) => {
                if (res.status == 200) {
                    this.sidos = res.data;
                    return;
                } else {
                    alert("sido 리스트 에러");
                }
            },
            (error) => {
                alert("sido 리스트 에러" + error);
                // this.$router.push({ name: "home" });
            }
        );
        preferenceList(
            (res) => {
                if (res.status == 200) {
                    this.preferences = res.data;
                    return;
                } else {
                    alert("preferences 리스트 에러");
                }
            },
            (error) => {
                alert("preferences 리스트 에러" + error);
            }
        );
        list(
            this.page,
            (res) => {
                if (res.status == 200) {
                    this.mates = res.data.mates;
                    this.page = res.data.pageNav;
                    return;
                } else {
                    alert("동행 리스트 에러");
                }
            },
            (error) => {
                alert("동행 리스트 에러" + error);
                // this.$router.push({ name: "home" });
            }
        );
    },
};
</script>

<style scoped>
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
