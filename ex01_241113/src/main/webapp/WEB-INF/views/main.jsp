<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <h1>Main Page</h1>
    <hr>
    <p>회원 등록</p>
    <form action="regist" method="post" name="regist">
        <p>ID : <input type="text" name="id"></p>
        <p>PW : <input type="text" name="pw"></p>
        <p>NAME : <input type="text" name="name"></p>
        <p><input type="button" value="등록하기" onclick="regForm()"></p>
    </form>
    <div id="result1">----</div>

    <script>
        const result1 = document.getElementById("result1");
        function regForm(){
            const form = document.regist;
            const formData = new FormData(form);
            const params = new URLSearchParams(formData);
            console.log(params.toString());

            const xhr = new XMLHttpRequest();

            xhr.onload = function(){
                result1.innerHTML = xhr.responseText;
            }
            xhr.open("POST", "regist");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params.toString());
        }
    </script>

    <hr>
    <p>회원 전체 조회</p>
    <p><button onclick="list()">조회하기</button></p>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>PW</th>
                <th>NAME</th>
            </tr>
        </thead>
        <tbody id="result2"></tbody>
    </table>

    <script>
        const result2 = document.getElementById("result2");

        function list(){
            const xhr = new XMLHttpRequest();
            xhr.onload = function(){
                const lists = xhr.responseText;
                const data = JSON.parse(lists);
                console.log(data);
                let tr = '';
                data.forEach(function(list){
                    tr += "<tr>";
                    tr += "<td>" + list.id + "</td>";
                    tr += "<td>" + list.pw + "</td>";
                    tr += "<td>" + list.name + "</td>";
                    tr += "</tr>";
                    result2.innerHTML = tr;
                });
            }
            xhr.open("GET", "list");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send();
        }
    </script>

    <hr>
    <p>한 명 검색</p>
    <p>ID : <input type="text" name="id" id="searchId"></p>
    <p><button onclick="search()">검색</button></p>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>PW</th>
                <th>NAME</th>
            </tr>
        </thead>
        <tbody id="result3"></tbody>
    </table>

    <script>
        const result3 = document.getElementById("result3");
        function search(){
            const xhr = new XMLHttpRequest;
            let id1 = document.getElementById("searchId").value;
            const id = new URLSearchParams(id1);
            console.log(id);
            console.log(id1);
            xhr.onload = function(){
                const lists = xhr.responseText;
                const data = JSON.parse(lists);
                let tr = '';
                tr += "<tr>";
                tr += "<td>" + data.id + "</td>";
                tr += "<td>" + data.pw + "</td>";
                tr += "<td>" + data.name + "</td>";
                tr += "</tr>";
                result3.innerHTML = tr;
            }
            xhr.open("POST", "search/" + id1);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(id1);
        }
        
    </script>

    <hr>
    <p>수정하기</p>
    <p>ID : <input type="text" name="id" id="modiID"></p>
    <p><button onclick="modi()">검색</button></p>
    <div id="result4">----</div>
    <div id="result5">----</div>

    <script>
        const result4 = document.getElementById("result4");
        const result5 = document.getElementById("result5");
        function modi(){
            const xhr = new XMLHttpRequest;
            let id = document.getElementById("modiID").value;

            xhr.onload = function(){
                const lists = xhr.responseText;
                const data = JSON.parse(lists);
                let form = '';
                form += '<form action="regist" method="post" name="regist2">';
                form += '<p>ID : <input type="text" name="id" value=' + data.id + ' readonly></p>';
                form += '<p>PW : <input type="text" name="pw" value=' + data.pw + '></p>';
                form += '<p>NAME : <input type="text" name="name" value=' + data.name + '></p>';
                form += '<p><input type="button" value="수정하기" onclick="modiForm()"></p>';
                form += '</form>';
                result4.innerHTML = form;
            }
            xhr.open("POST", "modi");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("id=" + id);
        }

        function modiForm(){
            const form = document.regist2;
            const formData = new FormData(form);
            const params = new URLSearchParams(formData);
            console.log(params.toString());

            const xhr = new XMLHttpRequest();

            xhr.onload = function(){
                result5.innerHTML = xhr.responseText;
            }
            xhr.open("POST", "update");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params.toString());
        }

    </script>

    <hr>
</body>
</html>