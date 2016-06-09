<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 4/30/16
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.Task" %>
<%@ page import="java.util.*" %>
<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="lv.javaguru.java2.servlet.mvc.AllTasksFilterState" %>
<%@ page import="lv.javaguru.java2.servlet.mvc.FilterItem" %>
<html>
<head>
    <title>User tasks page</title>
</head>
<body>

<%
    List<Map> dataList = (List<Map>) request.getAttribute("data");
    List<Task> tasks = (List<Task>) dataList.get(0);
    User user = (User) dataList.get(1);
    User sessUser = (User) session.getAttribute("User");
    List<List<FilterItem>> filterLists = (List) request.getAttribute("filterLists");
    AllTasksFilterState filterState = (AllTasksFilterState) request.getAttribute("filterState");
    String pageHeader;
    if (user.getUserId() == sessUser.getUserId()) {
        pageHeader = "My tasks";
        request.setAttribute("currentMenuID", 5);
    }
    else {
        pageHeader = "Tasks created by user " + user.getFullName();
        request.setAttribute("currentMenuID", 4);
    }
%>

<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h3> <%= pageHeader %> </h3>
    </div>
    <div class="col-md-1"></div>
</div>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-2">
        <a href="/java2/newTask" class="btn btn-default" role="button">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            Create new
        </a>
    </div>
    <div class="col-md-8">
        <a class="btn btn-default" role="button" data-toggle="collapse" href="#filterForm" aria-expanded="false" aria-controls="filterForm">
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            Filter
        </a>
        &emsp;&emsp;
        <%=
        filterState.formStringUser(filterLists.get(0)).replaceAll(" ", "&nbsp;")
        %>
    </div>
    <div class="col-md-1"></div>
</div>

<div class="collapse" id="filterForm">
    <br>
    <br>
    <form name="filterForm" method="POST" action="userTasks" class="form-horizontal" role="form">
        <input type="hidden" name="filterMode" value="1">
        <input type="hidden" name="filterUserId" value="<%= user.getUserId()%>">
        <div class="form-group">
            <label class="control-label col-md-2" for="filterStatus">Status:</label>
            <div class="col-md-4">
                <select id="filterStatus" name="filterStatus" class="form-control" required>
                    <% for (FilterItem item : filterLists.get(0)) { %>
                    <option value="<%= item.getId() %>"&nbsp;
                            <% if (item.getId() == filterState.getStatus()) { %>
                            selected="selected"&nbsp;
                            <% } %>
                    >
                        <%= item.getName() %></option>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="filterTitle">Title:</label>
            <div class="col-md-4">
                <input type="text" id = "filterTitle" name="filterTitle"
                       value="<%= filterState.getTitle() %>" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-4">
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    Submit
                </button>
            </div>
        </div>
    </form>
</div>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <br>
        <br>
        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Due date</th>
                <th>Type</th>
                <th>Done</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% for(Task tt:tasks ) { %>
            <tr>
                <td>
                    <a href="/java2/showTask?taskId=<%= tt.getTaskId()  %>">
                        <%= tt.getTitle()  %>
                    </a>
                </td>
                <td><%= tt.getDueDateFormated()  %></td>
                <td><%= tt.getTaskType()  %></td>
                <td>
                    <% if(tt.getDoneStatus() == 1) { %>
                    <span class="label label-info"><%= tt.getDoneDateFormated()  %></span>
                    <% } else { %>
                    <span class="label label-warning"><%= tt.getDoneDateFormated()  %></span>
                    <% } %>
                </td>
                <td>
                    <a href="/java2/editTask?taskId=<%= tt.getTaskId()  %>">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a>
                </td>
                <td>
                    <a href="/java2/destroyTask?taskId=<%= tt.getTaskId()  %>">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>


</body>
</html>
