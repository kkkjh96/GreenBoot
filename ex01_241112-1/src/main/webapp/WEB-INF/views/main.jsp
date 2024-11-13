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
    <p><a href="list">조회하기</a></p>
    <hr>
    <p>1_1. 등록하기(POST - JSON)</p>
    <form action="frm1">
        <input type="text" name="id" id="id" placeholder="Input id..."><br><br>
        <input type="text" name="pw" id="pw" placeholder="Input pw..."><br><br>
        <input type="text" name="name" id="name" placeholder="Input name..."><br><br>
        <input type="button" value="전송" onclick="regForm1()">
    </form>
    <div id="result1">----</div>

    <script>
        function regForm1(){
            
            const xhr = new XMLHttpRequest();

            xhr.onload = function(){
                //서버가 응답한 데이터를 받는 것은 xhr.responseText 다.
                xhr.responseText;
            }

            xhr.open("POST", "어디로 보낼까?");
        }
    </script>

    <p>1_2. 등록하기(POST - JSON)</p>
    <form action="frm2">
        <input type="text" name="id" id="id2" placeholder="Input id..."><br><br>
        <input type="text" name="pw" id="pw2" placeholder="Input pw..."><br><br>
        <input type="text" name="name" id="name2" placeholder="Input name..."><br><br>
        <input type="button" value="전송" onclick="regForm2()">
    </form>
    <div id="result2">----</div>
</body>
</html>