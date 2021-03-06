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
<%@ include file="/Header.jsp" %>

<%
    String errorMsg = (String) request.getAttribute("errorMessage");
    String mode = (String) request.getAttribute("mode");
    String newName = "", newDesc = "";
    if (mode.equals("2")) {
        newName = request.getParameter("name");
        newDesc = request.getParameter("description");
    }
%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Create team</h3>
        <br>
        <% if (errorMsg != null) { %>
            <h5 class="alert alert-danger"><%= errorMsg %> </h5>
            <br>
        <% } %>
        <form name="newTeamRegistration" method="POST" action="newTeamRegistration">
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
