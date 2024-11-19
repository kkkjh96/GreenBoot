<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Regist Form Page</h1>
    <hr>
    <div>
        <form action="/board/regist" method="post" enctype="multipart/form-data">
            <table border="1">
                <tbody>
                    <tr>
                        <th>제목 :</th>
                        <td><input type="text" name="title"></td>
                    </tr>
                    <tr>
                        <th>내용 :</th>
                        <td><textarea name="content" cols="50" rows="10"></textarea></td>
                    </tr>
                    <tr>
                        <th>작성자 :</th>
                        <td><input type="text" name="writer"></td>
                    </tr>
                    <tr>
                        <th>file :</th>
                        <td><input type="file" name="file"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="등록">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>