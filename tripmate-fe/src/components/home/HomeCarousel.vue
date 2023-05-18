<template>
    <div class="carousel mt-4">
        <b-carousel
            id="carousel-fade"
            style="text-shadow: 0px 0px 2px #000"
            fade
            indicators
            img-width="1200"
            img-height="350"
        >
            <b-carousel-slide
                img-src="https://picsum.photos/1200/350/?image=10"
            ></b-carousel-slide>
            <b-carousel-slide
                caption="두번째 슬라이드"
                img-src="https://picsum.photos/1200/350/?image=12"
            ></b-carousel-slide>
            <b-carousel-slide
                img-src="https://picsum.photos/1200/350/?image=22"
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

<style scope>
.carousel {
    display: flex;
    max-width: 1200px;
    max-height: 330px;
    padding: 0 20px;
    margin: 0 auto;
    box-sizing: inherit;
}

img {
    border-radius: 40px 40px 40px 40px;
}

b-button {
    color: aqua;
}
</style>
