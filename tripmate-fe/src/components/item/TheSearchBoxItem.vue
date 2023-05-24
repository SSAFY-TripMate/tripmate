<template>
    <div>
        <font-awesome-icon
            class="mr-2"
            icon="fa-solid fa-magnifying-glass"
            size="xl"
            @click="getMateList"
        />
        <input
            id="search-box-input"
            class="search-form"
            :placeholder="searchHolder"
            v-model="keyword"
            @keyup.enter="getMateList"
        />
    </div>
</template>

<script>
export default {
    data() {
        return {
            keyword: "",
        };
    },
    props: {
        searchHolder: String,
        type: String,
        page: Object,
    },
    methods: {
        getMateList() {
            this.$emit("searchMateList", this.keyword);
        },
    },
};
</script>

<style scoped>
input {
    width: fit-content !important;
    height: 2.5rem;
    outline: none;
    font-size: 1rem;
    padding: 0 1.5rem;
    border: 1px solid rgb(233, 233, 233);
    border-radius: 0.5rem;
    margin-right: 0.5rem;
    width: 200px;
    padding: 10px;
    font-weight: 700;
    font-size: 18px;
}
</style>
