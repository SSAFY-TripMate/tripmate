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
                                        v-if="sido.sidoCode !== mate.sidoCode"
                                        variant="light"
                                        class="badge-color"
                                        >{{ sido.sidoName }}</b-badge
                                    >
                                    <b-badge
                                        v-else
                                        variant="light"
                                        class="badge-color"
                                        active
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
                            accept="', .jpeg, .jpg, .png, .gif'"
                            maxSize="'2MB'"
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
                        >작성 완료</b-button
                    >

                    <b-button
                        type="submit"
                        variant="primary"
                        class="m-1"
                        v-if="this.type === 'modify'"
                        >수정 완료</b-button
                    >
                    <b-button
                        type="reset"
                        variant="danger"
                        class="m-1"
                        v-if="
                            this.type === 'modify' || this.type === 'register'
                        "
                        >초기화</b-button
                    >
                    <b-button
                        type="submit"
                        variant="primary"
                        class="m-1"
                        :to="'/mate/'"
                        >목록</b-button
                    >
                </div>
            </b-form>
        </b-col>
    </b-row>
</template>

<script>
import sidoList from "@/api/sidoList";
import preferenceList from "@/api/preferenceList";
import { write, detail, modify } from "@/api/mate";
import { dateFormat } from "@/util/DateFormatByDatepicker";

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
            selectedDate: ["", ""],
            fileRecords: [],
        };
    },
    props: {
        type: String,
        // mate: Object,
    },
    created() {
        this.sidos = sidoList();
        this.preferences = preferenceList();
        if (this.type === "modify") {
            this.getMate();
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
            this.mate = {
                // sidoCode: null,
                // startDate: null,
                // endDate: null,
                // preferenceNo: null,
                // capacity: null,
                // contact: null,
                // title: null,
                // content: null,
                // memberNo: null,
                // thumbnail: {
                //     imageFolder: null,
                //     imageOriginName: null,
                //     imageSaveName: null,
                //     imageType: null,
                // },
            };
            this.isUserid = false;
            this.selectedDate = [new Date(), ""];
            this.fileRecords = [];
        },
        getMate() {
            let data = {
                mateNo: this.$route.params.mateno,
            };
            detail(
                data,
                (res) => {
                    if (res.status == 200) {
                        this.mate = res.data;
                        this.selectedDate = [
                            this.mate.startDate,
                            this.mate.endDate,
                        ];
                        this.isUserid = true;
                        console.log(this.mate);
                        let type = this.mate.thumbnail.imageType.replace(
                            ".",
                            ""
                        );
                        this.fileRecords = [
                            {
                                name: this.mate.thumbnail.imageOriginName,
                                type: "image/" + type,
                                size: 561813 * 2,
                                url: this.mate.thumbnailUrl,
                            },
                        ];
                        return;
                    } else {
                        alert("동행 detail api 에러");
                    }
                },
                (error) => {
                    alert("동행 detail api 에러" + error);
                    // this.$router.push({ name: "home" });
                }
            );
        },
        registArticle() {
            const formData = new FormData();
            let date = dateFormat(this.selectedDate);
            this.mate.startDate = date[0];
            this.mate.endDate = date[1];

            formData.append("mate", JSON.stringify(this.mate));
            formData.append(
                "thumbnail",
                this.fileRecords.length > 0 ? this.fileRecords[0].file : null
            );

            write(
                formData,
                (res) => {
                    if (res.status == 200) {
                        let msg = "등록 처리시 문제가 발생했습니다.";
                        if (res.data === "success") {
                            msg = "등록이 완료되었습니다.";
                        }
                        alert(msg);
                        this.$router.push({ name: "matelist" });
                        return;
                    } else {
                        alert("동행 등록 에러");
                    }
                },
                (error) => {
                    alert("동행 등록 에러" + error);
                }
            );
        },
        modifyArticle() {
            let data = {
                mateNo: this.$route.params.mateno,
            };
            const formData = new FormData();
            let date = dateFormat(this.selectedDate);

            let modify_mate = {
                startDate: date[0],
                endDate: date[1],
                title: this.mate.title,
                mateNo: this.mate.mateNo,
                capacity: this.mate.capacity,
                preferenceNo: this.mate.preferenceNo,
                sidoCode: this.mate.sidoCode,
                contact: this.mate.contact,
                content: this.mate.content,
                thumbnail: this.mate.thumbnail,
            };

            formData.append("mate", JSON.stringify(modify_mate));
            formData.append(
                "thumbnail",
                this.fileRecords.length > 0 &&
                    this.fileRecords[0].file != undefined
                    ? this.fileRecords[0].file
                    : null
            );
            console.log("!!", this.mate);
            console.log(modify_mate);
            console.log(this.fileRecords[0].file);

            modify(
                data,
                formData,
                (res) => {
                    if (res.status == 200) {
                        let msg = "수정 처리시 문제가 발생했습니다.";
                        if (res.data === "success") {
                            msg = "수정이 완료되었습니다.";
                        }
                        alert(msg);
                        this.$router.push({
                            name: "matedetail",
                            query: { mateno: this.mate.mateno },
                        });
                        return;
                    } else {
                        alert("동행 수정 에러");
                    }
                },
                (error) => {
                    alert("동행 수정 에러" + error);
                }
            );
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

<style type="text/css">
@import url("/public/css/common.css");
</style>
<style scoped>
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

.v-calendar .input-field input {
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

.btn-primary.disabled,
.btn-primary:disabled {
    border-color: var(--color-reset-button);
}

*.disabled,
*:disabled {
    opacity: 1 !important;
}

.thumbnail {
    width: 100%;
    object-fit: cover;
}
</style>
