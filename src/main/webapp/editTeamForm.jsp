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
<%@ include file="/Header.jsp" %>

<%
Team team = (Team) request.getAttribute("data");
%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Edit team</h3>
        <br>
        <form name="updateTeam" method="POST" action="updateTeam">
            <input type="hidden" name="teamId" value="<%= team.getTeamID() %>">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" name="name" required value="<%=team.getName()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="description" value="<%=team.getDescription()%>" class="form-control">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
