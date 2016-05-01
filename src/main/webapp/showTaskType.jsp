<%@ page import="lv.javaguru.java2.domain.TaskType" %><%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/17/16
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task type</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 2); %>
<%@ include file="/Header.jsp" %>

<% TaskType taskType = (TaskType) request.getAttribute("data"); %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">

    <h3>Task type</h3>
    <table class="table">
        <thead>
            <th>Name</th>
            <th>Description</th>
            <th></th>
            <th></th>
        </thead>
        <tbody>
            <tr>
                <td><%= taskType.getName()  %></td>
                <td></td>
                <td>
                    <a href="/java2/editTaskType?taskTypeId=<%= taskType.getTaskTypeID()  %>">Edit</a>
                </td>
                <td>
                    <a href="/java2/destroyTaskType?taskTypeId=<%= taskType.getTaskTypeID()  %>">x</a>
                </td>
            </tr>
        </tbody>
    </table>


    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
