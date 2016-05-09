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
    <div class="col-md-5">
        <h3>Welcome to Task Manager!</h3><br>
        <h3><%= request.getAttribute("data")  %>
        </h3>
        <form action="/registerUser" method="POST">
            <div class="form-group">
                <label for="login">Login</label>
                <input id="login" type="text" name="name" required value="" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" type="text" name="description" value="" class="form-control">
            </div>
            <input type="submit" value="Log In" class="btn btn-default"><br>
            <br>
            <a href="/java2/registration" class="btn btn-default">Sign up!</a>
        </form>
        <div class="col-md-1"></div>
    </div>
</div>
</body>
</html>
