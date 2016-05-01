<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setAttribute("currentMenuID", 2); %>
<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Create task type</h3>

        <br>
        <form name="createTaskType" method="POST" action="createTaskType">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" name="name" size="40" required value="" class="form-control">
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
