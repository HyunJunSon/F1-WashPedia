# F1-WashPedia
    
## | 프로젝트 기획 및 목적
    세차용품 안전정보 제공 및 검증 된 세차 관련 정보를 보여주는 플랫폼

## | 배포 주소 (로그인 필요시, 테스트 계정 기입)
    배포 주소 :: 
    - https://dev.washfit.site

    테스트용 계정 :: 
    - ID : washfit01 
    - PW : washfit1!

## | 주요 기능
    회원 :: 회원가입, 로그인, 로그아웃, 회원 기본정보 수정, 차량정보 등록/수정, 세차정보 등록/수정
    제품 :: 제품 검색(키워드, 조회순, 위반제품, 최신순)
    배치 :: 제품 정보 요청 및 적재
    
## | 기능 작성시 상세한 기획/정책/규칙 작성
    회원가입/로그인/로그아웃 :: 
    - JWT 토큰과 해시 알고리즘을 사용하여 구현. Spring Security 사용 X

    제품 정보 요청 :: 
    - 초록누리 API 위해제품목록 요청 
    - 목록 정보를 바탕으로 단일 제품 상세 정보 요청 
    - 상세정보를 서비스에 사용하는 Product 테이블에 추가
    
## | 아키텍처
### 멀티모듈 구조
  ![멀티모듈구조](https://github.com/Kernel360/F1-WashPedia-BE/assets/73059667/5e008117-fd3b-40b4-ac2e-2cfb52b42ae9)

  <br>
  
### 개발서버 인프라 구조
  ![개발서버인프라구조](https://github.com/Kernel360/F1-WashPedia-BE/assets/73059667/4ef76ccc-6140-4ecb-8704-a4a51f591435)


## | 그 외 정보들
    배포 :: 
    - 운영 배포는 AWS 클라우드를 사용할 예정, 개발 배포를 vultr 사용중

    추후 구현해야 하는 기능 :: 
    - 회원탈퇴(탈퇴회원 관리 정책 필요)
    - 아이디/비밀번호 찾기
    - 즐겨찾기
    - 세차장 위치 정보 검색
    - Admin 페이지
    - 금지어 필터링
    - (제품 추천 시스템)
