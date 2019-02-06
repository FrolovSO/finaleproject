<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/1/2019
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<div align="center">
    <div>
        <form action="FrontController" id="form-page-registration">
            <input type="hidden" name="command" value="registration">
            </br>
            <input type="text" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
            </br>
            <input type="password" id="Password" name="password" size="20" maxlength="25" placeholder="Password">
            </br>
            <input type="text" id="UserName" name="name" size="20" maxlength="25" placeholder="UserName">
            </br>
            <input type="text" id="Surname" name="surname" size="20" maxlength="25" placeholder="Surname">
            </br>
            <input type="text" id="Email" name="email" size="20" maxlength="25" placeholder="Email">
            </br>
            <input type="text" id="MobilePhone" name="mobilePhone" size="20" maxlength="25" placeholder="MobilePhone">
            </br>
            <input type="text" id="DriverLicense" name="driverLicense" size="20" maxlength="25" placeholder="DriverLicense">
            </br>
            <input type="submit" id="finish_button" value="Reg me!">
            </br>
            <a href="/rentcar">Go to back </a>
        </form>
    </div>
</div>
