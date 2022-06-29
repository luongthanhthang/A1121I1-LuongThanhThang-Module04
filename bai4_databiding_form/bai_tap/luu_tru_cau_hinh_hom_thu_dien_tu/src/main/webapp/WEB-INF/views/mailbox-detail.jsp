<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 29-Jun-22
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>detail</title>
    </head>
    <body>
        <table>
            <tr>
                <td>languages: ${mailbox.languages}</td>
            </tr>
            <tr>
                <td>pageSizes: ${mailbox.pageSizes}</td>
            </tr>
            <tr>
                <td>spamsFilter: ${mailbox.spamsFilter}</td>
            </tr>
            <tr>
                <td>signature: ${mailbox.signature}</td>
            </tr>
        </table>
    </body>
</html>
