<template>
    <div>
        <div class="hero">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-7">
                        <div class="intro-wrap">
                            <h1 class="next-trip-title mb-5">
                                <span class="d-block">다음 여행지는</span>
                                어디인가요? <span class="typed-words"></span>
                            </h1>

                            <div class="row">
                                <div class="col-12">
                                    <form class="form">
                                        <div class="row mb-2">
                                            <div
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-3"
                                            >
                                                <select
                                                    v-model.number="sidoCode"
                                                    id="search-area"
                                                    class="form-control custom-select"
                                                >
                                                    <option
                                                        :value="0"
                                                        selected
                                                        disabled
                                                    >
                                                        지역
                                                    </option>
                                                    <option
                                                        v-for="sido in sidos"
                                                        :key="sido.sidoCode"
                                                        :value="sido.sidoCode"
                                                    >
                                                        {{ sido.sidoName }}
                                                    </option>
                                                </select>
                                            </div>
                                            <div
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-3"
                                            >
                                                <select
                                                    v-model.number="
                                                        contentTypeId
                                                    "
                                                    id="search-content-id"
                                                    class="form-control custom-select"
                                                >
                                                    <option value="0" selected>
                                                        관광지 유형
                                                    </option>
                                                    <option value="12">
                                                        관광지
                                                    </option>
                                                    <option value="14">
                                                        문화시설
                                                    </option>
                                                    <option value="15">
                                                        축제공연행사
                                                    </option>
                                                    <option value="25">
                                                        여행코스
                                                    </option>
                                                    <option value="28">
                                                        레포츠
                                                    </option>
                                                    <option value="32">
                                                        숙박
                                                    </option>
                                                    <option value="38">
                                                        쇼핑
                                                    </option>
                                                    <option value="39">
                                                        음식점
                                                    </option>
                                                </select>
                                            </div>
                                            <div
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-6"
                                            >
                                                <input
                                                    id="search-keyword"
                                                    class="form-control"
                                                    type="search"
                                                    placeholder="검색어"
                                                    aria-label="검색어"
                                                    v-model="keyword"
                                                    @keydown.enter="
                                                        searchAttraction
                                                    "
                                                />
                                            </div>
                                        </div>
                                        <div class="row align-items-center">
                                            <div
                                                class="col-sm-12 col-md-12 mb-3 mb-lg-0 col-lg-12"
                                            >
                                                <a href="#attraction-res"
                                                    ><input
                                                        id="btn-search"
                                                        class="btn btn-primary btn-block text-white"
                                                        value="검색"
                                                        @click="
                                                            searchAttraction
                                                        "
                                                    />
                                                </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="slides">
                            <img
                                src="@/assets/attraction/images/hero-slider-3.jpg"
                                alt="Image"
                                class="img-fluid active"
                            />
                            <!-- <img
                                src="@/assets/attraction/images/hero-slider-2.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                            <img
                                src="@/assets/attraction/images/hero-slider-3.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                            <img
                                src="@/assets/attraction/images/hero-slider-4.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                            <img
                                src="@/assets/attraction/images/hero-slider-5.jpg"
                                alt="Image"
                                class="img-fluid"
                            /> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="untree_co-section">
            <div id="attraction-res" class="container">
                <div class="row justify-content-center text-center mb-5">
                    <div class="col-lg-6">
                        <h2
                            class="section-title text-center mb-3"
                            id="list-result"
                        >
                            전국 관광지 정보
                        </h2>
                        <p style="justify-content: center">
                            검색 결과가 아래에 표시됩니다.
                        </p>
                    </div>
                </div>

                <div class="row" id="trip-list">
                    <!-- 관광지 검색 결과 START -->
                    <div
                        class="col-6 col-sm-6 col-md-6 col-lg-3 mb-5 mb-lg-0"
                        v-for="(area, index) in areas"
                        :key="index"
                    >
                        <div class="media-1">
                            <a class="d-block mb-3"
                                ><img
                                    class="attraction_img"
                                    :src="area.firstimage"
                                    v-if="area.firstimage"
                                />
                                <img
                                    class="attraction_img"
                                    src="@/assets/default.png"
                                    v-else
                                />
                            </a>
                            <span class="d-flex align-items-center loc mb-2">
                                <span class="icon-room mr-3"></span>
                                <span>{{ area.addr1 }} {{ area.addr2 }}</span>
                            </span>
                            <div class="d-flex align-items-center mb-3">
                                <div>
                                    <h3>
                                        <a>{{ area.title }}</a>
                                    </h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 관광지 검색 결과 END -->
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { sidoList } from "@/api/area";

