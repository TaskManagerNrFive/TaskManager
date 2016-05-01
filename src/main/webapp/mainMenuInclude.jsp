<%@ page import="lv.javaguru.java2.servlet.mvc.MainMenuItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: NightStranger
  Date: 4/27/2016
  Time: 00:57
  To change this template use File | Settings | File Templates.
--%>

<%
    int currentMenuID = (Integer) request.getAttribute("currentMenuID");
    List<MainMenuItem> mainMenuItems = new ArrayList();
    mainMenuItems.add(new MainMenuItem(1, "Home page", "/java2/hello"));
    mainMenuItems.add(new MainMenuItem(2, "Task types", "/java2/taskTypes"));
    mainMenuItems.add(new MainMenuItem(3, "Teams", "/java2/teams"));
    mainMenuItems.add(new MainMenuItem(4, "Tasks", "/java2/tasks"));
%>
<br>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <ul class="nav nav-tabs">
            <%
                for (MainMenuItem mainMenuItem : mainMenuItems) { %>
                    <% if (mainMenuItem.getId() != currentMenuID) { %>
                        <li role="presentation">
                            <a href="<%= mainMenuItem.getUrl() %>" role="button"> <%= mainMenuItem.getName() %> </a>
                        </li>
                    <% } else { %>
                        <li class="active" role="presentation">
                            <a href="#"><%= mainMenuItem.getName() %></a>
                        </li>
                    <% } %>
            <% } %>
        </ul>
    </div>
    <div class="col-md-1"></div>
</div>