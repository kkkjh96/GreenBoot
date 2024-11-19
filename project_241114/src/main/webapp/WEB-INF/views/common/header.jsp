<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<style>
    /* 네비게이션 바 스타일 */
    .navbar {
        padding: 15px;
        background-color: #f8f9fa;
        border-bottom: 1px solid #ddd;
        display: flex; /* 수평으로 배치 */
        justify-content: space-between; /* 양쪽 끝으로 배치 */
        align-items: center; /* 세로 정렬 중앙 */
    }

    /* 네비게이션 항목들을 가로로 나열하고 간격 추가 */
    .navbar p {
        margin: 0;
        padding: 0 15px; /* 항목 간의 간격 */
    }

    .navbar a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
        padding: 5px 10px;
        border-radius: 5px;
        background-color: #e0e0e0;
        transition: background-color 0.3s ease;
    }

    .navbar a:hover {
        background-color: #007bff;
        color: white;
    }

    .msg {
        color: #ff6347;
        font-size: 14px;
    }

    .user-section {
        display: flex;
        align-items: center;
    }
</style>
</head>
<body>
    <!-- _header.jsp -->
    <div class="navbar">
        <!-- 왼쪽 부분: 메인으로 링크 -->
        <p><a href="/" class="btn">메인으로</a></p>

        <!-- 오른쪽 부분: 로그인/회원가입/로그아웃 및 환영 메시지 -->
        <div class="user-section">
            <!-- 로그인 상태일 경우 -->
            <c:if test="${not empty sessionScope.userid}">
                <p>환영합니다, <strong>${sessionScope.userid}</strong>님!</p>
                <p><a href="logout" class="btn">로그아웃</a></p>
                <p><a href="mypage?id=${sessionScope.userid}" class="btn">마이페이지</a></p>
            </c:if>
            
            <!-- 비로그인 상태일 경우 -->
            <c:if test="${empty sessionScope.userid}">
                <p><a href="signup" class="btn">회원가입</a></p>
                <p><a href="sign" class="btn">로그인</a></p>
                <p class="msg">${msg}</p>
            </c:if>
        </div>
    </div>
</body>
</html>
