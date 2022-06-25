<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 24-Jun-22
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Display all customer</title>
    </head>
    <body>
        <h1>Display all customer</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th><a href="/customer/create">Create</a></th>
            </tr>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/customer/view/${customer.id}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
