<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Main Page</h1>
    <hr>
    <h3>폼 파라미터 전송하기 3</h3>
    <form action="test5" method="post">
        NAME : <input type="text" name="username"><br><br>
        ID : <input type="text" name="id"><br><br>
        PW : <input type="text" name="pw"><br><br>
        E-mail : <input type="text" name="email"><br><br>
        취미
        <input type="checkbox" name="hobbies" value="달리기">달리기
        <input type="checkbox" name="hobbies" value="독서">독서
        <input type="checkbox" name="hobbies" value="코딩">코딩
        <input type="submit" value="전송"><br><br>
    </form>
</body>
</html>