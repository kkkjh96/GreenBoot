<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <h1>게시글 조회 페이지 입니다.</h1>
    <hr>
    <%@ include file="sub/header.jsp" %>
    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
            </tr>
        </thead>
        <tbody id="tb">
        </tbody>
    </table>
    <p>찾으실 게시글 번호를 입력해 주세요.</p>
    <p><input type="text" name="bno" id="bno"></p>
    <p><button type="button" onclick="search()">검색하기</p>
    <script>
        let bno = document.getElementById("bno");
        let tb = document.getElementById("tb");
        function search(){
            console.log(bno.value)
            $.ajax({
                url : "search",
                type : "GET",
                data : {"bno" : bno.value},
                success : function(response){
                    let td = '';
                    console.log(response);
                    console.log(response.title);
                    td += "<tr>";
                    td += "<td>" + response.bno + "</td>";
                    td += "<td>" + response.title + "</td>" ;
                    td += "<td>" + response.content + "</td>" ;
                    td += "<td>" + response.writer + "</td>" ;
                    td += "</tr>";
                    tb.innerHTML = td;
                    console.log(tb.innerHTML);
                }
            });

            // const xhr = new XMLHttpRequest();
            // xhr.open("GET", "/search?bno="+bno.value);

            // xhr.onload = function(){
            //     let res = JSON.parse(xhr.responseText);
            //     tr.innerHTML += `<td>${response.dto.bno}</td>` ;
            //     tr.innerHTML += `<td>${response.dto.title}</td>` ;
            //     tr.innerHTML += `<td>${response.dto.content}</td>` ;
            //     tr.innerHTML += `<td>${response.dto.writer}</td>` ;
            // }
            // xhr.send();
            
        }
    </script>
</body>
</html>