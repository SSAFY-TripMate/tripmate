<template>
    <div>
        <div class="sns-preview">
            <p>많은 사람들이 다녀간 장소를 찾고있어요</p>
            <p><router-link to="#">더보기</router-link></p>
        </div>

        <div class="sns-list">
            <div class="temp_items">게시글이 없습니다.</div>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style scoped>
p {
    font-weight: bold;
}
::v-deep .sns-preview {
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

::v-deep .sns-list {
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
