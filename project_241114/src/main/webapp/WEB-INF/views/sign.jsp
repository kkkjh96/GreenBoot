<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인 페이지 입니다.</h1>
    <%@ include file="common/header.jsp" %>
    <form action="login" method="post" id="frm1">
        <p>ID : <input type="text" name="id" id="id1"></p>
        <p>PW : <input type="password" name="pw" id="pw1"></p>
        <p><input type="submit" value="로그인" id="btn_sub1"></p>
    </form>

    <script>
        let id = document.querySelector("#id1");
        let pw = document.querySelector("#pw1");
        let btn = document.querySelector("#btn_sub1");

        btn.addEventListener("click", function(e){
            e.preventDefault();
            if(id.value == ''){
                alert("ID를 입력해 주세요.");
                id.focus();
            } else if(pw.value == ''){
                alret("PW를 입력해 주세요.");
                pw.focus();
            } else {
                document.getElementById("frm1").submit();
            }
        });
    </script>
    <%@ include file="common/footer.jsp" %>
</body>
</html>