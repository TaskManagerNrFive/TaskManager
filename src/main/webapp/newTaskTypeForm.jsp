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
    <title>Create new Task Type</title>
</head>
<body>

<%
    String formName = request.getParameter("name");
    if (formName == null) formName = "";
%>

<br>
<form name="createTaskType" method="POST" action="createTaskType">
    <table cellspacing="15">
        <tr>
            <td colspan="2" align="center"><h2>New task type.</h2></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" size="40" required value="<%=formName%>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <h3><input value="    Register    " type="submit"></h3>
            </td>
        </tr>
    </table>
</form>

</body>
</html>

