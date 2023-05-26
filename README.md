# **TripMate - 김민정, 이용준**

### **Contributors ✨**

<table>
  <tr>
    <td align="center"><a href="https://lab.ssafy.com/minjeong.kim512"><img src="https://github.com/KimMinJeong05.png?size=200" alt=""/><br /><sub><b>김민정</b></sub></a><br /><a>💻</a></td>
    <td align="center"><a href="https://lab.ssafy.com/jjuny7712"><img src="	https://github.com/jjuny0310.png?size=200" alt=""/><br /><sub><b>이용준</b></sub></a><br /><a>💻</a></td>
  </tr>
</table>

# 기술 스택

- **Front**
  - **JavaScript**
  - **Vue.js**
  - **Bootstrap Vue**
  - **axios**
  
- **Back**
  - **Java 11**
  - **Spring Boot**
  - **Gradle**
  - **MyBatis**
  - **MySQL**
  - **JWT**

- **협업**
  - **Notion**
  - **Git**
  - **GitLab**
  - **GitLab Issue**

- **API**
  - **한국관광공사 국문관광정보 서비스_GW**

# 프로젝트 일정
![image](/uploads/6df77a6875df7da4e5c0bba4a9cf37d4/image.png)

# 프로젝트 발표 자료
- [TripMate_PPT](https://lab.ssafy.com/jjuny7712/tripmate_final_s12/-/blob/main/docs/Tripmate-PPT.pdf)

# Service Architecture
![image](/uploads/1af7cce3d16160a3666481fdb1873bc7/image.png)

# 기능 설명 및 시연 데모
![TripMate_시연영상](/uploads/f75ac35979984131bbbbef79f4aa7cd1/TripMate_시연영상.gif)

# RUN

### Database 설정

```sql
-- 1. mysql 로그인

-- 2. tripmate 데이터베이스 만들기
create database if not exists tripmate default character set utf8mb4;
use tripmate

-- 3. 테이블 및 데이터 구축
source [resources\sql\attraction_schema.sql의 경로]
source [resources\sql\other_schema.sql의 경로]
```

### REST API 실행
```
# jar 파일 실행
java -jar [jar 파일명]

# or SpringBoot 실행
```

### FrontEnd 실행
```bash
npm run serve
```
