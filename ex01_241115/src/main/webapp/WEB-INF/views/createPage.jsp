<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    createPage.jsp
    <br><br>
    <%
        String conPath = request.getContextPath();
    %>

    <form action="<%=conPath%>/create">
        작성자 : <input type="text" name="writer" value="${dto.writer}"><br><br>
        내용 :  <input type="text" name="content" value="${dto.content}"><br><br>
        <input type="submit" value="전송">
    </form>
</body>
</html>