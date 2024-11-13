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
    <p>1_1. 등록하기(POST - FORM)</p>
    <form name="frm1">
        <input type="text" name="id" id="id" placeholder="Input id..."><br><br>
        <input type="text" name="pw" id="pw" placeholder="Input pw..."><br><br>
        <input type="text" name="name" id="name" placeholder="Input name..."><br><br>
        <input type="button" value="전송" onclick="regForm1()">
    </form>
    <div id="result1">----</div>

    <script>
        const result1 = document.getElementById("result1");
        /*
        function regForm1(){
            const form = document.frm1;
            const formData = new FormData(form);
            
            const xhr = new XMLHttpRequest();

            xhr.onload = function(){
                //서버가 응답한 데이터를 받는 것은 xhr.responseText 다.
                result1.innerHTML = xhr.responseText;
            }

            xhr.open("POST", "regist1");
            xhr.send(formData);

        }
        */

        function regForm1(){

            const formData = new FormData(document.frm1);
            const params = new URLSearchParams(formData);
            console.log(params.toString());

            const xhr = new XMLHttpRequest();

            xhr.onload = function(){
                result1.innerHTML = xhr.responseText;
            }
            xhr.open("POST", "regist1");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params.toString());
        }

    </script>

    <p>1_2. 등록하기(POST - JSON)</p>
    <form name="frm2">
        <input type="text" name="id" id="id2" placeholder="Input id..."><br><br>
        <input type="text" name="pw" id="pw2" placeholder="Input pw..."><br><br>
        <input type="text" name="name" id="name2" placeholder="Input name..."><br><br>
        <input type="button" value="전송" onclick="regForm2()">
    </form>
    <div id="result2">----</div>

    <script>

        const result2 = document.getElementById("result2");

        const id = document.getElementById("id2");
        const pw = document.getElementById("pw2");
        const name = document.getElementById("name2");

        function regForm2(){
            //폼 데이터를 json으로 변환하기
            const obj = {
                id : id.value,
                pw : pw.value,
                name : name.value
            }
            const jsonData = JSON.stringify(obj);
            console.log(jsonData);


            const xhr = new XMLHttpRequest();

            xhr.onload = function(){

                result2.innerHTML = xhr.responseText;

            }
            xhr.open("POST", "regist2");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(jsonData);
        }

    </script>
</body>
</html>