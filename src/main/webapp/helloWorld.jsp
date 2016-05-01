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
        <div class="col-md-10">
            <h3><%= request.getAttribute("data")  %></h3>
        </div>
        <div class="col-md-1"></div>
    </div>
</body>
</html>
