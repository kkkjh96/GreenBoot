<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Modify Form</h1>
    <hr>
    <form action="modify" method="post">
        id : <input type="text" name="id" value="${dto.id}" readonly><br><br>
        pw : <input type="text" name="pw" value="${dto.pw}"><br><br>
        name : <input type="text" name="name" value="${dto.name}"><br><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>