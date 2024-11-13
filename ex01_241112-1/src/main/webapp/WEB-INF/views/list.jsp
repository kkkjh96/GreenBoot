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
    <h1>조회 페이지 입니다.</h1>
    <hr>
    <table border="1">
        <thead>
            <tr>
                <th>NO</th>
                <th>ID</th>
                <th>PW</th>
                <th>NAME</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${list.id}</td>
                    <td>${list.pw}</td>
                    <td>${list.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>