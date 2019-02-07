<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/7/2019
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="UTF-8">
    <title>Create Car</title>
</head>
<body>
<div align="center">
    <div>
        <a href="FrontController?command=TEST_COMMAND">
            <p style="text-align: center">
                <button>
                    View Cars
                </button>
            </p>
        </a>
    </div>
    <div>
        <form action="FrontController" id="form-page-admin">
            <input type="hidden" name="command" value="add_car">
            </br>
            <input type="text" id="Registration namber" name="autoId" size="20" maxlength="25" placeholder="Registration nambe">
            </br>
            <input type="text" id="Status" name="carStatus" size="20" maxlength="25" placeholder="Status">
            </br>
            <input type="text" id="Brend" name="carBrend" size="20" maxlength="25" placeholder="Brend">
            </br>
            <input type="text" id="Model" name="carModel" size="20" maxlength="25" placeholder="Model">
            </br>
            <input type="text" id="Engine" name="engine" size="20" maxlength="25" placeholder="Engine">
            </br>
            <input type="text" id="Color" name="color" size="20" maxlength="25" placeholder="Color">
            </br>
            <input type="text" id="Year" name="year" size="20" maxlength="25" placeholder="Year">
            </br>
            <input type="text" id="Price" name="priceDay" size="20" maxlength="25" placeholder="Price">
            </br>
            <input type="submit" id="finish_button" value="Add Car!">

        </form>
    </div>
</div>
