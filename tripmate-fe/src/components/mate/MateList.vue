<template>
    <div>
        <div class="header-btn">
            <the-search-box-item
                :searchHolder="'검색할 키워드를 적어주세요'"
            ></the-search-box-item>
            <b-form-group id="order-group" class="flex-form">
                <b-form-radio-group
                    buttons
                    button-variant="primary"
                    class="radio-group"
                    style="display: block"
                    v-model="order"
                >
                    <b-form-radio value="id" class="m-1 radiobtn">
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
    </div>
</template>

<script>
import TheSearchBoxItem from "../item/TheSearchBoxItem.vue";
import MateListItem from "./item/MateListItem.vue";
import sidoList from "@/api/sidoList";
import preferenceList from "@/api/preferenceList";
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
        };
    },
    created() {
        this.sidos = sidoList();
        this.preferences = preferenceList();
        this.getMateList();
    },

    methods: {
        moveWrite() {
            this.$router.push({ name: "matewrite" });
        },
        getMateList() {
            list(
                (res) => {
                    if (res.status == 200) {
                        this.mateList = res.data;
                        // // TODO: 회원 데이터도 받아오기
                        // this.mateList.forEach((element) => {
                        //     element.member = {
                        //         nickname: "김싸피",
                        //         birth: "1998-05-18 09:00:00",
                        //         gender: "M",
                        //     };
                        // });
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

/* .btn-primary:not(:disabled):not(.disabled):active,
.btn-primary:not(:disabled):not(.disabled).active,
.show > .btn-primary.dropdown-toggle {
    border-color: var(--color-active-button);
    background: var(--color-active-button) !important;
}
.btn-primary:not(.active),
.btn-primary:not(:active) {
    border-color: var(--color-reset-button);
    background: var(--color-reset-button) !important;
} */
</style>
