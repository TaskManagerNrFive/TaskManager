<%@ page import="lv.javaguru.java2.domain.Team" %>
<%@ page import="lv.javaguru.java2.domain.User" %>
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
<%@ include file="/Header.jsp" %>

<%
    Team team = (Team) request.getAttribute("team");
    List<User> teamUsers = (List<User>) request.getAttribute("teamUsers");
%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h1>Team</h1>
        <a href="/java2/editTeam?teamId=<%= team.getTeamID()  %>" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            Edit Info
        </a>
        &nbsp; &nbsp; &nbsp;
        <a href="/java2/editTeamUsers?teamId=<%= team.getTeamID()  %>" class="btn btn-default">
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            Edit Users
        </a>
        <table class="table">
            <thead>
                <th>Name</th>
                <th>Description</th>
                <th>Users</th>
                <th></th>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <%= team.getName()  %>
                    </td>
                    <td>
                        <%= team.getDescription()  %>
                    </td>
                    <td>
                        <%
                            boolean firstUser = true;
                            for (User user : teamUsers) {
                                if (!firstUser) {
                        %>
                                    <BR>
                        <%
                            }
                        %>
                                <%= user.getFullName() %>
                        <%
                                firstUser = false;
                            }
                        %>
                    </td>
                    <td>
                        <a href="/java2/tasks?filterMode=2&filterUserId=0&filterTeamId=<%= team.getTeamID() %>&filterStatus=1&filterTitle="
                           role="button">
                            <span class="glyphicon glyphicon-hourglass" aria-hidden="true"></span>
                            Tasks
                        </a>
                    </td>
                    <td>
                        <a href="/java2/deleteTeam?teamId=<%= team.getTeamID()  %>">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
