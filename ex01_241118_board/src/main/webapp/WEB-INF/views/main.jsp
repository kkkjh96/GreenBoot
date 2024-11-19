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
    <h1>Main Page</h1>
    <hr>
    <ul>
        <li><a href="/board/registForm">게시글 등록하기</a></li>
        <li><a href="/board/list">게시글 목록보기</a></li>
        <li><a href="/board/list2/1">게시글 목록보기(페이지네이션 적용)</a></li>
    </ul>
</body>
</html>