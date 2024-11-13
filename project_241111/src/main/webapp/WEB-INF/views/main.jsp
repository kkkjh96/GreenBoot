<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <h1>메인 페이지 입니다.</h1>
    <hr>
    <%@ include file="sub/header.jsp" %>
    <p><a href="write">글쓰기</a></p>
    <p><a href="list">전체조회</a></p>
    <p><a href="searchBoard">검색</a></p>
    <p><a href="selDel">삭제하기</a></p>
</body>
</html>