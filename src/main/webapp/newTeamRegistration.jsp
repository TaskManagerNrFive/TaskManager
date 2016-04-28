<%--
  Created by IntelliJ IDEA.
  User: NightStranger
  Date: 4/7/2016
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Team Registration</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 3); %>
<%@ include file="/mainMenuInclude.jsp" %>

<br>
<form name="newTeamRegistration" method="POST" action="newTeamRegistration">
    <table cellspacing="15">
        <tr>
            <td colspan="2" align="center"><h2>New team registration.</h2></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" size="40" required value=""></td>
        </tr>
        <tr/>
        <tr>
            <td>Description:</td>
            <td><textarea name="description" cols="40" rows="3"></textarea></td>
        </tr>
        <tr/>
        <tr>
            <td colspan="2" align="center">
                  <h3><input value="    Register    " type="submit"></h3>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
