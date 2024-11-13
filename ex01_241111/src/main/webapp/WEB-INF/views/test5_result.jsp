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
    <h1>test5 결과 페이지</h1>
    <hr>
    NAME : ${m.username} <br><br>
    ID : ${m.id} <br><br>
    PW : ${m.pw} <br><br>
    E-mail : ${m.email} <br><br>
    AGE : ${age}세 <br><br>
    Hobbies : |
    <c:forEach var="hobby" items="${m.hobbies}">
    ${hobby} |
    </c:forEach>
</body>
</html>