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
<% request.setAttribute("currentMenuID", 2); %>
<%@ include file="/Header.jsp" %>


<% TaskType taskType = (TaskType) request.getAttribute("data"); %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Edit task type</h3>

        <br>
        <form name="updateTaskType" method="POST" action="updateTaskType">
            <input type="hidden" name="taskTypeId" value="<%= taskType.getTaskTypeID() %>">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" name="name" size="40" required value="<%= taskType.getName() %>" class="form-control">
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
