<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 관리 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- 스타일링 -->
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    header {
        background-color: #4CAF50;
        color: white;
        padding: 20px;
        text-align: center;
    }
    h1 {
        margin: 0;
        font-size: 2.5em;
    }
    hr {
        border: 1px solid #ddd;
    }
    .container {
        width: 80%;
        margin: 20px auto;
        background-color: white;
        padding: 20px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    .form-section, .table-section {
        margin-bottom: 30px;
    }
    .form-section p {
        margin: 10px 0;
        font-size: 1.1em;
    }
    .form-section input[type="text"] {
        width: 200px;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    .form-section input[type="button"], .form-section button {
        padding: 10px 15px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .form-section input[type="button"]:hover, .form-section button:hover {
        background-color: #45a049;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    td {
        background-color: #f9f9f9;
    }
    #result1, #result2, #result3, #result4, #result5 {
        margin-top: 15px;
        font-size: 1.2em;
    }
    .alert {
        color: red;
        font-weight: bold;
    }
</style>

</head>
<body>

<header>
    <h1>회원 관리 시스템</h1>
</header>

<div class="container">
    <div class="form-section">
        <h2>회원 등록</h2>
        <form action="regist" method="post" name="regist">
            <p>ID : <input type="text" name="id" required></p>
            <p>PW : <input type="text" name="pw" required></p>
            <p>NAME : <input type="text" name="name" required></p>
            <p><input type="button" value="등록하기" onclick="regForm()"></p>
        </form>
        <div id="result1"></div>
    </div>

    <div class="form-section">
        <h2>회원 전체 조회</h2>
        <p><button onclick="list()">조회하기</button></p>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>PW</th>
                    <th>NAME</th>
                </tr>
            </thead>
            <tbody id="result2"></tbody>
        </table>
    </div>

    <div class="form-section">
        <h2>한 명 검색</h2>
        <p>ID : <input type="text" name="id" id="searchId"></p>
        <p><button onclick="search()">검색</button></p>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>PW</th>
                    <th>NAME</th>
                </tr>
            </thead>
            <tbody id="result3"></tbody>
        </table>
    </div>

    <div class="form-section">
        <h2>수정하기</h2>
        <p>ID : <input type="text" name="id" id="modiID"></p>
        <p><button onclick="modi()">검색</button></p>
        <div id="result4"></div>
        <div id="result5"></div>
    </div>
</div>

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
            });
            result2.innerHTML = tr;
        }
        xhr.open("GET", "list");
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send();
    }

    const result3 = document.getElementById("result3");
    function search(){
        const xhr = new XMLHttpRequest();
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

    const result4 = document.getElementById("result4");
    const result5 = document.getElementById("result5");
    function modi(){
        const xhr = new XMLHttpRequest();
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

</body>
</html>