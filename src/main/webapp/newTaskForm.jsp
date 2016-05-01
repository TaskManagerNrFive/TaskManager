<%--

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

<%
    String formName = request.getParameter("name");
    if (formName == null) formName = "";
%>

<br>
<form name="createTask" method="POST" action="createTask">
    <table cellspacing="15">
        <tr>
            <td colspan="2" align="center"><h2>New task</h2></td>
        </tr>

        <tr>
            <td>Title:</td>
            <td><input type="text" name="title" size="40" required value=""></td>
        </tr>

        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" size="40" required value=""></td>
         </tr>

        <tr>
            <td>Due Date and time:</td>
            <td><input type="text" name="dueDateTime" size="40" value=""></td>
        </tr>

        <tr>
            <td>Done date:</td>
            <td><input type="text" name="doneDate" size="40" value=""></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <h3><input value="Create" type="submit"></h3>
            </td>
        </tr>
    </table>
</form>

</body>
</html>

</title>
</head>
<body>

</body>
</html>
