<%@ page import="lv.javaguru.java2.domain.Team" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teams page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 3); %>
<%@ include file="/mainMenuInclude.jsp" %>

<h1>Teams</h1>
<a href="/java2/newTeam">Create new</a>

<% List<Team> teams = (List<Team>) request.getAttribute("data");  %>

<ul>
    <% for(Team team : teams ) { %>
    <li>
        <a href="/java2/showTeam?teamId=<%= team.getTeamID()  %>">
            <%= team.getName()  %>
        </a>
        &nbsp;
        <a href="/java2/deleteTeam?teamId=<%= team.getTeamID()  %>">x</a>
    </li>
    <% } %>
</ul>
</body>
</html>
