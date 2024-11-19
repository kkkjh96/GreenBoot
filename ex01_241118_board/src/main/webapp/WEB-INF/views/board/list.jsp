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
    <hr>
    <table border="1">
        <thead>
            <tr>
                <th>bno</th>
                <th>title</th>
                <th>writer</th>
                <th>filename</th>
                <th>regdate</th>
                <th>modifydate</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${blist}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><a href="/board/detail/${list.bno}">${list.title}</a></td>
                <td>${list.writer}</td>
                <td><img src="/images/${list.filename}" width="100px"></td>
                <td>${list.regdate}</td>
                <td>${list.modifydate}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>