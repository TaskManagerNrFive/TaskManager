<%@ page import="lv.javaguru.java2.domain.Team" %><%--
  Created by IntelliJ IDEA.
  User: NightStranger
  Date: 4/28/2016
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Team Information</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 3); %>
<%@ include file="/mainMenuInclude.jsp" %>

<%
Team team = (Team) request.getAttribute("data");
%>

<br>
<form name="updateTeam" method="POST" action="updateTeam">
    <input type="hidden" name="teamId" value="<%= team.getTeamID() %>">
    <table cellspacing="15">
        <tr>
            <td colspan="2" align="center"><h2>Edit team information.</h2></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" size="40" required value="<%=team.getName()%>"></td>
        </tr>
        <tr/>
        <tr>
            <td>Description:</td>
            <td><textarea name="description" cols="40" rows="3"><%=team.getDescription()%></textarea></td>
        </tr>
        <tr/>
        <tr>
            <td colspan="2" align="center">
                <h3><input value="    Save    " type="submit"></h3>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
