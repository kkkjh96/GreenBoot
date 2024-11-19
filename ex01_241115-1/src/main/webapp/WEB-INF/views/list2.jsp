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
    <h2>List3 Page(${param.option}으로 검색)</h2>
    <hr>
    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>ID</th>
                <th>PW</th>
                <th>NAME</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><a href="/modifyForm?id=${list.id}">${list.id}</a></td>
                    <td>${list.pw}</td>
                    <td>${list.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/">메인으로</a>
</body>
</html>