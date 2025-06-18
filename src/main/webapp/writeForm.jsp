<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기 폼</title>
</head>
<body>
    <h2>글쓰기</h2>
    <form action="guestbook?action=write" method="post">
        <p>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
        </p>
        <p>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>
        </p>
        <p>
            <label for="content">내용:</label><br>
            <textarea id="content" name="content" rows="5" cols="40" required></textarea>
        </p>
        <p>
            <input type="submit" value="등록">
            <input type="reset" value="취소">
        </p>
    </form>
</body>
</html>