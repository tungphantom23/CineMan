<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm lịch chiếu - CineMan</title>
</head>
<body>
<h1>Thêm lịch chiếu</h1>
<form action="/showtimes/create" method="post">
    Ngày chiếu: <input type="date" name="showDate"><br>
    Thời gian bắt đầu: <input type="time" name="startTime"><br>
    Thời gian kết thúc: <input type="time" name="endTime"><br>
    Phòng chiếu: <select name="roomId">
        <c:forEach var="r" items="${rooms}">
            <option value="${r.id}">${r.name} (cap ${r.capacity})</option>
        </c:forEach>
    </select><br>
    Phim: <select name="movieId">
        <c:forEach var="m" items="${movies}">
            <option value="${m.id}">${m.title}</option>
        </c:forEach>
    </select><br>
    Giá vé cơ bản: <input type="number" name="baseTicketPrice" value="100000"><br>
    <button type="submit">Tạo</button>
</form>
<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>
<c:if test="${not empty message}">
    <div style="color:green">${message}</div>
</c:if>

</body>
</html>
