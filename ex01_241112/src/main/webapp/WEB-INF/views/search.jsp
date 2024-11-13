<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>검색 페이지 입니다.</h1>
    <hr>
    <form action="getMember">
        <p>ID : <input type="text" name="id" placeholder="검색할 아이디를 입력해 주세요"></p>
        <p>PW : <input type="text" name="pw"></p>
        <p><input type="submit" value="검색하기"></p>
    </form>
    <a href="/">메인으로</a>
</body>
</html>