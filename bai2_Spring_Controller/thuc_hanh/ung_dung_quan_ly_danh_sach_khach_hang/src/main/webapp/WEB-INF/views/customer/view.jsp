<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 24-Jun-22
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>View Customer</title>
    </head>
    <body>
        <h1>Customer detail</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>${customer.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${customer.name}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${customer.address}</td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </body>
</html>
