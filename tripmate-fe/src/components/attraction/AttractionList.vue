<template>
    <div>
        <div class="hero">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-7">
                        <div class="intro-wrap">
                            <h1 class="mb-5">
                                <span class="d-block">다음 여행지는</span>
                                어디인가요? <span class="typed-words"></span>
                            </h1>

                            <div class="row">
                                <div class="col-12">
                                    <form class="form">
                                        <div class="row mb-2">
                                            <div
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-4"
                                            >
                                                <select
                                                    v-model.number="sidoCode"
                                                    id="search-area"
                                                    class="form-control custom-select"
                                                >
                                                    <option value="0" selected>
                                                        지역
                                                    </option>
                                                    <option value="1">
                                                        서울
                                                    </option>
                                                    <option value="2">
                                                        인천
                                                    </option>
                                                    <option value="3">
                                                        대전
                                                    </option>
                                                    <option value="4">
                                                        대구
                                                    </option>
                                                    <option value="5">
                                                        광주
                                                    </option>
                                                    <option value="6">
                                                        부산
                                                    </option>
                                                    <option value="7">
                                                        울산
                                                    </option>
                                                    <option value="8">
                                                        세종특별자치시
                                                    </option>
                                                    <option value="31">
                                                        경기도
                                                    </option>
                                                    <option value="32">
                                                        강원도
                                                    </option>
                                                    <option value="33">
                                                        충청북도
                                                    </option>
                                                    <option value="34">
                                                        충청남도
                                                    </option>
                                                    <option value="35">
                                                        경상북도
                                                    </option>
                                                    <option value="36">
                                                        경상남도
                                                    </option>
                                                    <option value="37">
                                                        전라북도
                                                    </option>
                                                    <option value="38">
                                                        전라남도
                                                    </option>
                                                    <option value="39">
                                                        제주도
                                                    </option>
                                                </select>
                                            </div>
                                            <div
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-5"
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
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-3"
                                            >
                                                <input
                                                    id="search-keyword"
                                                    class="form-control"
                                                    type="search"
                                                    placeholder="검색어"
                                                    aria-label="검색어"
                                                    v-model="keyword"
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
                                                        type="button"
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
                            <a href="#" class="d-block mb-3"
                                ><img class="img-fluid" :src="area.firstimage"
                            /></a>
                            <span class="d-flex align-items-center loc mb-2">
                                <span class="icon-room mr-3"></span>
                                <span>{{ area.addr1 }} {{ area.addr2 }}</span>
                            </span>
                            <div class="d-flex align-items-center mb-3">
                                <div>
                                    <h3>
                                        <a href="#">{{ area.title }}</a>
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

export default {
    data() {
        return {
            areas: [],
            sidoCode: 0,
            contentTypeId: 0,
            keyword: "",
        };
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
            this.showMap();
        },
    },
};
</script>

<style scoped>
@import "@/assets/attraction/css/bootstrap.min.css";
@import "@/assets/attraction/css/owl.carousel.min.css";
@import "@/assets/attraction/css/owl.theme.default.min.css";
@import "@/assets/attraction/css/jquery.fancybox.min.css";
@import "@/assets/attraction/fonts/icomoon/style.css";
@import "@/assets/attraction/fonts/flaticon/font/flaticon.css";
@import "@/assets/attraction/css/daterangepicker.css";
@import "@/assets/attraction/css/aos.css";
@import "@/assets/attraction/css/style.css";
</style>
