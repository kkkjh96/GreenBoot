<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Detail Page</h1>
    <hr>
    <div>
        <form action="/board/modify" method="post" enctype="multipart/form-data">
            <table border="1">
                <tbody>
                    <tr>
                        <th>게시글 번호 :</th>
                        <td><input type="text" name="bno" value="${board.bno}" readonly></td>
                    </tr>
                    <tr>
                        <th>제목 :</th>
                        <td><input type="text" name="title" value="${board.title}"></td>
                    </tr>
                    <tr>
                        <th>내용 :</th>
                        <td><textarea name="content" cols="50" rows="10">${board.content}</textarea></td>
                    </tr>
                    <tr>
                        <th>작성자 :</th>
                        <td><input type="text" name="writer" value="${board.writer}" readonly></td>
                    </tr>
                    <tr>
                        <th>등록일자 :</th>
                        <td><input type="text" name="regdate" value="${board.regdate}" readonly></td>
                    </tr>
                    <tr>
                        <th>수정일자 :</th>
                        <td><input type="text" name="modifydate" value="${board.modifydate}"  readonly></td>
                    </tr>
                    <tr>
                        <th>파일명 :</th>
                        <td><input type="text" name="filename" value="${board.filename}" readonly></td>
                    </tr>
                    <tr>
                        <th>file :</th>
                        <td><input type="file" name="file"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="수정">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <img src="/images/${board.filename}" alt="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="/board/delete/${board.bno}">삭제</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>