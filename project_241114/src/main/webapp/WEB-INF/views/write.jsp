<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>글쓰기 페이지 입니다.</h1>
    <%@ include file="common/header.jsp" %>
    <form action="insertBoard" id="frm2" method="post">
        <p>제목 : <input type="text" name="title" id="title"></p>
        <p>내용 : <textarea name="content" id="content"></textarea></p>
        <input type="hidden" name="writer" value="${sessionScope.userid}">
        <p><input type="submit" value="등록" id="btn_sub2"></p>
    </form>
    <script>
        let title = document.querySelector("#title");
        let content = document.querySelector("#content");
        let btn = document.querySelector("#btn_sub2");

        btn.addEventListener("click", function(e){
            e.preventDefault();
            if(title.value == ''){
                alert("제목 입력해 주세요.");
                title.focus();
            } else if(content.value == ''){
                alret("내용을 입력해 주세요.");
                content.focus();
            } else {
                document.getElementById("frm2").submit();
            }
        });

    </script>
    <%@ include file="common/footer.jsp" %>
</body>
</html>