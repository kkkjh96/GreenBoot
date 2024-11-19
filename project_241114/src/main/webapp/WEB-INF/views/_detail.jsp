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
    <h1>게시글</h1>
    <%@ include file="common/header.jsp" %>
    <div>
        제목 : ${dto.title}
    </div>
    <div>
        작성자 : ${dto.writer}
    </div>
    <div>
        작성일 : ${dto.regdate}
    </div>
    <div>
        내용 : ${dto.content}
    </div>
    <c:if test="${sessionScope.userid == dto.writer}">
        <p><a href="modi?bno=${dto.bno}">수정하기</a></p>
        <p><a href="del?bno=${dto.bno}">삭제하기</a></p>
    </c:if>
    <hr>
    <c:if test="${not empty sessionScope.userid}">
        <div>
            <form name="comment" id="comment">
                <input type="hidden" name="bno" value="${dto.bno}">
                <input type="hidden" name="writer" value="${sessionScope.userid}">
                <p>
                    댓글 : <input type="text" id="content" name="content">
                </p>
                <p>
                    <input type="button" value="작성" onclick="commentInsert()">
                </p>
            </form>
        </div>
        <div id="demo1"></div>
        <hr>
    </c:if>
    <div id="demo"></div>
    <script>

        const demo = document.querySelector("#demo");
        const demo1 = document.querySelector("#demo1");
        const sid = "${sessionScope.userid}";
        console.log(sid);

        function commentInsert() {
            const formData = new FormData(document.comment);
            const params = new URLSearchParams(formData);
            console.log(params.toString());

            const xhr = new XMLHttpRequest();
            xhr.onload = function() {
                let response = JSON.parse(xhr.responseText); // 서버 응답을 JSON으로 파싱
                let html = '';
                html += response.content + " (writer: " + response.writer + ")<br/>";
                // if(sid == response.writer){
                //     html += '<input type="button" value="수정" onclick="commentUpdate()">&nbsp';
                //     html += '<input type="button" value="삭제" onclick="commentDelete()">';
                // }
                // demo.innerHTML += html;
                if(response != '') {
                    alert("등록되었습니다.");
                    window.location.reload(); // 페이지 새로고침
                }
            }

            xhr.open("POST", "commentInsert");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params.toString());
        }
        let num;
        function commentList() {
            var bno = '${dto.bno}';
            var url = "commentList?bno=" + bno
            console.log(bno);
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                let arr = JSON.parse(xhttp.responseText); // 서버 응답을 JSON 배열로 파싱
                console.log(arr);
                let html1 = '';
                if (arr != null) {
                    arr.forEach(function(list){
                        num = list.cno;
                        html1 += "<p>";
                        html1 += list.content + " (writer: " + list.writer + ")&nbsp";
                        html1 += "<input type='hidden' name='cno' value='"+num+"'>";
                        if(sid == list.writer){
                            html1 += '<input type="button" value="수정" onclick="commentUpdate('+num+')">&nbsp';
                            html1 += '<input type="button" value="삭제" onclick="commentDelete('+num+')">';
                        }
                        html1 += "</p>";
                        demo.innerHTML = html1; // 댓글 목록을 한 번에 추가
                    });
                }
            }

            xhttp.open("GET", url, true);
            xhttp.send();
        }
        function commentUpdate(num){
            let html2 = '<hr> <form name="comment1" id="comment" method="post">'
                + '<input type="hidden" name="bno" value="${dto.bno}">'
                + '<input type="hidden" name="cno" value="'+num+'">'
                + '<input type="hidden" name="writer" value="${sessionScope.userid}">'
                + '<p>'
                + ' 댓글 : <input type="text" id="content1" name="content">'
                + '</p>'
                + '<p>'
                + '<input type="button" value="수정" on click="commentModi()">'
                + '</p>'
                + '</form>';
            demo1.innerHTML = html2;
        }

        function commentModi() {
            const formDataM = new FormData(document.comment1);
            const paramsM = new URLSearchParams(formDataM);
            console.log(paramsM.toString());

            const xhr1 = new XMLHttpRequest();
            xhr1.onload = function() {
                console.log(xhr1.responseText);
                let response1 = JSON.parse(xhr1.responseText); // 서버 응답을 JSON으로 파싱

                let html3 = '';
                html3 += response1.content + " (writer: " + response1.writer + ")<br/>";
                // if(sid == response1.writer){
                //     html3 += '<input type="button" value="수정" onclick="commentUpdate()">&nbsp';
                //     html3 += '<input type="button" value="삭제" onclick="commentDelete()">';
                // }
                // demo.innerHTML += html3;
                if(response1 != '') {
                    alert("수정되었습니다.");
                    window.location.reload(); // 페이지 새로고침
                }
            }

            xhr1.open("POST", "commentUpdate");
            xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr1.send(paramsM.toString());
        }
        let response2;
        function commentDelete(num) {
            const xhr2 = new XMLHttpRequest();
            xhr2.onload = function() {
                //console.log(xhr2.responseText);
                response2 = xhr2.responseText; // 서버 응답을 JSON으로 파싱
                console.log(response2);
                if(response2 != '') {
                    alert(response2);
                    window.location.reload(); // 페이지 새로고침
                }
            }
            
            xhr2.open("GET", "commentDelete?cno=" + num);
            xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr2.send();
        }

        // 페이지 로드 시 commentList 호출
        window.onload = commentList; // 함수 참조로 변경
    </script>
</body>
</html>