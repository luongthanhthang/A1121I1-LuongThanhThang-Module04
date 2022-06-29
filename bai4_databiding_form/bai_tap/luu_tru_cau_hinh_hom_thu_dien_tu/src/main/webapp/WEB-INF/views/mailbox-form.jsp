<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 28-Jun-22
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Form</title>
    </head>
    <body>
        <h1>Setting</h1>
        <form:form modelAttribute="mailbox" method="post" action="${pageContext.request.contextPath}/update">
            <table>
                <tr>
                    <td><form:label path="languages">Languages:</form:label></td>
                    <td><form:select path="languages" items="${languageList}"/></td>
                </tr>
                <tr>
                    <td><form:label path="pageSizes">Page Sizes:</form:label></td>
                    <td>Show <form:select path="pageSizes" items="${pageSizeList}"/> emails per page</td>
                </tr>
                <tr>
                    <td><form:label path="spamsFilter">Spams filter:</form:label></td>
                    <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
                </tr>
                <tr>
                    <td><form:label path="signature">Signature:</form:label></td>
                    <td><form:textarea path="signature"/></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" style="color: white; background: blue">Update</button>
                    </td>
                    <td>
                        <button type="reset">Cancel</button>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
