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
%>

<ul>
    <%
        for (MainMenuItem mainMenuItem : mainMenuItems) { %>
        <li>
            <% if (mainMenuItem.getId() != currentMenuID) { %>
                <a href="<%= mainMenuItem.getUrl() %>"> <%= mainMenuItem.getName() %> </a>
            <% } else { %>
                <%= mainMenuItem.getName() %>
            <% } %>
        </li>
    <% } %>
</ul>
