<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 22-Jun-22
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Calculator</title>
    </head>
    <body>
        <h1>Calculator</h1>
        <form action="/calculator" method="post">
            <div>
                <input required type="number" name="number1" placeholder="Input Number1">
                <input required type="number" name="number2" placeholder="Input Number2">
            </div>
            <br>
            <div>
                <button type="submit" name="operator" value="+">addition (+)</button>
                <button type="submit" name="operator" value="-">Subtraction (-)</button>
                <button type="submit" name="operator" value="*">Multiplication (*)</button>
                <button type="submit" name="operator" value="/">Division (/)</button>
            </div>
        </form>


        <p>${number1} ${operator} ${number2} ${equal} ${result}</p>

        <p style="color: red; font-weight: bold">${error}</p>
    </body>
</html>
