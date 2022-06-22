<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 21-Jun-22
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>dictionary</title>
    </head>
    <body>
        <h1>Từ điển Anh - Việt</h1>
        <h2>input number 'one' to 'ten'</h2>
        <h4 style="color: red">${error}</h4>
        <form action="/dictionary" method="post">
            <input type="text" name="english" placeholder="input english">
            <input type="submit" value="submit">
        </form>
        <h2 style="color: blue">Result: ${english} -> ${vietnam}</h2>
    </body>
</html>
