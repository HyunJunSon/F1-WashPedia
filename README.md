# WashFit
<p align="center"><img width="1000" height="150" alt="image" src="https://github.com/Kernel360/F1-WashFit-BE/assets/91066575/43b831e5-8608-490c-a8a6-a1c6802b2024" style="width: 100%"></p>


## 🚘 서비스 소개 

    세차용품 안전정보 제공 및 검증 된 세차 관련 정보를 보여주는 플랫폼

<p align="center"><img src="https://github.com/Kernel360/F1-WashFit-BE/assets/91066575/06a42af8-4b98-4c1a-b7ef-15e8a3c578cd" style="width: 60%" ></p>
## | 배포 주소 (로그인 필요시, 테스트 계정 기입)
    배포 주소 :: 
    - https://dev.washfit.site

    테스트용 계정 :: 
    - ID : washfit01 
    - PW : washfit1!

## 💧 주요 기능 
    회원 :: 회원가입, 로그인, 로그아웃, 회원 기본정보 수정, 차량정보 등록/수정, 세차정보 등록/수정
    제품 :: 제품 검색(키워드, 조회순, 위반제품, 최신순)
    배치 :: 제품 정보 요청 및 적재

<br><br>
## 💧 주요 기능 시연 

## | 기능 작성시 상세한 기획/정책/규칙 작성
    회원가입/로그인/로그아웃 :: 
    - JWT 토큰과 해시 알고리즘을 사용하여 구현. Spring Security 사용 X

    제품 정보 요청 :: 
    - 초록누리 API 위해제품목록 요청 
    - 목록 정보를 바탕으로 단일 제품 상세 정보 요청 
    - 상세정보를 서비스에 사용하는 Product 테이블에 추가
    
## 🖥️ 주요 기술 스택

<div>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white">
    <img src="https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/Spring%20Batch-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><br>
  <img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/Spring%20REST%20Docs-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/Querydsl-0?style=for-the-badge&logo=Querydsl&logoColor=white&color=%23FF69B4">
<img src="https://img.shields.io/badge/Fixture%20Monkey-0?style=for-the-badge&logo=Fixture%20Monkey&logoColor=white&color=%2385EA2D">

</div>
<div>
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white">
<img src="https://img.shields.io/badge/Redis-D9281A?style=for-the-badge&logo=redis&logoColor=white">
      <img src="https://img.shields.io/badge/JUnit5-0?style=JUnit5-square&logo=junit5&logoColor=white&color=%2325A162">
  <img src="https://img.shields.io/badge/Swagger-0?style=flat-square&logo=Swagger&logoColor=white&color=%2385EA2D">
  <img src="https://img.shields.io/badge/Flyway-0?style=flat-square&logo=flyway&color=%23CC0200"><br><br>
</div>
<div>
 <img src="https://img.shields.io/badge/Vultr-007BFC?style=for-the-badge&logo=vultr&logoColor=white">

  <img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white">
   <img src="https://img.shields.io/badge/Amazon%20RDS-FF9900?style=for-the-badge&logo=amazon%20rds&logoColor=white">
  <img src="https://img.shields.io/badge/Amazon%20S3-569A31?style=for-the-badge&logo=amazon%20s3&logoColor=white">
<img src="https://img.shields.io/badge/Amazon%20ECR-FF9900?style=for-the-badge&logo=amazon%20ecr&logoColor=white"><br>
  <img src="https://img.shields.io/badge/Github Actions-2088FF?style=for-the-badge&logo=Github Actions&logoColor=white">
    <img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white">
    <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">

</div>
<div>
    <img src="https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=prometheus&logoColor=white">
<img src="https://img.shields.io/badge/Grafana-F46800?style=for-the-badge&logo=grafana&logoColor=white">
    <img src="https://img.shields.io/badge/nGrinder-0?style=for-the-badge&logoColor=white&color=grey">
    <img src="https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white">
</div><br>

![주요기술스택](https://github.com/HyunJunSon/F1-WashPedia/assets/91066575/2a0ee6d3-3bf9-4cf9-bbc1-040129c963fb)<br>
![주요기술스택2](https://github.com/HyunJunSon/F1-WashPedia/assets/91066575/bb3ba2ba-e854-4b70-877b-97b2edd0316c)


<br><br>


## | 아키텍처
### 멀티모듈 구조
![멀티모듈구조](https://github.com/HyunJunSon/F1-WashPedia/assets/91066575/d2cac055-6534-451c-a11e-8fdea146a201)

  <br>
  
### CI/CD 구조
![Dev CI/CD](https://github.com/HyunJunSon/F1-WashPedia/assets/91066575/ceeb1336-9fbd-448b-9716-afb0a074bce9)
![Prod CI/CD](https://github.com/HyunJunSon/F1-WashPedia/assets/91066575/4de3bc71-d299-4acc-84a6-36b5fa7af68f)



## 👩‍👦‍👦👨‍👨‍👧‍👧 팀원소개

### Backend

<table>
  <tr>
    <td align="center" width="120px">
      <a href="https://github.com/gunsight1">  
        <img src="https://github.com/Kernel360/blog-image/blob/main/kernel-crew-1/crew-image/%EC%A0%95%EC%A7%80%EC%9A%A9.png?raw=true" alt="정지용 프로필" />
      </a>
    </td>
   <td align="center" width="120px">
      <a href="https://github.com/linglong67">  
        <img src="https://github.com/Kernel360/blog-image/blob/8b5c7975367ed48f7ccd0bd4490003e92f5479f6/kernel-crew-1/crew-image/%EA%B9%80%EC%98%81%EB%A1%B1.png" alt="김영롱 프로필" />
      </a>
    </td>
    <td align="center" width="120px">
      <a href="https://github.com/cgk95">  
        <img src="https://github.com/Kernel360/blog-image/blob/main/kernel-crew-1/crew-image/%EA%B9%80%EC%B0%AC%EA%B7%9C.png?raw=true" alt="김찬규 프로필" />
      </a>
    </td>
    <td align="center" width="120px">
      <a href="https://github.com/HyunJunSon">  
        <img src="https://github.com/Kernel360/blog-image/blob/8b5c7975367ed48f7ccd0bd4490003e92f5479f6/kernel-crew-1/crew-image/%EC%86%90%ED%98%84%EC%A4%80.png" alt="손현준 프로필" />
      </a>
    </td>
  </tr>

</table>
