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
<html>
<head>
    <title>Tasks page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>


<% List<Task> tasks = (List<Task>) request.getAttribute("data");  %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h1>Tasks</h1>
        <a href="/java2/newTask" class="btn btn-default" role="button">Create new</a>
        <br>
        <br>

        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Due date time</th>
                <th>Done date</th>
                <th>Type</th>
                <th>User id</th>
                <th>Status</th>
                <th>Responsible id</th>
                <th></th>
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
                <td><%= tt.getUserId()  %></td>
                <td>
                    <% if(tt.getDoneStatus() == 1) { %>
                        <span class="label label-info">Done</span>
                    <% } else { %>
                        <span class="label label-warning">Not done</span>
                    <% } %>
                </td>

                <td><%= tt.getresponsibleId()  %></td>
                <td>
                    <a href="/java2/editTask?taskId=<%= tt.getTaskId()  %>">Edit</a>
                </td>
                <td>
                    <a href="/java2/destroyTask?taskId=<%= tt.getTaskId()  %>">x</a>
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
