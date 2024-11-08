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
    1번 : ${name} <br><br>
    2번 : ${name2}<br><br>
    1번 멤버 ID : ${member1.id} <br><br>
    1번 멤버 PW : ${member1.pw} <br><br>
    1번 멤버 이름 : ${member1.name} <br><br>
    2번 멤버 ID : ${member2.id} <br><br>
    2번 멤버 PW : ${member2.pw} <br><br>
    2번 멤버 이름 : ${member2.name} <br><br>
    <c:forEach var="list" items="${member}" varStatus="status">
        ${status.index}번 멤버 ID : ${list.id} <br><br>
        ${status.index}번 멤버 PW : ${list.pw} <br><br>
        ${status.index}번 멤버 이름 : ${list.name} <br><br>
    </c:forEach>
</body>
</html>