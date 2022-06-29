<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 27-Jun-22
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>info employee</title>
    </head>
    <body>
        <h2>Submitted Employee Information</h2>
        <table>
            <tr>
                <td>Name:</td>
                <td>${employee.name}</td>
            </tr>
            <tr>
                <td>ID:</td>
                <td>${employee.id}</td>
            </tr>
            <tr>
                <td>Contract Number:</td>
                <td>${employee.contractNumber}</td>
            </tr>
        </table>
    </body>
</html>
