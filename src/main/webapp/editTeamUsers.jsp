<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="lv.javaguru.java2.domain.Team" %><%--
  Created by IntelliJ IDEA.
  User: NightStranger
  Date: 5/18/2016
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team Users</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 3); %>
<%@ include file="/Header.jsp" %>

<%
    Team team = (Team) request.getAttribute("team");
    List<User> teamUsers = (List<User>) request.getAttribute("teamUsers");
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");
%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Team Users</h3>
        <h3> <%= team.getName() %> </h3>
        <br>
        <br>
        <% if (!teamUsers.isEmpty()) { %>
          <table class="table">
            <% for (User user : teamUsers) { %>
                <tr>
                    <td>
                        <%= user.getFullName() %>
                    </td>
                    <td>
                        <%= user.getEmail() %>
                    </td>
                    <td>
                        <a
                          href="/java2/deleteTeamUser?teamId=<%= team.getTeamID()%>&userId=<%= user.getUserId()%>">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            <% } %>
          </table>
          <br>
        <% } %>
        <form name="addTeamUser" method="POST" action="addTeamUser">
            <input type="hidden" name="teamId" value="<%= team.getTeamID() %>">
            <div class="form-group">
                <select id="userId" name="userId" class="form-control" required>
                    <% for (User user : allUsers ) {
                        if (teamUsers.contains(user)) continue;
                    %>
                        <option value="<%= user.getUserId()  %>"><%= user.getFullName() %></option>
                    <% } %>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Add</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
