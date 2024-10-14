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

| 메인화면(게시판목록) | 메인화면(ID순 정렬) | 메인화면(페이징) | 로그인화면 |
|:-------------------:|:-------------------:|:----------------:|:-----------:|
| <img src="https://github.com/user-attachments/assets/6888eb0f-cfb9-4722-85f6-e520b7ae190c" width="400px;" alt="메인화면(게시판목록)"/> | <img src="https://github.com/user-attachments/assets/42185bc2-8b5a-43d3-93ad-babb252facca" width="400px;" alt="메인화면(ID순 정렬)"/> | <img src="https://github.com/user-attachments/assets/5cb20bd7-be14-48d0-b38b-e4e8ebed5957" width="400px;" alt="메인화면(페이징)"/> | <img src="https://github.com/user-attachments/assets/f3d19ba0-4cba-412d-a53f-11145f12ea6c" width="400px;" alt="로그인화면"/> |

| 회원정보조회 | 회원정보수정(1) | 회원정보수정(2) | 회원정보수정(3) |
|:------------:|:---------------:|:---------------:|:---------------:|
| <img src="https://github.com/user-attachments/assets/50d68453-aea5-42c3-b7ae-a60147430195" width="400px;" alt="회원정보조회"/> | <img src="https://github.com/user-attachments/assets/9fc9827a-f14e-4cf4-96d5-84dcb6045940" width="400px;" alt="회원정보수정(1)"/> | <img src="https://github.com/user-attachments/assets/03af9db3-e7d4-4e4d-bd4e-6d1694e97843" width="400px;" alt="회원정보수정(2)"/> | <img src="https://github.com/user-attachments/assets/7f81420f-8fc1-4869-b160-c6f8ad719a30" width="400px;" alt="회원정보수정(3)"/> |

| 게시글작성(1) | 게시글작성(2) | 게시글조회 | 게시글수정(1) |
|:------------:|:------------:|:------------:|:------------:|
| <img src="https://github.com/user-attachments/assets/f0fe413b-85b4-44e1-8cca-e60feb606f34" width="400px;" alt="게시글작성(1)"/> | <img src="https://github.com/user-attachments/assets/be3f6650-e1f1-4cac-a3de-6be9c9d90b3c" width="400px;" alt="게시글작성(2)"/> | <img src="https://github.com/user-attachments/assets/8b745f5d-738a-4bd6-bf95-f9adcc1023c5" width="400px;" alt="게시글조회"/> | <img src="https://github.com/user-attachments/assets/3477b2b0-3a0b-41dd-ac92-5d45833e7a66" width="400px;" alt="게시글수정(1)"/> |

| 게시글수정(2) | 게시글삭제(1) | 게시글삭제(2) | 댓글작성(1) |
|:------------:|:------------:|:------------:|:------------:|
| <img src="https://github.com/user-attachments/assets/93e0f398-1b59-4f08-8342-63f266588c50" width="400px;" alt="게시글수정(2)"/> | <img src="https://github.com/user-attachments/assets/9e0d24cf-df68-498e-9146-4e840bee15af" width="400px;" alt="게시글삭제(1)"/> | <img src="https://github.com/user-attachments/assets/6bd4db50-f500-4872-90d4-16d57dca0c6d" width="400px;" alt="게시글삭제(2)"/> | <img src="https://github.com/user-attachments/assets/f529d310-6860-409c-b0f9-3b32d0ba1460" width="400px;" alt="댓글작성(1)"/> |

| 댓글작성(2) | 댓글삭제(1) | 댓글삭제(2) |   |
|:-----------:|:------------:|:------------:|:--:|
| <img src="https://github.com/user-attachments/assets/6926223a-9bde-4c7e-972f-ed6cede79143" width="400px;" alt="댓글작성(2)"/> | <img src="https://github.com/user-attachments/assets/a761adc9-2988-4103-ba85-312ed914581a" width="400px;" alt="댓글삭제(1)"/> | <img src="https://github.com/user-attachments/assets/920177f1-7b5f-4123-bdeb-ce7247733eb5" width="400px;" alt="댓글삭제(2)"/> | | 

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
  팀원으로서의 경험
  프로젝트 진행 중 팀장과 적극적으로 소통하며 기능 개발에 기여할 수 있었습니다.
  협업 도구와 규칙을 따르며 효율적으로 작업을 분배하고 조율했습니다.
  이를 통해 팀워크의 중요성을 깊이 체감할 수 있었습니다.

  게시판/댓글 기능
  게시글 CRUD와 댓글 CRUD 기능을 구현하면서 데이터의 흐름을 명확히 이해하게 되었습니다.
  작성자만 수정/삭제할 수 있도록 권한 관리를 적용한 것은 요구사항에 대해서 깊게 생각해본 경험으로 남아서 유익했습니다.
  사용자 경험을 고려한 기능 개발의 중요성을 다시 한 번 느꼈습니다.

  Git 경험
  Git을 사용하여 버전 관리를 진행하며 협업 시 충돌 해결과 브랜치 전략의 필요성을 배웠습니다.
  다양한 이슈를 해결하는 과정에서 Git의 협업에서의 유용한 기능을 경험했습니다.
  코드 리뷰와 피드백을 통해 개선점을 찾고 발전할 수 있었습니다.
   
  ```
 
