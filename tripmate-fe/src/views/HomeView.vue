<template>
    <div>
        <div class="main-conainer">
            <div class="contents">
                <home-carousel></home-carousel>
                <mate-preview></mate-preview>
            </div>
        </div>
    </div>
</template>

<script>
import HomeCarousel from "@/components/home/HomeCarousel.vue";
import MatePreview from "@/components/home/MatePreview.vue";

export default {
    name: "HomeView",
    components: {
        HomeCarousel,
        MatePreview,
    },
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
</style>
