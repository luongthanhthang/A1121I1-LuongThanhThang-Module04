<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 27-Jun-22
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Create Employee</title>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form modelAttribute="employee" method="post" action="${pageContext.request.contextPath}/employee/create">
            <table>
                <tr>
                    <td><form:label path="id">Employee id:</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Employee's name: </form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="contractNumber">Contact's number: </form:label></td>
                    <td><form:input path="contractNumber"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
