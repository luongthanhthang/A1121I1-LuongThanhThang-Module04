<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 24-Jun-22
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sandwich</title>

    </head>
    <body>
        <h1>Sandwich Condiments</h1>
        <form action="/save" method="post">
            <input type="checkbox" name="condiment" value="Lettuce">Lettuce
            <input type="checkbox" name="condiment" value="Tomato">Tomato
            <input type="checkbox" name="condiment" value="Mustard">Mustard
            <input type="checkbox" name="condiment" value="Sprouts">Sprouts
        <button type="submit">Save</button>
        </form>
        <p>${sandwich}</p>
    </body>
</html>
