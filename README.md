<div>
    <img width="180" alt="로고" src="https://github.com/user-attachments/assets/aa028f1e-51e4-4386-b921-d6052c3ba689" style="float: left; margin-right: 10px;">
    <div>
        <h2 style="margin: 0;">BOARD</h2>
        <p style="margin: 0;">CRUD 게시판 만들기</p>
    </div>
</div>

###  프로젝트 정보  📊


- 진행 목적: 이 프로젝트는 CRUD 기능을 갖춘 게시판을 개발하여 웹 애플리케이션에서 데이터 처리의 기본 원리를 학습하는 것을 목표로 합니다. 이를 통해 데이터 생성(
  Create), 조회(Read), 수정(Update), 삭제(Delete) 과정을 이해하고, 백엔드 기술을 향상시키는 데 중점을 둡니다. 또한 팀 프로젝트를
  통해 협업 능력을 키우고, 코드 작성 및 문제 해결 능력을 강화하는 것을 목표로 합니다.
- 진행 기간: 2024년 9월 24일 ~ 2024년 10월 12일

### 기술 스택  🛠️

- **java17**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **Spring Security**
- **MySQL**
- **JSP**

### 주요 기능 ⭐

- **게시판**: CRUD 기능, 페이징 및 검색 처리
- **사용자 관리**: 회원가입, 로그인, 회원 정보 수정, 회원 탈퇴
- **댓글**: CRUD 기능, 작성자만 삭제 가능

#### 1. 회원가입 및 로그인
- **회원가입**: 아이디(20자 이하), 닉네임(10자 이하), 8~20자의 비밀번호(영문, 숫자, 특수문자 포함) 유효성 검사
- **중복 확인**: 닉네임과 아이디 중복 불가
- **로그인**: 세션 만료는 30분, 로그인해야 이용 가능한 페이지 관리

#### 2. 게시글 관리
- **작성 및 수정**: 제목, 내용 필수 입력. 작성자만 수정/삭제 가능
- **검색 및 정렬**: 닉네임, 제목으로 검색 가능. 최신순, 오래된 순 정렬

#### 3. 댓글 기능
- **작성 및 관리**: 로그인한 사용자만 댓글 작성 가능. 작성자만 삭제 가능. 답글 기능 없음

### 화면 구성 🖥️

### 참여자 👥
<table>
 <tr>
    <td align="center"><a href="https://github.com/jongchan0109"><img src="https://github.com/user-attachments/assets/718ccfd0-3ac9-4171-a874-648810262f23" width="130px;" alt=""></a></td>
    <td align="center"><a href="https://github.com/UnrequiredOne"><img src="https://avatars.githubusercontent.com/u/156090466?s=400&v=4" width="130px;" alt=""></a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/jongchan0109"><b>jongchan0109</b></a></td>
    <td align="center"><a href="https://github.com/UnrequiredOne"><b>UnrequiredOne</b></a></td>
  </tr>
  <tr> 
    <td align="center"><b>김종찬</b></td>
    <td align="center"><b>상승규</b></td>

  </tr> 
</table>

### 역할 분담 🤝

- **김종찬**:
  - 사용자 관리 (회원가입, 로그인, 회원정보 수정, 탈퇴)
  - 게시글 검색 및 페이징 구현
  - 프로젝트 초기 세팅 및 Spring Security 설정

- **상승규**:
  - 게시글 CRUD 기능
  - 댓글 CRUD 기능
  - 게시글 정렬 기능
  - MySQL DB 설계 및 연동

### 소감 ✍️

- 김종찬
  ```
  팀장으로서의 경험
  팀장을 맡아 프로젝트를 이끌면서 팀원과의 소통과 협업의 중요성을 깊게 느꼈습니다. 
  각자의 역할을 명확히 하고, 서로의 작업을 조율하는 과정에서 팀워크의 힘을 실감했습니다.

  사용자 관리 기능
  회원가입과 로그인 시 유효성 검사 및 보안에 대해 깊이 있게 배울 수 있었습니다. 
  특히, Spring Security를 활용하여 사용자 인증을 설정하고 세션 관리를 다루는 과정에서 보안의 중요성을 실감했습니다.

  프로젝트 초기 세팅
  GitHub를 통해 협업하는 경험도 처음으로 하게 되었습니다. 
  버전 관리와 코드의 일관성을 유지하는 것이 얼마나 중요한지를 깨달았고, 
  팀원과의 코드 리뷰를 통해 서로의 아이디어를 공유하고 문제를 해결해 나가는 과정이 특히 기억에 남습니다.
  ```
  
- 상승규
  ```
  
   
  ```
 
