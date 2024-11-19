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
    <h1>List2 Page</h1>
    <hr>
    <form action="/board/list2/${page.currentPageNum}" method="get">
        <label for="size">페이지당 게시글 수:</label>
        <select name="size" id="size">
        <!-- <select name="size" id="size" onchange="this.form.submit()"> -->
            <option value="5" ${size == 5 ? 'selected' : ''}>5</option>
            <option value="10" ${size == 10 ? 'selected' : ''}>10</option>
            <option value="15" ${size == 15 ? 'selected' : ''}>15</option>
        </select>
        <input type="hidden" name="page" value="${currentPage}" />
        <input type="submit" value="페이지 설정">
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>bno</th>
                <th>title</th>
                <th>writer</th>
                <th>filename</th>
                <th>regdate</th>
                <th>modifydate</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="countNum" value="${page.countNum}" />
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${countNum}</td>
                    <td><a href="/board/detail/${list.bno}">${list.title}</a></td>
                    <td>${list.writer}</td>
                    <td><img src="/images/${list.filename}" width="100px"></td>
                    <td>${list.regdate}</td>
                    <td>${list.modifydate}</td>
                </tr>
                <c:set var="countNum" value="${countNum - 1}" />
            </c:forEach>
            <tr>
                <td colspan="6">
                <c:if test="${page.currentPageNum > 1}">
                    <a href="/board/list2/1?size=${size}">[<<]</a>
                    &nbsp;&nbsp;
                    <a href="/board/list2/${page.currentPageNum - 1}?size=${size}">[이전]</a>
                    &nbsp;&nbsp;&nbsp;
                </c:if>
                <c:forEach var="pageNum" begin="1" end="${page.endPageNum}" step="1">
                    <c:choose>
                        <c:when test="${page.currentPageNum == pageNum}">
                            <strong><a href="/board/list2/${pageNum}?size=${size}">${pageNum}</a></strong>
                            &nbsp;&nbsp;&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="/board/list2/${pageNum}?size=${size}">${pageNum}</a> 
                            &nbsp;&nbsp;&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${page.currentPageNum < page.endPageNum}">
                    <a href="/board/list2/${page.currentPageNum + 1}?size=${size}">[다음]</a>
                    &nbsp;&nbsp;
                    <a href="/board/list2/${page.endPageNum}?size=${size}">[>>]</a>
                </c:if>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>