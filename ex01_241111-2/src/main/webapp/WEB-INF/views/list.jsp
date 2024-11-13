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
    <h1>목록 페이지</h1>
    ${msg}
    <hr>
    <c:forEach var="list" items="${list}">
        <p>ID : ${list.id}</p>
        <p>NAME : ${list.name}</p>
        <hr>
    </c:forEach>
</body>
</html>