<%@ page import="lv.javaguru.java2.domain.Team" %>
<%--
  Created by IntelliJ IDEA.
  User: NightStranger
  Date: 4/27/2016
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 3); %>
<%@ include file="/mainMenuInclude.jsp" %>

<% Team team = (Team) request.getAttribute("data"); %>

<h3>Team</h3>
<%= team.getName()  %>
<br>
<br>
<%= team.getDescription() %>
<br>
<br>
<a href="/java2/editTeam?teamId=<%= team.getTeamID()  %>">Edit</a>
<a href="/java2/deleteTeam?teamId=<%= team.getTeamID()  %>">x</a>


</body>
</html>
