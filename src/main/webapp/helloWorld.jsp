<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

    <h3><%= request.getAttribute("data")  %></h3>

    <% request.setAttribute("currentMenuID", 1); %>
    <%@ include file="/mainMenuInclude.jsp" %>


</body>
</html>
