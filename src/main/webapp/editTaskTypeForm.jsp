<%@ page import="lv.javaguru.java2.domain.TaskType" %><%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/17/16
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% TaskType taskType = (TaskType) request.getAttribute("data"); %>

<h3>Edit task type</h3>

<br>
<form name="updateTaskType" method="POST" action="updateTaskType">
    <input type="hidden" name="taskTypeId" size="40" value="<%= taskType.getTaskTypeID() %>">
    <table cellspacing="15">
        <tr>
            <td colspan="2" align="center"><h2>Edit task type.</h2></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" size="40" required value="<%= taskType.getName() %>">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <h3><input value="Save" type="submit"></h3>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
