<template>
    <b-row class="mb-1">
        <b-col style="text-align: left">
            <b-form @submit="onSubmit" @reset="onReset">
                <b-row class="mb-3">
                    <b-col class="menu"> 도시 </b-col>
                    <b-col cols="11" class="menu-select">
                        <b-form-group id="city-group" class="flex-form">
                            <b-form-radio-group
                                buttons
                                v-model="mate.sidoCode"
                                button-variant="primary"
                                class="radio-group"
                                style="display: block"
                            >
                                <b-form-radio
                                    v-for="sido in sidos"
                                    :key="sido.sidoCode"
                                    :value="sido.sidoCode"
                                    class="m-1 radiobtn"
                                >
                                    <b-badge
                                        variant="light"
                                        class="badge-color"
                                        >{{ sido.sidoName }}</b-badge
                                    >
                                </b-form-radio>
                            </b-form-radio-group>
                        </b-form-group>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu"> 여행 테마 </b-col>
                    <b-col cols="11" class="menu-select">
                        <b-form-group id="thema-group" class="flex-form">
                            <b-form-radio-group
                                buttons
                                v-model="mate.preferenceNo"
                                button-variant="primary"
                                class="radio-group mx-n1"
                                style="display: block"
                            >
                                <b-form-radio
                                    v-for="preference in preferences"
                                    :key="preference.preferenceNo"
                                    :value="preference.preferenceNo"
                                    class="m-1 radiobtn"
                                >
                                    <b-badge
                                        variant="light"
                                        class="badge-color"
                                        >{{ preference.title }}</b-badge
                                    >
                                </b-form-radio>
                            </b-form-radio-group>
                        </b-form-group>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu"> 여행 기간 </b-col>
                    <b-col cols="11" class="menu-select">
                        <datepicker-ui
                            range
                            lang="KOR"
                            firstDayOfWeek="sunday"
                            placeholder="여행 기간을 선택해주세요."
                            v-model="selectedDate"
                        ></datepicker-ui>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <label for="capacity-form">모집 인원</label>
                    </b-col>
                    <b-col cols="11" class="menu-select">
                        <b-form-spinbutton
                            id="capacity-form"
                            v-model="mate.capacity"
                            min="0"
                            class="number-form"
                        ></b-form-spinbutton>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <label for="capacity-form">연결 방법</label>
                    </b-col>
                    <b-col cols="11" class="menu-select">
                        <b-form-input
                            v-model="mate.contact"
                            type="text"
                            placeholder="동행과 연결될 방법을 입력해주세요.(ex. 카카오톡 링크)"
                        ></b-form-input>
                    </b-col>
                </b-row>

                <b-row class="mb-3">
                    <b-col class="menu">
                        <label for="capacity-form">썸네일</label>
                    </b-col>
                    <b-col cols="11" class="menu-select">
                        <vue-file-agent
                            ref="vueFileAgent"
                            theme="'list'"
                            multiple="false"
                            deletable="true"
                            meta="true"
                            accept="'.jpg, .png, .gif'"
                            maxSize="'10MB'"
                            helpText="'썸네일 사진을 등록해주세요'"
                            errorText="{
                            type: 'Invalid file type. Only images or zip Allowed',
                            size: 'Files should not exceed 10MB in size',
                        }"
                            @beforedelete="onBeforeDelete($event)"
                            @delete="fileDeleted($event)"
                            v-model="fileRecords"
                        ></vue-file-agent>
                        <!-- https://codepen.io/safrazik/pen/vYEXmQQ -->
                    </b-col>
                </b-row>

                <br />
                <br />

                <!-- <b-form-group
                    id="userid-group"
                    label="작성자 id:"
                    label-for="userid"
                    description="작성자를 입력하세요."
                >
                    <b-form-input
                        id="userid"
                        :disabled="isUserid"
                        v-model="article.id"
                        type="text"
                        required
                        placeholder="작성자 입력..."
                    ></b-form-input>
                </b-form-group> -->

                <b-form-group id="title-group" label="제목:" label-for="title">
                    <b-form-input
                        id="title"
                        v-model="mate.title"
                        type="text"
                        required
                        placeholder="제목을 입력하세요."
                    ></b-form-input>
                </b-form-group>

                <b-form-group
                    id="content-group"
                    label="내용:"
                    label-for="content"
                >
                    <b-form-textarea
                        id="content"
                        v-model="mate.content"
                        placeholder="내용을 입력하세요"
                        rows="10"
                        max-rows="15"
                        required
                    ></b-form-textarea>
                </b-form-group>

                <div class="bottom-right">
                    <b-button
                        type="submit"
                        variant="primary"
                        class="m-1"
                        v-if="this.type === 'register'"
                        >글작성</b-button
                    >
                    <b-button type="submit" variant="primary" class="m-1" v-else
                        >글수정</b-button
                    >
                    <b-button type="reset" variant="danger" class="m-1"
                        >초기화</b-button
                    >
                </div>
            </b-form>
        </b-col>
    </b-row>
</template>

<script>
// import { writeArticle, modifyArticle, getArticle } from "@/api/board";
import axios from "axios";

