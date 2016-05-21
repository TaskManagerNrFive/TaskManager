<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 5/21/16
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="loginUser" method="POST">
    <div class="form-group">
        <label for="login">Login</label>
        <input id="login" type="text" name="login" required value="" class="form-control">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input id="password" type="text" name="password" value="" class="form-control">
    </div>
    <input type="submit" value="Log In" class="btn btn-default"><br>
    <br>
    <a href="/java2/registration" class="btn btn-default">Sign up!</a>
</form>
