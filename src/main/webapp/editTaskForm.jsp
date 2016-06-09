<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.TaskType" %>
<%@ page import="lv.javaguru.java2.domain.User" %><%--

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
<% List<Map> dataList = (List<Map>) request.getAttribute("data");%>
<% Task task = (Task) dataList.get(0);%>
<% List<TaskType> taskTypes = (List<TaskType>) dataList.get(1);  %>
<% List<User> allResponsibles = (List<User>) dataList.get(2);  %>

<br>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Edit task </h3>
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
                <label for="dueDate">Due date</label>
                <input type="text" id="dueDate" name="dueDate" size="40" value="<%= task.getDueDate() != null ? task.getDueDate().toString() : "" %>" class="form-control datepicker">
            </div>

            <div class="form-group">
                <label for="doneDate">Done date</label>
                <input type="text" id="doneDate" name="doneDate" size="40" value="<%= task.getDoneDate() != null ? task.getDoneDate().toString() : "" %>" class="form-control datepicker">
            </div>

            <div class="form-group">
                <label for="taskType">Task types</label>
                <select id="taskType" name="taskType" class="form-control">
                    <% for(TaskType tt:taskTypes ) { %>
                        <% if(tt.getName().equals(task.getTaskType())) { %>
                            <option selected="selected" value="<%= tt.getName()  %>" ><%= tt.getName() %></option>
                        <% } else { %>
                            <option value="<%= tt.getName()  %>"><%= tt.getName() %></option>
                        <% } %>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="responsibleId">Responsible</label>
                <select id="responsibleId" name="responsibleId" class="form-control">
                    <% for(User uu:allResponsibles ) { %>
                        <% if(uu.getUserId() == task.getresponsibleId() ) { %>
                            <option value="<%= uu.getUserId() %>" selected="selected"><%= uu.getFullName() %></option>
                        <% } else { %>
                            <option value="<%= uu.getUserId() %>"><%= uu.getFullName() %></option>
                        <% } %>
                    <% } %>
                </select>
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
