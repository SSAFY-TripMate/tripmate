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
                                                    name=""
                                                    id="search-area"
                                                    class="form-control custom-select"
                                                >
                                                    <option value="0">
                                                        지역
                                                    </option>
                                                </select>
                                            </div>
                                            <div
                                                class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-5"
                                            >
                                                <select
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
                                                />
                                            </div>
                                        </div>
                                        <div class="row align-items-center">
                                            <div
                                                class="col-sm-12 col-md-12 mb-3 mb-lg-0 col-lg-12"
                                            >
                                                <a href="#map"
                                                    ><input
                                                        id="btn-search"
                                                        type="button"
                                                        class="btn btn-primary btn-block text-white"
                                                        value="검색"
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
                                src="@/assets/images/attraction/hero-slider-1.jpg"
                                alt="Image"
                                class="img-fluid active"
                            />
                            <img
                                src="@/assets/images/attraction/hero-slider-2.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                            <img
                                src="@/assets/images/attraction/hero-slider-3.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                            <img
                                src="@/assets/images/attraction/hero-slider-4.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                            <img
                                src="@/assets/images/attraction/hero-slider-5.jpg"
                                alt="Image"
                                class="img-fluid"
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="untree_co-section">
            <div class="container">
                <div class="row justify-content-center text-center mb-5">
                    <div class="col-lg-6">
                        <h2
                            class="section-title text-center mb-3"
                            id="list-result"
                        >
                            전국 관광지 정보
                        </h2>
                        <P>검색 결과가 아래에 표시됩니다.</P>
                    </div>
                </div>

                <!-- 지도 -->
                <div
                    class="mb-5"
                    id="map"
                    style="width: 100%; height: 350px"
                ></div>

                <div class="row" id="trip-list">
                    <!-- 관광지 검색 결과 붙이기 -->
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style>
@import "@/assets/js/template/jquery-3.4.1.min.js";
@import "@/assets/js/template/popper.min.js";
@import "@/assets/js/template/bootstrap.min.js";
@import "@/assets/js/template/owl.carousel.min.js";
@import "@/assets/js/template/jquery.animateNumber.min.js";
@import "@/assets/js/template/jquery.waypoints.min.js";
@import "@/assets/js/template/jquery.fancybox.min.js";
@import "@/assets/js/template/aos.js";
@import "@/assets/js/template/moment.min.js";
@import "@/assets/js/template/daterangepicker.js";
@import "@/assets/js/template/typed.js";
@import "@/assets/js/template/text_slide.js";
@import "@/assets/js/template/custom.js";
</style>
