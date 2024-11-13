<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원 등록 페이지 입니다.</h1>
    <hr>
    <form action="updateForm">
        <p>ID : <input type="text" name="oldid" placeholder="수정 할 ID 입력"></p>
        <hr>
        <p>ID : <input type="text" name="id"></p>
        <p>pw : <input type="text" name="pw"></p>
        <p>NAME : <input type="text" name="name"></p>
        <p><input type="submit" value="수정하기"></p>
    </form>
    <a href="/">메인으로</a>
</body>
</html>