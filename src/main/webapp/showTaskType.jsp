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
        <a href="/java2/editTaskType?taskTypeId=<%= taskType.getTaskTypeID()  %>" class="btn btn-default" role="button">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            Edit
        </a>
    <table class="table">
        <thead>
            <th>Name</th>
            <th>Description</th>
            <th></th>
        </thead>
        <tbody>
            <tr>
                <td><%= taskType.getName()  %></td>
                <td>
                    <% if(taskType.getDescription() != null)  { %>
                        <%=  taskType.getDescription() %>
                    <%  } %>
                </td>
                <td>
                    <a href="/java2/destroyTaskType?taskTypeId=<%= taskType.getTaskTypeID()  %>">
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
