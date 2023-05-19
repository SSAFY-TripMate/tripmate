<template>
    <div>
        <footer class="footer-items mt-5">
            <div class="footer-left-item">
                <p>TripMate</p>
                <!-- <img
                    class="footer_footerImg__1iADK"
                    src="images/logo/footer.png"
                    alt="footer logo"
                /> -->
                <div class="footer-info">
                    <div class="footer_title">Developer</div>
                    <div class="footer_developer">SSAFY 9th 이용준, 김민정</div>
                </div>
                <div class="footer_copyright">
                    Copyright TripMate. All rights reserved
                </div>
            </div>
            <div class="footer-right-item">
                <a href="#" target="_blank" rel="noreferrer">이용약관</a
                ><a href="#" target="_blank" rel="noreferrer"
                    >개인정보처리방침</a
                ><a href="#" target="_blank" rel="noreferrer">서비스소개</a
                ><a href="#" target="_blank" rel="noreferrer">광고상품 소개</a>
            </div>
        </footer>
    </div>
</template>

<script></script>

<style>
.footer-items {
    height: 180px;
    background-color: #f9f9f9;
    display: flex;
    align-items: center;
    justify-content: center;
}

footer {
    background-color: #fff;
    border-radius: 0 0 20px 20px;
    height: 4rem;

    align-items: center;
    justify-content: center;
}

.footer-left-item {
    display: inline-block !important;
    flex-direction: column;
    width: 30%;
}
p {
    display: flex;
}
.footer-info {
    display: flex;
    gap: 20px;
}

.footer_copyright {
    display: flex;
}

.footer-right-item {
    display: flex;
    grid-gap: 50px;
    gap: 50px;
    color: #2f2f2f;
    font-weight: 500;
    font-size: 13px;
    line-height: 17px;
    align-items: center;
    margin-top: 20px;
}
</style>
