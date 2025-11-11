<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - CineMan</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="/login" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit">Login</button>
</form>
<p><a href="/register">Đăng ký thành viên</a></p>
</body>
</html>
