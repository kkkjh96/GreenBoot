<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>글 등록 페이지 입니다.</h1>
    <hr>
    <%@ include file="sub/header.jsp" %>
    <form action="regBoard" method="post">
        <p>
            제목 : <input type="text" name="title">
        </p>
        <p>
            작성자 : <input type="text" name="writer">
        </p>
        <p>
            내용 : <textarea name="content"></textarea>
        </p>
        <input type="submit" value="등록하기">
    </form>
</body>
</html>