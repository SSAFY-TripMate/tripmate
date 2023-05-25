<template>
    <router-link
        style="text-decoration: none; color: #000000"
        :to="'/mate/detail/' + mate.mateNo"
    >
        <div class="card-container d-flex justify-content-center mt-3">
            <div class="card-item">
                <div class="top-container">
                    <div class="head-text">
                        <font-awesome-icon
                            icon="fa-sharp fa-list fa-location-dot"
                        />
                        {{ mate.sidoCode | sidoName(sidos) }}
                    </div>
                    <div class="head-date">
                        {{ mate.startDate | period(mate.endDate) }}
                    </div>
                </div>

                <div class="head-title mt-1">
                    {{ mate.title }}
                </div>

                <div
                    class="thumbnail-box d-flex justify-content-between align-items-center"
                >
                    <img class="thumbnail" :src="mate.thumbnailUrl" alt="" />
                </div>

                <div class="top-container">
                    <div class="img-fluid member-text font-weight-bold">
                        {{ mate.member.nickname }}
                    </div>
                    <div class="tag-container" style="margin-left: auto">
                        <div
                            class="member-text middle-container hashtag"
                            v-if="
                                mate.preferenceNo != '' &&
                                mate.preferenceNo != null
                            "
                        >
                            {{ mate.preferenceNo | hashtag(preferences) }}
                        </div>
                        <div class="member-text middle-container">
                            {{ mate.member.birth | age }}
                        </div>
                        <div class="member-text middle-container">
                            {{ mate.member.gender | gender }}
                        </div>
                    </div>
                </div>

                <div class="member-text ellipsis mt-1 content">
                    {{ mate.content }}
                </div>
                <!-- <div class="hashtag-border pt-2">
                    <span class="hashtag">
                        {{ mate.preferenceNo | hashtag(preferences) }}</span
                    >
                </div> -->
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
    height: 320px;
}
.card-item {
    background-color: #fff;
    width: 250px;
    border-radius: 33px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    padding: 10px !important;
}
.top-container {
    display: flex;
    align-items: center;
    height: 30px;
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
    font-size: 14px;
    font-weight: bold;
    color: var(--color-location);
    position: relative;
    top: 8px;

    display: flex;
    flex-direction: row;
    align-items: center;
}
.head-text > svg {
    margin-right: 5px;
}
.head-date {
    font-size: 13px;
    color: #272727;
    position: relative;
    top: 8px;
    margin-left: auto;
}
.head-title {
    font-size: 14px;
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
    margin: 10px auto 0px auto;
    height: 150px;
}
.thumbnail {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 12px;
}

.member-text {
    font-size: 12px;
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
    padding: 2px 5px;
}
.recent-orders {
    font-size: 16px;
    font-weight: 700;
    color: #5957f9;
    margin-left: 2px;
}
.hashtag {
    font-size: 12px;
    font-weight: 700;
    color: var(--color-hashtag-font);
    background-color: var(--color-hashtag);
}

.content {
    height: 35px;
}

.tag-container {
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
}
.tag-container > div {
    margin-left: 3px;
}
</style>
