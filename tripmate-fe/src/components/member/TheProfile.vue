<template>
    <div class="profile-container">
        <b-container class="bv-example-row mt-5">
            <div>
                <p class="title">내 동행 글</p>
                <div v-if="mates.length != 0" class="mate-list">
                    <mate-list-item
                        v-for="(mate, index) in mates"
                        :key="index"
                        :mate="mate"
                        :sidos="sidos"
                        :preferences="preferences"
                        :pre="'mypage'"
                    ></mate-list-item>
                </div>
                <div v-else>게시글이 없습니다.</div>
                <div class="page-nav">
                    <b-pagination
                        v-model="page.pg"
                        :total-rows="page.total"
                        :per-page="page.spp"
                        pills
                        @page-click="pageClick"
                    ></b-pagination>
                </div>
            </div>
        </b-container>

        <b-container class="bv-example-row mt-5">
            <div class="my-mates">
                <p class="title">내 정보 수정</p>
            </div>

            <div class="profile">
                <h5>닉네임</h5>
                <input type="text" value="" v-model="myInfo.nickname" />
            </div>

            <p class="description">TripMate에서 사용되는 이름입니다.</p>
            <hr />

            <div class="profile">
                <h5>비밀번호</h5>
                <input type="text" value="" v-model="password" />
            </div>

            <p class="description">비밀번호를 변경할 수 있습니다.</p>
            <hr />

            <div class="btn">
                <b-button class="btn-done" @click="update">완료</b-button>
                <b-button class="btn-quit" @click="removeMember"
                    >회원탈퇴</b-button
                >
            </div>
        </b-container>
    </div>
</template>

<script>
import { deleteMember, findMemberByToken, updateMember } from "@/api/member";
import MateListItem from "@/components/mate/item/MateListItem.vue";
import { list } from "@/api/mate";
import { sidoList } from "@/api/area";
import { preferenceList } from "@/api/preference";

export default {
    components: {
        MateListItem,
    },
    data() {
        return {
            mates: [],
            sidos: [],
            preferences: [],
            myInfo: {},
            password: "",
            page: {
                pg: 1,
                spp: 4,
                total: 0,
                start: 0,
                order: "mate_no",
                word: "",
                author: 0,
            },
        };
    },

    created() {
        this.getMateList();

        findMemberByToken(
            (res) => {
                this.myInfo = res.data;
            },
            (error) => {
                alert("내 정보 불러오기 실패" + error);
                this.$router.push("/");
            }
        );
    },

    methods: {
        getMateList() {
            list(
                this.page,
                (res) => {
                    if (res.status == 200) {
                        this.mates = res.data.mates;
                        this.page = res.data.pageNav;
                        return;
                    } else {
                        alert("동행 리스트 에러");
                    }
                },
                (error) => {
                    alert("동행 리스트 에러" + error);
                    // this.$router.push({ name: "home" });
                }
            );
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
            preferenceList(
                (res) => {
                    if (res.status == 200) {
                        this.preferences = res.data;
                        return;
                    } else {
                        alert("preferences 리스트 에러");
                    }
                },
                (error) => {
                    alert("preferences 리스트 에러" + error);
                }
            );
        },
        removeMember() {
            if (confirm("정말로 회원을 탈퇴하시겠습니까?")) {
                deleteMember(
                    this.myInfo.memberNo,
                    () => {
                        alert("회원이 탈퇴되었습니다.");
                        sessionStorage.removeItem("accessToken");
                        this.$router.push("/");
                    },
                    (error) => {
                        if (error.response.data.message == "권한없음") {
                            alert("권한이 없습니다.");
                            this.$router.push("/members/login");
                            return;
                        }
                        alert("회원 탈퇴 실패" + error);
                    }
                );
            }
        },
        update() {
            if (confirm("회원을 수정하시겠습니까?")) {
                let member = {
                    memberNo: this.myInfo.memberNo,
                    nickname: this.myInfo.nickname,
                    password: this.password,
                };
                updateMember(
                    member,
                    (res) => {
                        let accessToken = res.headers.authorization;
                        this.tokenSave(accessToken);
                        alert("정보 변경 완료");
                        this.$router.go();
                    },
                    (error) => {
                        if (error.response.data.message == "권한없음") {
                            alert("권한이 없습니다.");
                            this.$router.push("/members/login");
                            return;
                        }
                        alert("내 정보 변경 실패" + error);
                    }
                );
            }
        },
        pageClick(button, page) {
            if (page != null) this.page.pg = page;
            this.getMateList();
        },
        pageClickOrder() {
            this.page.pg = 1;
            this.getMateList();
        },
        tokenSave(accessToken) {
            sessionStorage.setItem("accessToken", accessToken);
        },
    },
};
</script>

<style scoped>
.my-mates {
    display: flex;
}

.profile {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.title {
    font-size: 30px;
    text-align: left;
}

.description {
    font-size: 0.875rem;
    color: #868e96;
}

input {
    min-height: 3rem;
    padding: 12px;
}

.btn {
    border: none;
    display: flex;
    justify-content: right;
    gap: 5px;
}

.btn-done {
    background: #42b983;
}
.btn-quit {
    background: #ff3217;
}

.profile-container {
    margin-top: 100px;
    margin-bottom: 100px;
}

.mate-list {
    margin: auto;
    max-width: 1040px;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    /* gap: 24px; */
    box-sizing: border-box;

    display: flex;
    justify-content: flex-start;
    flex-wrap: wrap;
}

.page-nav {
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin: 50px;
}
</style>
