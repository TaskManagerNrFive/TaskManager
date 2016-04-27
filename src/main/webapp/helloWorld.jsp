<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

    <h3><%= request.getAttribute("data")  %></h3>

    <%--
    <% request.setAttribute("currentMenuID", 1); %>
    <%@ include file="/mainMenuInclude.jsp" %>
    --%>

    <ul>
        <li>
            Home page
        </li>
        <li>
            <a href="/java2/taskTypes">Task types</a>
        </li>
        <li>
            <a href="/java2/teams">Teams</a>
        </li>
    </ul>

</body>
</html>
