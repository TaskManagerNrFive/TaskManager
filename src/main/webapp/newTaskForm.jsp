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
            <title>Create new Task</title>
        </head>
<body>
<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>
<% List<Map> dataList = (List<Map>) request.getAttribute("data");%>
<% List<TaskType> taskTypes = (List<TaskType>) dataList.get(0);  %>
<% List<User> allResponsibles = (List<User>) dataList.get(1);  %>

<br>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>New task</h3>
        <form name="createTask" method="POST" action="createTask">

            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" size="40" required value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" id="description" name="description" size="40" required value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="dueDateTime">Due date and time</label>
                <input type="text" id="dueDateTime" name="dueDateTime" size="40" value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="doneDate">Done date</label>
                <input type="text" id="doneDate" name="doneDate" size="40" value="" class="form-control datepicker">
            </div>

            <div class="form-group">
                <label for="taskType">Task types</label>
                <select id="taskType" name="taskType" class="form-control">
                    <% for(TaskType tt:taskTypes ) { %>
                        <option value="<%= tt.getName()  %>"><%= tt.getName() %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="responsibleId">Responsible</label>
                <select id="responsibleId" name="responsibleId" class="form-control">
                    <% for(User uu:allResponsibles ) { %>
                        <option value="<%= uu.getUserId()  %>"><%= uu.getFullName() %></option>
                    <% } %>
                </select>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>
<script>
    $('.datepicker').datepicker({format: 'yyyy-mm-dd'});
</script>

</body>
</html>
