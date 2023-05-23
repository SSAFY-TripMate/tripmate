<template>
    <router-link
        style="text-decoration: none; color: #000000"
        :to="'/mate/detail/' + mate.mateNo"
    >
        <div class="card-container d-flex justify-content-center mt-3">
            <div class="card-item">
                <div class="top-container">
                    <div class="head-text middle-container">
                        <font-awesome-icon
                            icon="fa-sharp fa-list fa-location-dot"
                        />
                        {{ mate.sidoCode | sidoName(sidos) }}
                    </div>
                    <div class="head-date">
                        {{ mate.startDate | period(mate.endDate) }}
                    </div>
                </div>

                <div class="head-title">
                    {{ mate.title }}
                </div>

                <div
                    class="thumbnail-box d-flex justify-content-between align-items-center mt-3"
                >
                    <img class="thumbnail" :src="mate.thumbnailUrl" alt="" />
                </div>

                <div class="top-container">
                    <div class="img-fluid member-text">
                        {{ mate.member.nickname }}
                    </div>
                    <div
                        class="member-text middle-container"
                        style="margin-left: auto"
                    >
                        {{ mate.member.birth | age }}
                    </div>
                    <div
                        class="member-text middle-container"
                        style="margin-left: 10px"
                    >
                        {{ mate.member.gender | gender }}
                    </div>
                </div>

                <div class="member-text ellipsis">
                    {{ mate.content }}
                </div>
                <div class="hashtag-border pt-2">
                    <span class="hashtag">
                        {{ mate.preferenceNo | hashtag }}</span
                    >
                </div>
            </div>
        </div>
    </router-link>
</template>

<script>
import { period, age, gender, hashtag, sidoName } from "@/api/mateFilters";
export default {
    props: {
        mate: Object,
        sidos: Array,
        preferences: Array,
    },
    filters: {
        period,
        age,
        gender,
        hashtag,
        sidoName,
    },
};
</script>

<style scoped>
body {
    background-color: #eee;
}

.card-container {
    margin: auto 5px;
}
.card-item {
    background-color: #fff;
    width: 250px;
    border-radius: 33px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    padding: 1rem !important;
}
.top-container {
    display: flex;
    align-items: center;
    margin-bottom: 5px;
}
.profile-image {
    border-radius: 10px;
    border: 2px solid #5957f9;
}

.card-item:hover {
    transform: scale(1.03);
    transition: 0.5s;
}

.head-text {
    font-size: 15px;
    font-weight: bold;
    color: #272727;
    position: relative;
    top: 8px;

    display: flex;
    flex-direction: row;
    align-items: center;
}
.head-date {
    font-size: 13px;
    color: #272727;
    position: relative;
    top: 8px;
    margin-left: auto;
}
.head-title {
    font-size: 18px;
    font-weight: bold;
    color: #272727;
    position: relative;
    top: 8px;

    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.thumbnail-box {
    overflow: hidden;
    margin: 10px auto;
    height: 150px;
}
.thumbnail {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 12px;
}

.member-text {
    font-size: 15px;
    color: #272727;
    position: relative;
    top: 8px;
    white-space: break-spaces;
}

.ellipsis {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
}

.middle-container {
    background-color: #eee;
    border-radius: 12px;
    padding: 5px;
}
.recent-orders {
    font-size: 16px;
    font-weight: 700;
    color: #5957f9;
    margin-left: 2px;
}
.hashtag {
    font-size: 16px;
    font-weight: 700;
    color: #272727;
}
</style>
