<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>게시글 조회 페이지 입니다.</h1>
    <hr>
    <%@ include file="sub/header.jsp" %>
    <p>삭제하실 게시글 번호를 입력해 주세요.</p>
    <form action="delete">
        <p><input type="text" name="bno"></p>
        <p><input type="submit" value="삭제하기"></p>
    </form>
</body>
</html>