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
    <h1>My Page 입니다.</h1>
    <%@ include file="common/header.jsp" %>
    <form action="memberModi" method="post" id="frm4">
        <p>ID : <input type="text" name="id" id="id" value="${dto.id}" readonly></p>
        <p>PW : <input type="text" name="pw" id="pw" value="${dto.pw}"></p>
        <p>이름 : <input type="text" name="name" id="name" value="${dto.name}"></p>
        <p>주소 : <input type="text" name="addr" id="addr" value="${dto.addr}"></p>
        <p><input type="submit" value="회원정보 수정" class="btn_sub"></p>
    </form>
    <%@ include file="common/footer.jsp" %>
</body>
</html>