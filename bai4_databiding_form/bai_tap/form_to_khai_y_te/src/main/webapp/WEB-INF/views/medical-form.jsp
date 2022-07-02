<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 28-Jun-22
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>medical form</title>
        <style>
            .important {
                color: red;
            }
        </style>
    </head>
    <body>
        <center>
            <h1>TỜ KHAI BÁO Y TẾ</h1>
            <h2>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
                CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h2>
            <h4 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
                sự</h4>
        </center>
        <form:form modelAttribute="person" action="${pageContext.request.contextPath}/update" method="post">
            <table style="width: 100%">
                <tr>
                    <td colspan="6"><form:label path="name">Họ tên (Ghi chữ IN HOA) <span
                            class="important">(*)</span></form:label></td>
                </tr>

                <tr>
                    <td colspan="6"><form:input path="name" cssStyle="width: 100%"/></td>
                </tr>

                <tr>
                    <td class="error">${mapError.name}</td>
                </tr>

                <tr>
                    <td colspan="2"><form:label path="yearOfBirth">Năm sinh <span
                            class="important">(*)</span></form:label></td>
                    <td colspan="2"><form:label path="sex">Giới tính <span class="important">(*)</span></form:label>
                    </td>
                    <td colspan="2"><form:label path="nation">Quốc tịch <span class="important">(*)</span></form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><form:select path="yearOfBirth" items="${yearOfBirthList}"
                                                 cssStyle="width: 100%"/></td>
                    <td colspan="2"><form:select path="sex" items="${sexList}" cssStyle="width: 100%"/></td>
                    <td colspan="2"><form:select path="nation" items="${nationList}" cssStyle="width: 100%"/></td>
                </tr>
                <tr>
                    <td class="error">${mapError.birthday}</td>
                </tr>

                <tr>
                    <td colspan="6"><form:label
                            path="idCard">Sổ hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                            class="important">(*)</span></form:label></td>
                </tr>
                <tr>
                    <td class="error">${mapError.idCard}</td>
                </tr>
                <tr>
                    <td colspan="6"><form:input path="idCard" cssStyle="width: 100%"/></td>
                </tr>

                <tr>
                    <td colspan="6"><form:label
                            path="travel">Thông tin đi lại<span class="important">(*)</span></form:label></td>
                </tr>
                <tr>
                    <td colspan="6"><form:radiobuttons path="travel" items="${travelList}"/></td>
                </tr>
                <tr>
                    <td class="error">${mapError.travelInfo}</td>
                </tr>


                <tr>
                    <td colspan="3"><form:label path="travelId">Số hiệu phương tiện</form:label></td>
                    <td colspan="3"><form:label path="seats">Số ghế</form:label></td>
                </tr>

                <tr>
                    <td colspan="3"><form:input path="travelId" cssStyle="width: 100%"/></td>
                    <td colspan="3"><form:input path="seats" cssStyle="width: 100%"/></td>
                </tr>

                <tr>
                    <td colspan="1" class="error">${mapError.numberVehicle}</td>
                    <td colspan="2" class="error">${mapError.numberSeat}</td>
                </tr>

                <tr>
                    <td colspan="3"><form:label path="">Ngày khởi hành</form:label> <span class="important">(*)</span>
                    </td>
                    <td colspan="3"><form:label path="">Ngày kết thúc</form:label> <span class="important">(*)</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:input path="startDate" cssStyle="width: 100%"/></td>
                    <td colspan="3"><form:input path="endDate" cssStyle="width: 100%"/></td>
                </tr>

                <tr>
                    <td colspan="1" class="error">${mapError.dateStart}</td>
                    <td colspan="2" class="error">${mapError.dateEnd}</td>
                </tr>

                <tr>
                    <td colspan="6"><form:label
                            path="attention">Trong vòng 14 ngày qua. Anh/Chị có đến tỉnh, thành phố nào?<span
                        class="important">(*)</span></form:label></td>
                </tr>
                <tr>
                    <td colspan="6"><form:textarea path="attention" cssStyle="width: 100%"/></td>
                </tr>

                <tr>
                    <td class="error">${mapError.extraInfo}</td>
                </tr>
            </table>
            <center>
                <button type="submit">Gửi tờ khai</button>
            </center>
        </form:form>
    </body>
</html>
