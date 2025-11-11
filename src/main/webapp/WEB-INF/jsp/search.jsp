<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Movies - CineMan</title>
</head>
<body>
<h1>Tìm phim</h1>
<form action="/movies/search" method="get">
    <input type="text" name="keyword" value="${keyword}">
    <button type="submit">Tìm</button>
</form>

<c:if test="${not empty movies}">
    <h2>Kết quả</h2>
    <ul>
        <c:forEach var="m" items="${movies}">
            <li>
                <a href="/movies/detail?id=${m.id}">${m.title}</a>
            </li>
        </c:forEach>
    </ul>
<c:else>
    <p>Không có phim nào.</p>
</c:if>

</body>
</html>
