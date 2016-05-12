<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/30/16
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task page</title>
</head>
<body>

<% List<Map> dataList = (List<Map>) request.getAttribute("data");%>
<% Task task = (Task) dataList.get(0);%>
<% User user = (User) dataList.get(1);%>
<% User responsible = (User) dataList.get(2);%>


<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">

        <h1>Task</h1>
        <a href="/java2/editTask?taskId=<%= task.getTaskId()  %>" class="btn btn-default" role="button">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            Edit
        </a>

        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Due date time</th>
                <th>Done date</th>
                <th>Type</th>
                <th>Description</th>
                <th>User name</th>
                <th>Responsible id</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%= task.getTitle()  %></td>
                <td><%= task.getDueDateTimeFormated()  %></td>
                <td><%= task.getDoneDateFormated()  %></td>
                <td><%= task.getTaskType()  %></td>
                <td><%= task.getDescription()  %></td>
                <td><%= user.getFullName()  %></td>
                <td><%= responsible.getFullName()  %></td>
                <td>
                    <a href="/java2/destroyTask?taskId=<%= task.getTaskId()  %>">
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
