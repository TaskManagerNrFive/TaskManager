<%@ page import="lv.javaguru.java2.domain.TaskType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task types page</title>
</head>
<body>

<ul>
    <li>
        <a href="/java2/hello">Home page</a>
    </li>
    <li>
        Task types
    </li>
</ul>

<h1>Task Types</h1>
<a href="/java2/newTaskType">Create new</a>

<% List<TaskType> taskTypes = (List<TaskType>) request.getAttribute("data");  %>

<ul>
<% for(TaskType tt:taskTypes ) { %>
    <li>
        <%= tt.getName()  %>
        <a href="/java2/destroyTaskType?taskTypeId=<%= tt.getTaskTypeID()  %>">x</a>
    </li>
<% } %>
</ul>
</body>
</html>
