# 프로젝트형 코딩테스트
- https://github.com/yojulab/codingtest_springboots
## 환경 준비
- 대상 git repository branch : https://github.com/yojulab/codingtest_springboots/tree/codingtest_01
- 본인 github로 Clone : Fork 사용(화면 왼쪽 상단)
## Quest
### 1. setup to connect Database
- database name : yojulab
- usernames, password : 각각 root, *yojulab!
- DML, DDL queries : Folder /databases/*.sql
#### hint : src/main/resources/application.properties
#### 확인 방법 : http://localhost:8080/commonCode/
### 2. 페이지 라인 갯수 변경
- 페이지 표시 라인 갯수를 5개에서 4개로 변경
#### hint : src/main/java/com/test/codingtest_springboots/utils/Paginations.java
#### 확인 방법 : http://localhost:8080/commonCode/
### 3. 입력 화면 띄우기
- 리스트 화면에서 'Form with File' 버튼 클릭 시 에러 발생 수정 : 왼쪽 상단
#### hint : src/main/java/com/test/codingtest_springboots/controller/CommonCodeController.java
#### 확인 방법 : http://localhost:8080/commonCode/formMulti
### 4. 삭제 동작하게 만들기
- 리스트 화면에서 'Delete' 버튼 클릭 시 에러 발생 수정 : 라인마다 있는 버튼
#### hint 
- src/main/webapp/WEB-INF/views/commonCodes/list.jsp
- src/main/resources/sqlmapper/mysql/CommonCodeMapper.xml
#### 확인 방법 : http://localhost:8080/commonCode/delete/
