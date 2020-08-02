<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 8/1/2020
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Action Context Demo</title>
</head>
<body>
<h4>Servlet Action Context Demo</h4>
Application Value: ${applicationScope.applicationKey3}
<br>
Session Value: ${sessionScope.sessionKey3}
<br>
Request Value: ${requestScope.requestKey3}
</body>
</html>