export default {
    data() {
        return {
            areas: [],
            sidos: [],
            sidoCode: 0,
            contentTypeId: 0,
            keyword: "",
        };
    },
    created() {
        sidoList(
            (res) => {
                if (res.status == 200) {
                    this.sidos = res.data;
                    return;
                } else {
                    alert("sido 리스트 에러");
                }
            },
            (error) => {
                alert("sido 리스트 에러" + error);
            }
        );
    },
    methods: {
        searchAttraction() {
            // serviceKey는 나중에 숨기거나 백엔드DB 에서 가져오는걸로 수정
            let serviceKey =
                "vKKSsesm6iGMFkc4UrpA3ZhHEWcSVEpqWq7khYNH4V%2BeGJEDFoLgz%2FoTyMONZficXHTEDlXGJ%2BiCRgA6VijxbQ%3D%3D";
            let searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=100&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;

            if (this.sidoCode) searchUrl += `&areaCode=${this.sidoCode}`;
            if (this.contentTypeId)
                searchUrl += `&contentTypeId=${this.contentTypeId}`;
            if (!this.keyword) {
                alert("검색어를 입력해주세요.");
                return;
            } else searchUrl += `&keyword=${this.keyword}`;
            axios.get(searchUrl).then((res) => {
                this.areas = res.data.response.body.items.item;
            });
        },
    },
};
</script>

<style scoped>
body {
    font-family: "NanumSquareNeo-Variable", sans-serif;
    line-height: 1.5;
    background: #ffffff;
    overflow-x: hidden;
    font-size: 14px;
}
body:before {
    content: "";
    position: fixed;
    top: 0;
    left: 0;
    z-index: 99;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.2);
    opacity: 0;
    visibility: hidden;
    -webkit-transition: 0.3s all ease;
    -o-transition: 0.3s all ease;
    transition: 0.3s all ease;
}
body.offcanvas-menu:before {
    opacity: 1;
    visibility: visible;
}

.bg-primary {
    background-color: #1a374d !important;
}

.text-black {
    color: #000000 !important;
}

a {
    color: #1a374d;
    -webkit-transition: 0.3s all ease;
    -o-transition: 0.3s all ease;
    transition: 0.3s all ease;
}
a:hover {
    color: #1a374d;
    text-decoration: none;
}

::-moz-selection {
    background: #000000;
    color: #ffffff;
}

::selection {
    background: #000000;
    color: #ffffff;
}

.text-primary {
    color: #1a374d !important;
}

a.text-primary {
    color: #1a374d !important;
}
a.text-primary:hover {
    color: #1a374d !important;
}

h1,
.h1,
h2,
.h2,
h3,
.h3,
h4,
.h4 {
    /* font-family: "Source Serif Pro", serif; */
    font-family: "NanumSquareNeo-Variable", sans-serif;
}

.btn {
    padding-top: 12px;
    padding-bottom: 12px;
    padding-left: 30px;
    padding-right: 30px;
    border-radius: 30px;
    font-size: 14px;
}
.btn:active,
.btn:focus {
    outline: none;
    -webkit-box-shadow: none;
    box-shadow: none;
}
.btn.btn-primary {
    background: #1a374d;
    border-color: #1a374d;
}
.btn.btn-primary:hover {
    border-color: #1f425c;
    background: #1f425c;
}
.btn.btn-outline-white {
    border: 2px solid #ffffff;
}
.btn.btn-outline-white:hover {
    background: #ffffff;
    color: #1a374d !important;
}

