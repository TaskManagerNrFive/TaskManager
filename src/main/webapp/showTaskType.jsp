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

<ul>
    <li>
        <a href="/java2/hello">Home page</a>
    </li>
    <li>
        <a href="/java2/taskTypes">Task types</a>
    </li>
</ul>

<% TaskType taskType = (TaskType) request.getAttribute("data"); %>

    <h3>Task type</h3>
    <%= taskType.getName()  %>
    <a href="/java2/destroyTaskType?taskTypeId=<%= taskType.getTaskTypeID()  %>">x</a>

</body>
</html>
