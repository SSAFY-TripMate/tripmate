<template>
    <div>
        <div class="mate-preview">
            <p>동행을 찾고있어요</p>
            <p><router-link to="/mate/list">더보기</router-link></p>
        </div>

        <div class="mate-list" v-if="mates.length != 0">
            <mate-list-item
                v-for="(mate, index) in mates"
                :key="index"
                :mate="mate"
                :sidos="sidos"
                :preferences="preferences"
            ></mate-list-item>
        </div>

        <div class="mate-list" v-else>
            <div class="temp_items">게시글이 없습니다.</div>
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
::v-deep .mate-preview {
    margin-left: 36px;
    max-width: 1200px;
    height: 50px;
    display: flex;
    padding: 0px 30px;
    margin-top: 50px;
    font-size: 20px;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
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
    margin-bottom: 50px;
}
::v-deep .temp_items {
    width: 100%;
    height: 300px;
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
    justify-content: space-around;
    border-radius: 33px;
}
</style>
