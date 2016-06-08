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
    String errorMsg = (String) request.getAttribute("errorMessage");
    String mode = (String) request.getAttribute("mode");
    long teamId;
    String newName = "", newDesc = "";
    if (mode.equals("2")) {
        teamId  = Long.parseLong(request.getParameter("teamId"));
        newName = request.getParameter("name");
        newDesc = request.getParameter("description");
    }
    else {
        Team team = (Team) request.getAttribute("data");
        teamId  = team.getTeamID();
        newName = team.getName();
        newDesc = team.getDescription();
    }
%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Edit team</h3>
        <br>
        <% if (errorMsg != null) { %>
            <h5 class="alert alert-danger"><%= errorMsg %> </h5>
            <br>
        <% } %>
        <form name="updateTeam" method="POST" action="updateTeam">
            <input type="hidden" name="teamId" value="<%= teamId %>">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" name="name" value="<%= newName %>" class="form-control">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="description" value="<%= newDesc %>" class="form-control">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
