<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Room</title>
</head>
<body>
<h1>Create Room</h1>
<form action="/manager/rooms/create" method="post">
    <label for="name">Name:</label>
    <input id="name" name="name" /> <br/>
    <label for="capacity">Capacity:</label>
    <input id="capacity" name="capacity" type="number" /> <br/>
    <button type="submit">Save</button>
</form>
<p><a href="/manager/rooms">Back to rooms</a></p>
</body>
</html>