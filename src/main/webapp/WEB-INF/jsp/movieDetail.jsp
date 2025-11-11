<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie detail - CineMan</title>
</head>
<body>
<h1>${movie.title}</h1>
<p><strong>Director:</strong> ${movie.director}</p>
<p><strong>Duration:</strong> ${movie.durationMinutes} phút</p>
<p>${movie.description}</p>
<p><a href="/movies/search">Quay lại</a></p>
</body>
</html>
