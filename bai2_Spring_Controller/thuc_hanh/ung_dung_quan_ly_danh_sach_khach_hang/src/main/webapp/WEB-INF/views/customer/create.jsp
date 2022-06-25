<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 24-Jun-22
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create customer</title>
    </head>
    <body>
        <h1>Create new Customer</h1>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
        <form action="${pageContext.request.contextPath}/customer/create" method="post">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" placeholder="nhập id customer"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" placeholder="nhập name customer"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" placeholder="nhập email customer"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" placeholder="nhập address customer"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Register" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
