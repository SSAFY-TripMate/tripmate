<template>
    <div class="carousel mt-4">
        <b-carousel
            id="carousel-fade"
            style="text-shadow: 0px 0px 2px #000"
            fade
            indicators
            img-width="1200"
            img-height="400"
        >
            <b-carousel-slide
                caption="여행"
                img-src="https://picsum.photos/1200/400/?image=128"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="윤슬"
                img-src="https://picsum.photos/1200/400/?image=126"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="자유"
                img-src="https://picsum.photos/1200/400/?image=124"
            ></b-carousel-slide>
        </b-carousel>
    </div>
</template>

<script>
export default {
    name: "HomeCarousel",
    components: {},
};
</script>

<style scoped>
::v-deep .carousel {
    display: flex;
    max-width: 1200px;
    max-height: 400px;
    padding: 0 20px;
    margin: 0 auto;
    box-sizing: inherit;
}

::v-deep img {
    border-radius: 33px;
}

::v-deep b-button {
    color: aqua;
}

::v-deep .carousel-inner {
    height: fit-content;
}
</style>
