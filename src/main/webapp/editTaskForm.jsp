<%@ page import="lv.javaguru.java2.domain.Task" %><%--

  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/9/16
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>
<% Task task = (Task) request.getAttribute("data"); %>



<br>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <form name="updateTask" method="POST" action="updateTask">
            <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">

            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" size="40" required value="<%= task.getTitle()  %>" class="form-control">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" id="description" name="description" size="40" required value="<%= task.getDescription()  %>" class="form-control">
            </div>
            <div class="form-group">
                <label for="dueDateTime">Due date and time</label>
                <input type="text" id="dueDateTime" name="dueDateTime" size="40" value="<%= task.getDueDatetime()  %>" class="form-control">
            </div>
            <div class="form-group">
                <label for="doneDate">Done date</label>
                <input type="text" id="doneDate" name="doneDate" size="40" value="<%= task.getDoneDate()  %>" class="form-control datepicker">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
    <script>
        $('.datepicker').datepicker({format: 'yyyy-mm-dd'});
    </script>
</html>
