<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/6/2019
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<div align="left">
    <form action="/rentcar">
        <input class="btn btn-danger" type="submit" value="Log Out">
    </form>
</div>
<div align="center">
    User list
</div>
<div>
    <a href="FrontController?command=TEST_COMMAND">
        <p style="text-align: center">
            <button>
                View Cars
            </button>
        </p>
    </a>
</div>
</body>
<body>
<
<table border="1" width="30%" cellpadding="10" align="center">
    <tr>
        <td>
            <p>Id</p>
        </td>
        <td>
            <p>Name</p>
        </td>
        <td>
            <p>Surname</p>
        </td>
        <td>
            <p>Login</p>
        </td>
        <td>
            <p>Phone</p>
        </td>
        <td>
            <p>Email</p>
        </td>
        <td>
            <p>Driver License</p>
        </td>
        <c:forEach items="${userList}" var="user">
    <tr>
        <td>
            <p>${user.userId}</p>
        </td>
        <td>
            <p>${user.userName}</p>
        </td>
        <td>
            <p>${user.surname}</p>
        </td>
        <td>
            <p>${user.login}</p>
        </td>
        <td>
            <p>${user.mobilePhone}</p>
        </td>
        <td>
            <p>${user.email}</p>
        </td>
        <td>
            <p>${user.driverLicense}</p>
        </td>
        <td>
            <form action="FrontController" method="post">
                <input type="hidden" name="userId" value="${user.userId}">
                <input type="hidden" name="command" value="role">
                <input class="btn btn-danger" type="submit" value="Change role">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
