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
    <h1>List Page</h1>
    <a href="selectForm">이름으로 검색하기</a><br><br>
    <form action="select2">
        <select name="option">
            <option value="id">아이디로 검색</option>
            <option value="pw">패스워드로 검색</option>
            <option value="name">이름으로 검색</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="조회">
    </form>
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
</body>
</html>