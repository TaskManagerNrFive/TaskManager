<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 1); %>
<%@ include file="/Header.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <h3>Sign Up</h3>

        <form name="registration" action="/java2/registerUser" method="post">
            <div class="form-group">
                <label for="firstName">First name</label>
                <input id="firstName" type="text" name="firstName" required class="form-control">
            </div>
            <div class="form-group">
                <label for="lastName">Last name</label>
                <input type="text" name="lastName" id="lastName" required class="form-control"/>

            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" name="email" id="email" required class="form-control"/>

            </div>
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" name="login" id="login" required class="form-control"/>

            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required class="form-control"/>

            </div>

            <input type="submit" value="Submit" class="btn btn-default"/>

        </form>

    </div>
    <div class="col-md-6"></div>
</div>
</body>
</html>