export default {
    name: "MateInputItem",
    data() {
        return {
            mate: {
                sidoCode: "",
                startDate: "",
                endDate: "",
                preferenceNo: "",
                capacity: "",
                contact: "",
                title: "",
                content: "",
                memberNo: "",
                thumbnail: {
                    imageFolder: "",
                    imageOriginName: "",
                    imageSaveName: "",
                    imageType: "",
                },
            },
            isUserid: false,
            sidos: {},
            preferences: {},
            selectedDate: [new Date(), ""],
            fileRecords: [],
        };
    },
    props: {
        type: String,
        // mate: Object,
    },
    created() {
        if (this.type === "modify") {
            let param = this.$route.params.mateno;
            axios
                .get(`http://localhost:9999/mate/${param}`)
                .then(({ data }) => {
                    this.mate = data;
                })
                .catch((error) => {
                    console.log(error);
                });
            this.isUserid = true;
        } else if (this.type === "register") {
            this.readSido();
            this.readPreference();
        }
    },
    methods: {
        onSubmit(event) {
            event.preventDefault();
            let err = true;
            let msg = "";
            // !this.mate.id &&
            //     ((msg = "작성자 입력해주세요"),
            //     (err = false),
            //     this.$refs.userid.focus());
            // err &&
            !this.mate.title &&
                ((msg = "제목 입력해주세요"),
                (err = false),
                this.$refs.title.focus());
            err &&
                !this.mate.content &&
                ((msg = "내용 입력해주세요"),
                (err = false),
                this.$refs.content.focus());
            if (!err) alert(msg);
            else
                this.type === "register"
                    ? this.registArticle()
                    : this.modifyArticle();
        },
        onReset(event) {
            event.preventDefault();
            this.mate.mateNo = 0;
            this.mate.title = "";
            this.mate.content = "";
            this.movewrite();
        },
        registArticle() {
            // TODO: 작성자 넣기
            this.memberNo = 1;
            // TODO: 파일 정보 추가

            this.mate.startDate = this.selectedDate.startDate;
            this.mate.endDate = this.selectedDate.endDate;

            axios
                .post("http://localhost:9999/mate", this.mate)
                .then(({ data }) => {
                    let msg = "등록 처리시 문제가 발생했습니다.";
                    if (data === "success") {
                        msg = "등록이 완료되었습니다.";
                    }
                    alert(msg);
                    this.$router.push({ name: "matelist" });
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        modifyArticle() {
            // let param = {
            //     mateNo: this.mate.mateNo,
            //     sidoCode: this.mate.sido,
            //     startDate: this.mate.startDate,
            //     endDate: this.mate.endDate.
            //     memberNo: this.mate.memberNo,
            //     title: this.mate.title,
            //     content: this.mate.content,
            // };
            console.log(this.mate);
            console.log(this.mate.sidoNo);
            axios
                .put("http://localhost:9999/mate", this.mate)
                .then(({ data }) => {
                    let msg = "수정 처리시 문제가 발생했습니다.";
                    if (data === "success") {
                        msg = "수정이 완료되었습니다.";
                    }
                    alert(msg);
                    this.$router.push({
                        name: "matedetail",
                        query: { mateno: this.mate.mateno },
                    });
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        readSido() {
            // TODO: sido axios 작성
            this.sidos = [
                {
                    sidoCode: 1,
                    sidoName: "서울",
                },
                {
                    sidoCode: 2,
                    sidoName: "인천",
                },
                {
                    sidoCode: 3,
                    sidoName: "대전",
                },
                {
                    sidoCode: 4,
                    sidoName: "대구",
                },
                {
                    sidoCode: 5,
                    sidoName: "광주",
                },
                {
                    sidoCode: 6,
                    sidoName: "부산",
                },
                {
                    sidoCode: 7,
                    sidoName: "777",
                },
                {
                    sidoCode: 8,
                    sidoName: "888",
                },
                {
                    sidoCode: 9,
                    sidoName: "999",
                },
                {
                    sidoCode: 10,
                    sidoName: "100",
                },
                {
                    sidoCode: 11,
                    sidoName: "111",
                },
                {
                    sidoCode: 12,
                    sidoName: "122",
                },
                {
                    sidoCode: 13,
                    sidoName: "133",
                },
            ];
        },
        readPreference() {
            this.preferences = [
                {
                    preferenceNo: 1,
                    title: "편안함1111",
                    description: "편안한 여행11111",
                },
                {
                    preferenceNo: 2,
                    title: "편안함222",
                    description: "편안한 여행222",
                },
                {
                    preferenceNo: 3,
                    title: "편안함333",
                    description: "편안한 여행333",
                },
                {
                    preferenceNo: 4,
                    title: "편안함444",
                    description: "편안한 여행444",
                },
                {
                    preferenceNo: 5,
                    title: "편안함555",
                    description: "편안한 여행5555",
                },
                {
                    preferenceNo: 6,
                    title: "편안함666",
                    description: "편안한 여행666",
                },
            ];
        },
        onBeforeDelete() {
            // var fileRecords = this.fileRecords;
            // this.$refs.profilePicRef.deleteUpload(
            //     this.uploadUrl,
            //     this.uploadHeaders,
            //     [profilePic]
            // );
            this.fileRecords = [];
            // this.uploaded = false;
        },
        movewrite() {
            this.$router.push({ name: "matewrite" });
        },
    },
};
</script>

<style scope>
:root {
    --color-reset-button: #f0f8ff;
    --color-active-button: #42b983;
}

.flex-form {
    display: flex;
    margin-bottom: 0;
}
.menu {
    margin: auto 1rem auto 0px;
    text-align: left;
}
.menu > label {
    margin: 0px;
}
.menu-select {
    text-align: left;
    margin: auto;
}
.radiobtn {
    outline: none;
    border-radius: 5px !important;
    border-color: var(--color-reset-button);
    background: var(--color-reset-button) !important;
}
.radiobtn.active {
    border-color: var(--color-active-button);
    background: var(--color-active-button) !important;
}

.badge-color {
    background: none;
}

.v-calendar .input-field.long {
    min-width: 320px;
}

.number-form {
    width: fit-content;
}

.grid-block-wrapper .grid-block {
    width: 30%;
}

.bottom-right {
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
}
</style>
