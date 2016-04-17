<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

    <h3><%= request.getAttribute("data")  %></h3>

    <ul>
        <li>
            Home page
        </li>
       <li>
           <a href="/java2/taskTypes">Task types</a>
       </li>
    </ul>
</body>
</html>
