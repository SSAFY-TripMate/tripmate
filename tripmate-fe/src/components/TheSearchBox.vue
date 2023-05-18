<template>
    <div>
        <b-icon
            class="search-icon mr-1"
            icon="search"
            animation="throb"
            font-scale="1.5"
        ></b-icon>
        <input class="search-form" placeholder="제목, 게시글 검색" value="" />
    </div>
</template>

<script>
export default {};
</script>

<style>
.search-form {
    width: 200px;
    border: none;
    outline: none;
    padding: 0;
    font-weight: 700;
    font-size: 20px;
}
input {
    width: 20rem;
    height: 2.5rem;
    outline: none;
    font-size: 1rem;
    padding: 0 1.5rem;
    border: 3px solid #4482f7;
    border-radius: 0.5rem;
    margin-right: 0.5rem;
}
</style>
