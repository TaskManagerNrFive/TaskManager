<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/30/16
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">

        <h1>Task</h1>

        <% Task task = (Task) request.getAttribute("data"); %>

        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Due date time</th>
                <th>Done date</th>
                <th>Type</th>
                <th>Description</th>
                <th>User id</th>
                <th>Responsible id</th>
                <th>Id</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%= task.getTitle()  %></td>
                <td><%= task.getDueDateTimeFormated()  %></td>
                <td><%= task.getDoneDateFormated()  %></td>
                <td><%= task.getTaskType()  %></td>
                <td><%= task.getDescription()  %></td>
                <td><%= task.getUserId()  %></td>
                <td><%= task.getresponsibleId()  %></td>
                <td>
                    <a href="/java2/destroyTask?taskId=<%= task.getTaskId()  %>">x</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
