<template>
    <router-link
        style="text-decoration: none; color: #000000"
        :to="'/mate/detail/' + mate.mateNo"
    >
        <div class="card-container d-flex justify-content-center mt-3">
            <div class="card">
                <div class="top-container">
                    <div class="head-text middle-container">
                        {{ mate.sidoCode }}
                    </div>
                    <div class="head-date">
                        {{ mate.startDate | yyyyMMdd }} ~
                        {{ mate.endDate | yyyyMMdd }}
                    </div>
                </div>

                <div class="head-title">
                    {{ mate.title }}
                </div>

                <div
                    class="thumbnail-box d-flex justify-content-between align-items-center mt-3"
                >
                    <img
                        class="thumbnail"
                        src="https://picsum.photos/600/300/?image=21"
                        alt=""
                    />
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
                        #휴양
                        <!-- {{ mate.preferenceNo|hasttag }} --></span
                    >
                </div>
            </div>
        </div>
    </router-link>
</template>

<script>
export default {
    props: {
        mate: Object,
    },
    filters: {
        yyyyMMdd: function (value) {
            // 들어오는 value 값이 공백이면 그냥 공백으로 돌려줌
            if (value == "") return "";

            // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
            var js_date = new Date(value);

            // 연도, 월, 일 추출
            var year = js_date.getFullYear();
            var month = js_date.getMonth() + 1;
            var day = js_date.getDate();

            // 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
            if (month < 10) {
                month = "0" + month;
            }

            if (day < 10) {
                day = "0" + day;
            }

            // 최종 포맷 (ex - '2021/10/08')
            return year.toString().substring(2, 4) + "/" + month + "/" + day;
        },
        age: function (value) {
            // 들어오는 value 값이 공백이면 그냥 공백으로 돌려줌
            if (value == "") return "";

            // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
            var today = new Date();
            var js_date = new Date(value);

            let age = today.getFullYear() - js_date.getFullYear() + 1;

            return parseInt(age / 10) * 10 + " 대";
        },
        gender: function (value) {
            return value == "M" ? "남성" : value == "F" ? "여성" : "";
        },
        hasttag: function (value) {
            return "#" + value;
        },
    },
};
</script>

<style scope>
body {
    background-color: #eee;
}

.card-container {
    margin: auto 3px;
}
.card {
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

.card:hover {
    transform: scale(1.03);
    transition: 0.5s;
}

.head-text {
    font-size: 15px;
    font-weight: bold;
    color: #272727;
    position: relative;
    top: 8px;
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
}

.thumbnail-box {
    overflow: hidden;
    margin: 10px auto;
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
