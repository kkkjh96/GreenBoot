<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
    <link rel="stylesheet" href="style/detail.css"> <!-- styles.css 연결 -->
</head>
<body>
    <%@ include file="common/header.jsp" %>

    <div class="container">
        <h1>게시글</h1>
        
        <!-- 게시글 정보 -->
        <div class="post">
            <div><strong>제목:</strong> ${dto.title}</div>
            <div><strong>작성자:</strong> ${dto.writer}</div>
            <div><strong>작성일:</strong> ${dto.regdate}</div>
            <div><strong>내용:</strong> ${dto.content}</div>
        </div>
        
        <!-- 수정 및 삭제 버튼 -->
        <c:if test="${sessionScope.userid == dto.writer}">
            <div class="actions">
                <p><a href="modi?bno=${dto.bno}" class="btn btn-primary">수정하기</a></p>
                <p><a href="del?bno=${dto.bno}" class="btn btn-danger">삭제하기</a></p>
            </div>
        </c:if>

        <hr>

        <!-- 댓글 작성 폼 -->
        <c:if test="${not empty sessionScope.userid}">
            <div class="comment-form">
                <form name="comment" id="comment">
                    <input type="hidden" name="bno" value="${dto.bno}">
                    <input type="hidden" name="writer" value="${sessionScope.userid}">
                    <p>
                        <label for="content">댓글:</label>
                        <input type="text" id="content" name="content" placeholder="댓글을 입력하세요" required>
                    </p>
                    <p>
                        <input type="button" value="작성" onclick="commentInsert()" class="btn btn-primary">
                    </p>
                </form>
            </div>
            <div id="demo1"></div>
            <hr>
        </c:if>

        <!-- 댓글 목록 -->
        <div id="demo"></div>
    </div>

    <script>
        const demo = document.querySelector("#demo");
        const demo1 = document.querySelector("#demo1");
        const sid = "${sessionScope.userid}";

        // 댓글 등록
        function commentInsert() {
            const formData = new FormData(document.comment);
            const params = new URLSearchParams(formData);

            const xhr = new XMLHttpRequest();
            xhr.onload = function() {
                let response = JSON.parse(xhr.responseText); 
                if(response != '') {
                    alert("등록되었습니다.");
                    window.location.reload(); // 페이지 새로고침
                }
            }

            xhr.open("POST", "commentInsert");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params.toString());
        }

        // 댓글 목록 조회
        function commentList() {
            var bno = '${dto.bno}';
            var url = "commentList?bno=" + bno;

            const xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                let arr = JSON.parse(xhttp.responseText);
                let html1 = '';
                if (arr != null) {
                    arr.forEach(function(list){
                        let num = list.cno;
                        html1 += "<div class='comment-item'>";
                        html1 += "<p>" + list.content + " (writer: " + list.writer + ") ["+ list.regdate + "]</p>";
                        html1 += "<input type='hidden' name='cno' value='"+num+"'>";
                        if(sid == list.writer){
                            html1 += '<input type="button" value="수정" onclick="commentUpdate('+num+')" class="btn btn-warning">&nbsp';
                            html1 += '<input type="button" value="삭제" onclick="commentDelete('+num+')" class="btn btn-danger">';
                        }
                        html1 += "</div>";
                    });
                    demo.innerHTML = html1;
                }
            }

            xhttp.open("GET", url, true);
            xhttp.send();
        }

        // 댓글 수정
        function commentUpdate(num){
            let html2 = '<form name="comment1" id="comment1" method="post">'
                + '<input type="hidden" name="bno" value="${dto.bno}">'
                + '<input type="hidden" name="cno" value="'+num+'">'
                + '<input type="hidden" name="writer" value="${sessionScope.userid}">'
                + '<p>'
                + ' 댓글: <input type="text" id="content1" name="content" placeholder="수정할 댓글" required>'
                + '</p>'
                + '<p>'
                + '<input type="button" value="수정" onclick="commentModi()" class="btn btn-primary">'
                + '</p>'
                + '</form>';
            demo1.innerHTML = html2;
        }

        // 댓글 수정 처리
        function commentModi() {
            const formDataM = new FormData(document.comment1);
            const paramsM = new URLSearchParams(formDataM);

            const xhr1 = new XMLHttpRequest();
            xhr1.onload = function() {
                let response1 = JSON.parse(xhr1.responseText);
                if(response1 != '') {
                    alert("수정되었습니다.");
                    window.location.reload(); // 페이지 새로고침
                }
            }

            xhr1.open("POST", "commentUpdate");
            xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr1.send(paramsM.toString());
        }

        // 댓글 삭제
        function commentDelete(num) {
            const xhr2 = new XMLHttpRequest();
            xhr2.onload = function() {
                let response2 = xhr2.responseText;
                if(response2 != '') {
                    alert(response2);
                    window.location.reload(); // 페이지 새로고침
                }
            }
            xhr2.open("GET", "commentDelete?cno=" + num);
            xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr2.send();
        }

        // 페이지 로드 시 댓글 목록 호출
        window.onload = commentList;
    </script>
    <%@ include file="common/footer.jsp" %>
</body>
</html>
