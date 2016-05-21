<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 5/1/16
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.domain.User" %>

<script src="//code.jquery.com/jquery-1.9.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>

<% User sessionUser = (User)  session.getAttribute("User"); %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-4" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> <a class="navbar-brand" href="/java2">Task Manager</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                    <% if(sessionUser != null) { %>
                        <p class="navbar-text">Signed in as <%= sessionUser.getFullName() %></p>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a class="navbar-brand" href="logoutUser">Logout</a></li>
                        </ul>
                    <% } else { %>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="/java2/registration" class="navbar-brand">Sign up!</a>
                        </li>
                    </ul>
                    <% } %>
                </div>
            </div>
        </nav>
    </div>
    <div class="col-md-1">
    </div>
</div>

<% if(sessionUser != null) { %>
    <%@ include file="/mainMenuInclude.jsp" %>
<% } %>