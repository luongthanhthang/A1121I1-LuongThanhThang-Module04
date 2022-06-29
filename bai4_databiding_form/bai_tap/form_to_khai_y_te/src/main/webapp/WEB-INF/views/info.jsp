<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 29-Jun-22
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>info</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Họ tên (Ghi chữ IN HOA): ${person.name}</td>
            </tr>
            <tr>
                <td>Năm sinh: ${person.yearOfBirth}</td>
            </tr>
            <tr>
                <td>Giới tính: ${person.sex}</td>
            </tr>
            <tr>
                <td>Quốc tịch: ${person.nation}</td>
            </tr>
            <tr>
                <td>Sổ hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác: ${person.idCard}</td>
            </tr>
            <tr>
                <td>Thông tin đi lại: ${person.travel}</td>
            </tr>
            <tr>
                <td>Số hiệu phương tiện: ${person.travelId}</td>
            </tr>
            <tr>
                <td>Số ghế: ${person.seats}</td>
            </tr>
            <tr>
                <td>Ngày khởi hành: ${person.startDate}</td>
            </tr>
            <tr>
                <td>Ngày kết thúc: ${person.endDate}</td>
            </tr>
            <tr>
                <td>Trong vòng 14 ngày qua. Anh/Chị có đến tỉnh, thành phố nào: ${person.attention}</td>
            </tr>
        </table>
    </body>
</html>
