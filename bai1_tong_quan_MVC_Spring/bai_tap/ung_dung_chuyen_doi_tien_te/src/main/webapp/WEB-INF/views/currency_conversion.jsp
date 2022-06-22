<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 21-Jun-22
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Chuyển đổi tiền tệ</title>
    </head>
    <body>
        <h1>Chuyển đổi tiền tệ từ usd sang vnd</h1>
        <form action="/current" method="post">
            <input type="number" name="usd" placeholder="input usd">
            <input type="submit" value="submit">
        </form>
        <h2 style="color: blue">Result: ${usd} USD -> ${vnd} VND</h2>
    </body>
</html>
