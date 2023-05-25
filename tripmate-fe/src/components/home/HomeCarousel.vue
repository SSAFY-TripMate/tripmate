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
                caption="자유"
                img-src="https://picsum.photos/1500/600/?image=33"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="여행"
                img-src="https://picsum.photos/1500/600/?image=128"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="윤슬"
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
</style>
