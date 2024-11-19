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
    <h1>Green Board!!</h1>
    <%@ include file="common/header.jsp" %>
    <h2>Green Board</h2>
    <div id="board">
        <table border="1">
            <thead>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </thead>
            <tbody>
            <c:forEach var="list" items="${lists}" varStatus="status">
                <tr>
                    <td>${startNumber}</td>
                    <td><a href="detail?bno=${list.bno}">${list.title}</a></td>
                    <td>${list.writer}</td>
                    <td>${list.regdate}</td>
                </tr>
                <!-- 번호를 1씩 감소 -->
                <c:set var="startNumber" value="${startNumber - 1}" /> 
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${not empty sessionScope.userid}">
            <p><a href="write" class="btn">글쓰기</a></p>
        </c:if>
        <div>
            <c:if test="${currentPage > 1}">
                <a href="/page?page=${currentPage - 1}">이전</a>
            </c:if>
            
            <span>Page ${currentPage} / ${totalPages}</span>
    
            <c:if test="${currentPage < totalPages}">
                <a href="/page?page=${currentPage + 1}">다음</a>
            </c:if>
        </div>
    </div>
    <%@ include file="common/footer.jsp" %>
</body>
</html>