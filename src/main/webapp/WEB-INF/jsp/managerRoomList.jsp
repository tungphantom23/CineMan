<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manager - Rooms</title>
</head>
<body>
<h1>Rooms</h1>
<p><a href="/manager/rooms/create">Create new room</a></p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Capacity</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="r" items="${rooms}">
        <tr>
            <td>${r.id}</td>
            <td>${r.name}</td>
            <td>${r.capacity}</td>
            <td>
                <a href="/manager/rooms/delete?id=${r.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="/manager/movies">Back to movies</a></p>
</body>
</html>