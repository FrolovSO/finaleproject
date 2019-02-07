<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/29/2019
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    Rent a car
</div>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<div align="left">
    <form action="/rentcar">
        <input class="btn btn-danger" type="submit" value="Log Out">
    </form>
</div>
<div align="center">
    <title>Auto park</title>

    <%--<a href="FrontController?command=test_command">View Cars </a>--%>
    <%--<table>--%>
    <%--<%=request.getAttribute("testList")%>--%>
    <%--</table>--%>
    <%--</div>>--%>

    /////////////////////////////////////////////////////
    <body>
    <a href="FrontController?command=TEST_COMMAND">
          <p style="text-align: center">
        <button>
            View Cars
        </button>
    </p>
    </a>
        <a href="FrontController?command=VIEW_USER">
            <p style="text-align: center">
                <button>
                    View User
                </button>
            </p>
        </a>
        <table border="1" width="30%" cellpadding="10" align="center">
            <tr>
                <td>
                    <p>Registration namber</p>
                </td>
                <td>
                    <p>Status</p>
                </td>
                <td>
                    <p>Brend</p>
                </td>
                <td>
                    <p>Model</p>
                </td>
                <td>
                    <p>Engine</p>
                </td>
                <td>
                    <p>Year</p>
                </td>
                <td>
                    <p>Color</p>
                </td>
                <td>
                    <p>Price</p>
                </td>
                <c:forEach items="${autoList}" var="auto">
            <tr>
                <td>
                    <p>${auto.autoId}</p>
                </td>
                <td>
                    <p>${auto.carStatus}</p>
                </td>
                <td>
                    <p>${auto.carBrend}</p>
                </td>
                <td>
                    <p>${auto.carModel}</p>
                </td>
                <td>
                    <p>${auto.engine}</p>
                </td>
                <td>
                    <p>${auto.year}</p>
                </td>
                <td>
                    <p>${auto.color}</p>
                </td>
                <td>
                    <p>${auto.priceDay}</p>
                </td>
                <td>
                    <form action="/rentcar">
                            <%--<input type="hidden" name="autoId" value="${auto.autoId}">--%>
                            <%--<input type="hidden" name="command" value="role">--%>
                        <input class="btn btn-danger" type="submit" value="Order Car">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>

</body>

