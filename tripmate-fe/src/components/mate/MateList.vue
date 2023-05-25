<template>
    <div>
        <div class="header-btn">
            <the-search-box-item
                :searchHolder="'검색할 키워드를 적어주세요'"
                :type="'mateList'"
                :page="page"
                @searchMateList="searchMateList"
            ></the-search-box-item>
            <b-form-group id="order-group" class="flex-form">
                <b-form-radio-group
                    buttons
                    button-variant="primary"
                    class="radio-group"
                    style="display: block"
                    v-model="page.order"
                    @change="pageClickOrder"
                >
                    <b-form-radio value="mate_no" class="m-1 radiobtn">
                        <b-badge variant="light" class="badge-color">
                            최신순
                        </b-badge>
                    </b-form-radio>
                    <b-form-radio value="start_date" class="m-1 radiobtn">
                        <b-badge variant="light" class="badge-color">
                            여행 출발 순
                        </b-badge>
                    </b-form-radio>
                </b-form-radio-group>
            </b-form-group>
            <b-button class="btn" @click="moveWrite()">글쓰기</b-button>
        </div>
        <div class="mate-list">
            <mate-list-item
                v-for="(mate, index) in mateList"
                :key="index"
                :mate="mate"
                :sidos="sidos"
                :preferences="preferences"
            ></mate-list-item>
        </div>
        <div class="page-nav">
            <b-pagination
                v-model="page.pg"
                :total-rows="page.total"
                :per-page="page.spp"
                pills
                @page-click="pageClick"
            ></b-pagination>
        </div>
    </div>
</template>

<script>
import TheSearchBoxItem from "../item/TheSearchBoxItem.vue";
import MateListItem from "./item/MateListItem.vue";
import { sidoList } from "@/api/area";
import { preferenceList } from "@/api/preference";
import { list } from "@/api/mate";

export default {
    components: {
        MateListItem,
        TheSearchBoxItem,
    },
    data() {
        return {
            mateList: [],
            sidos: [],
            preferences: [],
            order: "id",

            page: {
                pg: 1,
                spp: 12,
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

        this.getMateList();
    },
    methods: {
        moveWrite() {
            this.$router.push({ name: "matewrite" });
        },
        getMateList() {
            list(
                this.page,
                (res) => {
                    if (res.status == 200) {
                        this.mateList = res.data.mates;
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
        pageClick(button, page) {
            if (page != null) this.page.pg = page;
            this.getMateList();
        },
        pageClickOrder() {
            this.page.pg = 1;
            this.getMateList();
        },
        searchMateList(keyword) {
            this.page.word = keyword;
            this.getMateList();
        },
    },
};
</script>

<style type="text/css">
@import url("/public/css/common.css");
</style>
<style scoped>
.header-btn {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 1em;
    margin-top: 3em;
}
.btn {
    margin-left: auto;
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

.flex-form {
    display: flex;
    margin-bottom: 0;
}
.radiobtn {
    outline: none;
    border-radius: 5px !important;
    border-color: var(--color-reset-button);
    background: var(--color-reset-button) !important;
}
.radiobtn.active {
    border-color: var(--color-active-button);
    background: var(--color-active-button) !important;
}
.badge-color {
    background: none;
}
.btn-primary.disabled,
.btn-primary:disabled {
    border-color: var(--color-reset-button);
}
*.disabled,
*:disabled {
    opacity: 1 !important;
}
.page-nav {
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin: 50px;
}

.btn-primary:not(:disabled):not(.disabled):active,
.btn-primary:not(:disabled):not(.disabled).active,
.show > .btn-primary.dropdown-toggle {
    border-color: var(--color-active-button);
    background: var(--color-active-button) !important;
}
.btn-primary:not(.active),
.btn-primary:not(:active) {
    border-color: var(--color-reset-button);
    background: var(--color-reset-button) !important;
}
</style>
