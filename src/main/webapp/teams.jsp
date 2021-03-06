<%@ page import="lv.javaguru.java2.domain.Team" %>
<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teams page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 3); %>
<%@ include file="/Header.jsp" %>

<%
    List<Team> teams = (List<Team>) request.getAttribute("teams");
    Map<Long, List<User>> users = (Map<Long, List<User>>)
                                    request.getAttribute("users");
%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h3>Teams</h3>
        <a href="/java2/newTeam" class="btn btn-default">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            Create new
        </a>
        <table class="table">
            <thead>
                <th>Name</th>
                <th>Description</th>
                <th>Users</th>
                <th></th>
            </thead>
            <tbody>
            <% for(Team team : teams ) { %>
                <tr>
                    <td>
                        <a href="/java2/showTeam?teamId=<%= team.getTeamID()  %>">
                            <%= team.getName()  %>
                        </a>
                    </td>
                    <td>
                        <%= team.getDescription()  %>
                    </td>
                    <td>
                        <%
                            List<User> teamUsers = users.get(team.getTeamID());
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
                        </a>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
