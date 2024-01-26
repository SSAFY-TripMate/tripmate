# **TripMate - 김민정, 이용준**

### **Contributors ✨**

<table>
  <tr>
    <td align="center"><a href="https://github.com/KimMinJeong05"><img src="https://github.com/KimMinJeong05.png?size=200" alt=""/><br /><sub><b>김민정</b></sub></a><br /><a>💻</a></td>
    <td align="center"><a href="https://github.com/jjuny0310"><img src="https://github.com/jjuny0310.png?size=200" alt=""/><br /><sub><b>이용준</b></sub></a><br /><a>💻</a></td>
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
  - **한국관광공사 국문관광정보 서비스\_GW**

# 프로젝트 개요

# 프로젝트 계획

![image](/images/plan.PNG)

# 서비스 아키텍처

![image](/images/architecture.PNG)

# 핵심 기능

- 동행 리스트
  ![image](/images/feature1.PNG)

- 동행 글
  ![image](/images/feature2.PNG)

- 관광지 조회
  ![image](/images/feature3.PNG)

# 시연 데모

![TripMate_시연영상](/images/demo.gif)

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
