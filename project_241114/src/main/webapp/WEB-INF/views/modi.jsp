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
    <h1>게시글 수정</h1>
    <%@ include file="common/header.jsp" %>
    <form action="update" method="post">
        <p>제목 : <input type="text" name="title" value="${dto.title}"></p>
        <p>내용 : <textarea name="content" value="${dto.content}"></textarea></p>
        <input type="hidden" name="bno" value="${dto.bno}">
        <p><input type="submit" value="등록"></p>
    </form>
    <%@ include file="common/footer.jsp" %>
</body>
</html>