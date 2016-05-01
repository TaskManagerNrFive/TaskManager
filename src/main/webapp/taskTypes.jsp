<%@ page import="lv.javaguru.java2.domain.TaskType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task types page</title>
</head>
<body>
<% request.setAttribute("currentMenuID", 2); %>
<% List<TaskType> taskTypes = (List<TaskType>) request.getAttribute("data");  %>

<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h1>Task Types</h1>
        <a href="/java2/newTaskType" class="btn btn-default">Create new</a>


        <table class="table">
            <thead>
                <th>Name</th>
                <th>Description</th>
                <th></th>
            </thead>
            <tbody>
            <% for(TaskType tt:taskTypes ) { %>
                <tr>
                    <td>
                        <a href="/java2/showTaskType?taskTypeId=<%= tt.getTaskTypeID()  %>">
                            <%= tt.getName()  %>
                        </a>
                    </td>
                    <td><%= tt.getDescription()  %></td>
                    <td>
                        <a href="/java2/destroyTaskType?taskTypeId=<%= tt.getTaskTypeID()  %>">x</a>
                    </td>
1               </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
