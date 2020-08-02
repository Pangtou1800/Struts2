<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 8/1/2020
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Context Aware Demo</title>
</head>
<body>
<h4>Servlet Action Aware Demo</h4>
Application Value: ${applicationScope.applicationKey4}
<br>
Session Value: ${sessionScope.sessionKey4}
<br>
Request Value: ${requestScope.requestKey4}

</body>
</html>
