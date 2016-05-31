<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 1); %>
<%@ include file="/Header.jsp" %>



<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-4">

        <br>
        <% if(request.getAttribute("data")!= null) { %>
            <h5><%= request.getAttribute("data")%></h5>
        <% } %>

        <% if(sessionUser != null){ %>
            <h3>Welcome <%= sessionUser.getFullName() %>!</h3>
        <% } else { %>
            <h3>Welcome to Task Manager! Please login</h3>
            <%@ include file="/loginForm.jsp" %>
        <% } %>

    </div>
    <div class="col-md-2">
        <img src="http://loremflickr.com/320/240">
    </div>
</div>
</body>
</html>
