<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>

<% request.setAttribute("currentMenuID", 1); %>
<%@ include file="/Header.jsp" %>

<div class="container">
    <div  class="content registr-wrap">
        <form name="registration" action="/java2/registerUser" method="post">
            <table>
                <colgroup>
                    <col class="col1">
                    <col class="col2">
                </colgroup>
                <tr>
                    <th colspan="2">
                        <% String data = (String)request.getAttribute("model");
                            if (data != null) {%>
                        <%=data +" "%>
                        <%}
                        %>
                        Registration!
                    </th>
                </tr>
                <tr>
                    <td class="inright">
                        First name:
                    </td>
                    <td>
                        <input type="text" name="firstName" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Last name:
                    </td>
                    <td>
                        <input type="text" name="lastName" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Login:
                    </td>
                    <td>
                        <input type="text" name="login" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Password:
                    </td>
                    <td>
                        <input type="password" name="password" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td class="reg-bottom" colspan="2">
                        <div>
                            <input type="submit" value="Submit!" class="btn btn-default"/>
                        </div>
                    </td>
                </tr>
            </table>
            <div class="message">
                <p><% if (data!=null){%><%=data%><%}%> </p>
            </div>
        </form>
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
</body>
</html>
