<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/30/16
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/mainMenuInclude.jsp" %>

<h1>Tasks</h1>

<% List<Task> tasks = (List<Task>) request.getAttribute("data");  %>

<table border="1">
    <thead>
        <tr>
            <th>Title</th>
            <th>Due date time</th>
            <th>Done date</th>
            <th>Type</th>
            <th>Description</th>
            <th>User id</th>
            <th>Responsible id</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% for(Task tt:tasks ) { %>
            <tr>
                <td>
                    <a href="/java2/showTask?taskId=<%= tt.getTaskId()  %>">
                        <%= tt.getTitle()  %>
                    </a>
                </td>
                <td><%= tt.getDueDatetime()  %></td>
                <td><%= tt.getDoneDate()  %></td>
                <td><%= tt.getTaskType()  %></td>
                <td><%= tt.getDescription()  %></td>
                <td><%= tt.getUserId()  %></td>
                <td><%= tt.getresponsibleId()  %></td>
                <td>
                    <a href="/java2/destroyTask?taskId=<%= tt.getTaskId()  %>">x</a>
                </td>
            </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
