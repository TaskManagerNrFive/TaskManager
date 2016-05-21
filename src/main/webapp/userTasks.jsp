<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/30/16
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page import="java.util.*" %>
<%@ page import="lv.javaguru.java2.domain.User" %>
<html>
<head>
    <title>User tasks page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>

<% List<Map> dataList = (List<Map>) request.getAttribute("data"); %>

<% List<Task> tasks = (List<Task>) dataList.get(0);  %>
<% User user = (User) dataList.get(1);  %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h1>Tasks created by user <%= user.getFullName() %></h1>
        <a href="/java2/newTask" class="btn btn-default" role="button">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            Create new
        </a>
        <br>
        <br>

        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Due date</th>
                <th>Type</th>
                <th>Done</th>
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
                <td><%= tt.getDueDateFormated()  %></td>
                <td><%= tt.getTaskType()  %></td>
                <td>
                    <% if(tt.getDoneStatus() == 1) { %>
                    <span class="label label-info"><%= tt.getDoneDateFormated()  %></span>
                    <% } else { %>
                    <span class="label label-warning"><%= tt.getDoneDateFormated()  %></span>
                    <% } %>
                </td>
                <td>
                    <a href="/java2/editTask?taskId=<%= tt.getTaskId()  %>">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a>
                </td>
                <td>
                    <a href="/java2/destroyTask?taskId=<%= tt.getTaskId()  %>">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
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