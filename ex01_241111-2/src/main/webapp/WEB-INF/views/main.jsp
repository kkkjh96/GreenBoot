<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Main Page</h1>
    <hr>
    <p>전체 조회</p>
    <a href="list">목록 보기</a>
    <hr>
    <p>등록</p>
    <form action="regUser">
        ID : <input type="text" name="id" placeholder="등록하실 ID를 입력해 주세요."><br><br>
        NAME : <input type="text" name="name" placeholder="등록하실 이름을 입력해 주세요."><br><br>
        <input type="submit" value="등록하기">
    </form>
    <hr>
    <p>삭제</p>
    <form action="delUser">
        ID : <input type="text" name="id" placeholder="삭제하실 ID를 입력해 주세요."><br><br>
        <input type="submit" value="삭제하기">
    </form>
    <hr>
    <p>수정</p>
    <form action="modiUser">
        <input type="text" name="oldid" placeholder="변경을 원하시는 ID를 입력해 주세요."><br><br>
        <input type="text" name="newid" placeholder="변경하실 ID를 입력해 주세요."><br><br>
        <input type="submit" value="변경하기">
    </form>
    <hr>
    <p>한 명 조회</p>
    <form action="getUser">
        ID : <input type="text" name="id" placeholder="검색하실 ID를 입력해 주세요."><br><br>
        <input type="submit" value="검색하기">
    </form>
</body>
</html>