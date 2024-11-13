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
    <h1>전체 게시물 조회 페이지 입니다.</h1>
    <hr>
    <%@ include file="sub/header.jsp" %>
    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${list.bno}</td>
                    <td>${list.title}</td>
                    <td>${list.content}</td>
                    <td>${list.writer}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>