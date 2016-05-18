<%--
  Created by IntelliJ IDEA.
  User: NightStranger
  Date: 5/19/2016
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String url = (String) request.getAttribute("data");
    response.sendRedirect(url);
%>
