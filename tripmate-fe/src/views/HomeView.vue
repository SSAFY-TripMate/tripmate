<template>
    <div>
        <div class="main-conainer">
            <div class="contents">
                <home-carousel></home-carousel>

                <div class="mate-preview">
                    <div class="left-div">
                        <p>동행을 찾고 있어요</p>
                    </div>
                    <div class="right-div">
                        <p>더보기</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import HomeCarousel from "@/components/home/HomeCarousel.vue";
export default {
    name: "HomeView",
    components: { HomeCarousel },
};
</script>

<style>
.main-conainer {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.contents {
    max-width: 1280px;
}
.mate-preview {
    max-width: 1200px;
    height: 50px;
    display: flex;
    justify-content: space-between;
    padding: 0px 37px;
}
</style>
