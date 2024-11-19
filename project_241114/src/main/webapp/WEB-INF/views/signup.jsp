<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원가입 페이지 입니다.</h1>
    <%@ include file="common/header.jsp" %>
    <form action="insert" method="post" id="frm">
        <p>ID : <input type="text" name="id" id="id"></p>
        <p>PW : <input type="text" name="pw" id="pw"></p>
        <p>이름 : <input type="text" name="name" id="name"></p>
        <p>주소 : <input type="text" name="addr" id="addr"></p>
        <p><input type="submit" value="회원가입" class="btn_sub"></p>
    </form>

    <script>
        let btn = document.querySelector(".btn_sub");
        let id = document.querySelector("#id");
        let pw = document.querySelector("#pw");
        let name = document.querySelector("#name");
        let addr = document.querySelector("#addr");

        btn.addEventListener("click", function(e){
            e.preventDefault();
            if(id.value == '') {
                alert("아이디를 입력해 주세요.");
                id.focus();
            } else if(pw.value == '') {
                alert("비밀번호를 입력해 주세요.");
                pw.focus();
            } else if(name.value == '') {
                alert("이름을 입력해 주세요.");
                name.focus();
            } else if(addr.value == '') {
                alert("주소를 입력해 주세요.");
                addr.focus();
            } else {
                document.getElementById("frm").submit();
            }
        });

    </script>
    <%@ include file="common/footer.jsp" %>
</body>
</html>