.text-white-opacity {
    opacity: 0.7;
}

.form-control,
.custom-select {
    border: 2px solid #e9ecef;
    font-size: 16px;
    height: 45px;
}
.form-control:active,
.form-control:focus,
.custom-select:active,
.custom-select:focus {
    border-color: #1a374d;
    -webkit-box-shadow: none;
    box-shadow: none;
}

/*PRELOADING------------ */
.position-relative {
    position: relative;
}

.hero {
    padding: 7rem 0 10rem 0;
    background: #6998ab;
    margin-bottom: 100px;
}
.hero.hero-inner {
    padding: 9rem 0 7rem 0;
    margin-bottom: auto;
    background: #1a374d;
}
.hero h1 {
    color: #ffffff;
    font-size: 60px;
}
@media (max-width: 991.98px) {
    .hero h1 {
        font-size: 45px;
    }
}
.hero h1 .typed-words {
    position: relative;
}
.hero h1 .typed-words:before {
    position: absolute;
    height: 7px;
    background-color: #b1d0e0;
    bottom: 0;
    left: 0;
    right: 0;
    content: "";
}
.hero .intro-wrap {
    position: relative;
    z-index: 1;
}
.hero .slides {
    background: #ffffff;
    max-width: 800px;
    left: -100px;
    z-index: 0;
    position: relative;
    border-radius: 200px;
    -webkit-box-shadow: 0 25px 50px -10px rgba(26, 55, 77, 0.4);
    box-shadow: 0 25px 50px -10px rgba(26, 55, 77, 0.4);
    margin-bottom: -200px;
}
@media (max-width: 991.98px) {
    .hero .slides {
        left: 0;
    }
}
.hero .slides img {
    /* position: absolute; */
    border-radius: 200px;
    opacity: 0;
    -webkit-transition: 4s opacity ease;
    -o-transition: 4s opacity ease;
    transition: 4s opacity ease;
    background: #ffffff;
}
.hero .slides img.active {
    opacity: 1;
    z-index: 1;
}

.untree_co-section {
    padding: 70px 0;
}

.section-title {
    position: relative;
    padding-bottom: 20px;
    display: inline-block;
}
.section-title:before {
    content: "";
    position: absolute;
    left: 0;
    bottom: 0;
    width: 30px;
    height: 2px;
    background: #1a374d;
}
.section-title.text-center:before {
    left: 50%;
    -webkit-transform: translateX(-50%);
    -ms-transform: translateX(-50%);
    transform: translateX(-50%);
}

.media-1 {
    text-align: left;
}
.media-1 img {
    border-radius: 20px;
}
.media-1 .loc .icon-room {
    position: relative;
}
.media-1 .loc .icon-room:after {
    content: "";
    width: 24px;
    height: 24px;
    background: rgba(26, 55, 77, 0.1);
    position: absolute;
    left: 50%;
    top: 50%;
    border-radius: 50%;
    -webkit-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
}
.media-1 .deal {
    font-size: 16px;
    margin-bottom: 20px;
    display: block;
}
.media-1 h3 {
    font-size: 20px;
}
.media-1 h3 a {
    color: #000000;
}
.media-1 .price {
    font-size: 15px;
    color: #1a374d;
    font-weight: 700;
    position: relative;
    top: -2px;
}
.media-1 .price sup {
    font-weight: 400;
    font-size: 16px;
    top: -7px;
}

.form {
    position: relative;
    -webkit-box-shadow: 0 15px 30px 0 rgba(0, 0, 0, 0.3);
    box-shadow: 0 15px 30px 0 rgba(0, 0, 0, 0.3);
    border-radius: 10px;
    z-index: 9;
    padding: 30px;
    background: #ffffff;
}

.attraction_img {
    width: 100%;
    height: 144px;
}
</style>
