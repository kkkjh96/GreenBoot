<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <h1>p1.jsp 페이지 입니다.</h1>
    <a href="h1.html">h1으로 가기</a><br>
    <a href="p2">p2로 가기</a>
    ${m.id}
    ${m.pw}
    ${m.name}
</body>
</html>