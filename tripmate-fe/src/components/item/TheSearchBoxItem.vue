<template>
    <div>
        <font-awesome-icon
            class="mr-2"
            icon="fa-solid fa-magnifying-glass"
            beat
        />
        <input
            id="search-box-input"
            class="search-form"
            :placeholder="placeholder"
            value=""
        />
    </div>
</template>

<script>
export default {
    data() {
        return {
            placeholder: "검색키워드 지정",
        };
    },
};
</script>

<style>
input {
    width: 20rem;
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
