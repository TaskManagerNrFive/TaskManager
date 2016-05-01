<%@ page import="lv.javaguru.java2.domain.TaskType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task types page</title>
</head>
<body>
<% request.setAttribute("currentMenuID", 2); %>
<%@ include file="/mainMenuInclude.jsp" %>

<h1>Task Types</h1>
<a href="/java2/newTaskType">Create new</a>

<% List<TaskType> taskTypes = (List<TaskType>) request.getAttribute("data");  %>

<ul>
<% for(TaskType tt:taskTypes ) { %>
    <li>
        <a href="/java2/showTaskType?taskTypeId=<%= tt.getTaskTypeID()  %>">
            <%= tt.getName()  %>
        </a>
        &nbsp;
        <a href="/java2/destroyTaskType?taskTypeId=<%= tt.getTaskTypeID()  %>">x</a>
    </li>
<% } %>
</ul>
</body>
</html>
