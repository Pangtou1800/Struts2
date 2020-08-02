<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 8/1/2020
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ActionContextDemo</title>
</head>
<body>
    <h4>Action Context Demo</h4>

    application: ${applicationScope.applicationKey}
    <br>
    session: ${sessionScope.sessionKey}
    <br>
    request: ${requestScope.requestKey}
</body>
</html>
