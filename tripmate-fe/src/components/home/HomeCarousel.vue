<template>
    <div class="carousel mt-4">
        <b-carousel
            id="carousel-fade"
            style="text-shadow: 0px 0px 2px #000"
            fade
            indicators
            img-width="1500"
            img-height="600"
        >
            <b-carousel-slide
                caption="TripMate에 오신것을 환영합니다."
                img-src="https://picsum.photos/1500/600/?image=33"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="많은 사람들이 동행을 기다리고 있습니다."
                img-src="https://picsum.photos/1500/600/?image=128"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="여행을 떠나보세요"
                img-src="https://picsum.photos/1500/600/?image=126"
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

<style>
.carousel {
    display: flex;
    max-width: 1500px;
    max-height: 600px;
    padding: 0 20px;
    margin: 0 auto;
    box-sizing: inherit;
}

img {
    border-radius: 33px;
}

b-button {
    color: aqua;
}

.carousel-caption {
    bottom: 40% !important;
    color: #dee2e6 !important;
}
</style>
