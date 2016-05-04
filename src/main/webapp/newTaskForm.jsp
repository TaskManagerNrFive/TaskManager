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
<% request.setAttribute("currentMenuID", 4); %>
<%@ include file="/Header.jsp" %>


<%
    String formName = request.getParameter("name");
    if (formName == null) formName = "";
%>

<br>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <form name="createTask" method="POST" action="createTask">

            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="title" size="40" required value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="description" size="40" required value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="dueDateTime">Due date and time</label>
                <input type="text" name="dueDateTime" size="40" value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="doneDate">Done date</label>
                <input type="text" name="doneDate" size="40" value="" class="form-control datepicker">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>
<script>
    $('.datepicker').datepicker({format: 'yyyy-mm-dd'});
</script>

</body>
</html>
