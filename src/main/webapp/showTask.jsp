<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/30/16
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="lv.javaguru.java2.domain.TaskComment" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task page</title>
</head>
<body>

<% List<Map> dataList = (List<Map>) request.getAttribute("data");%>
<% Task task = (Task) dataList.get(0);%>
<% User user = (User) dataList.get(1);%>
<% User responsible = (User) dataList.get(2);%>
<%
    List <TaskComment> taskComments =
            (List <TaskComment>) request.getAttribute("taskComments");
    Map <Long, User> taskCommentsUsers =
            (Map <Long, User>) request.getAttribute("taskCommentsUsers");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM YYYY HH:mm");
%>

<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">

        <h3>Task</h3>
        <a href="/java2/editTask?taskId=<%= task.getTaskId()  %>" class="btn btn-default" role="button">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            Edit
        </a>
        <a href="/java2/destroyTask?taskId=<%= task.getTaskId()  %>" class="btn btn-danger" role="button">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            Destroy
        </a>
        <br>
        <br>

        <table class="table">
            <tbody>
                <tr>
                    <th>Title</th>
                    <td><%= task.getTitle()  %></td>
                </tr>
                <tr>
                    <th>Due date</th>
                    <td><%= task.getDueDateFormated()  %></td>
                </tr>
                <tr>
                    <th>Done date</th>
                    <td><%= task.getDoneDateFormated()  %></td>
                </tr>
                <tr>
                    <th>Type</th>
                    <td><%= task.getTaskType()  %></td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td><%= task.getDescription()  %></td>
                </tr>
                <tr>
                    <th>User name</th>
                    <td><%= user.getFullName()  %></td>
                </tr>
                <tr>
                    <th>Responsible name</th>
                    <td><%= responsible.getFullName()  %></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="col-md-5">
        <h3>Comments</h3>
        <a class="btn btn-primary" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            Add new
        </a>
        <br>
        <br>
        <div class="collapse" id="collapseExample">
            <form name="createTaskComment" method="POST" action="createTaskComment">
                <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                <div class="form-group">
                    <textarea name="text" style="resize:none" rows="3" class="form-control" required></textarea>
                </div>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
        </div>

        <table class="table">
            <% for (TaskComment taskComment : taskComments) { %>
                    <tr>
                        <td>
                            <p class="text-primary">
                                <%= simpleDateFormat.format(taskComment.getCreateTimeStamp())%>
                                -
                                <strong>
                                    <%= taskCommentsUsers.get(taskComment.getUserID())
                                                           .getFullName()%>
                                </strong>
                            </p>
                            <p> <%= taskComment.getText()
                                    .replaceAll("\r\n", "<BR>")
                                    .replaceAll("\r", "<BR>")
                                    .replaceAll("\n", "<BR>")
                                    .replaceAll(" ", "&nbsp;") %>
                            </p>
                            <br>
                        </td>
                    </tr>
            <% } %>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
