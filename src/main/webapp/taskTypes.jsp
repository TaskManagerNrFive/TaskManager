<%@ page import="lv.javaguru.java2.domain.TaskType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task types page</title>
</head>
<body>
<h1>Task Types</h1>
<% List<TaskType> taskTypes = (List<TaskType>) request.getAttribute("data");  %>

<%= request.getAttribute("data") %>
<%= taskTypes.size() %>
<%= request.getAttribute("data") %>
<ul>
<% for(TaskType tt:taskTypes ) { %>
    <li><%= tt.getName()  %></li>
<% } %>
</ul>
</body>
</html>
