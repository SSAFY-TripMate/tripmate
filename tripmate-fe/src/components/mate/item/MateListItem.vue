<template>
    <router-link :to="'/mate/detail/' + this.mate.mateNo">
        <b-card
            :title="mate.title"
            img-src="https://picsum.photos/600/300/?image=21"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem"
            class="mb-2"
        >
            <b-card-text>
                {{ mate.content }}
            </b-card-text>
        </b-card>
    </router-link>
</template>

<script>
export default {
    props: {
        mate: Object,
    },
};
</script>

<style>
.studyItem_studyItem__1Iipn {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 20px 25px 0;
    width: 300px;
    height: 340px;
    background: #fff;
    border: 2px solid #d1d1d1;
    border-radius: 30px;
    position: relative;
    cursor: pointer;
    transition: 0.2s ease-in;
}

.studyItem_open__1PGn- {
    opacity: 1;
}

a {
    color: inherit;
    text-decoration: none;
}

ul {
    list-style: none;
    margin: 0;
    padding: 0;
}
</style>
