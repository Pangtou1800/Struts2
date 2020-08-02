<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 8/1/2020
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Joja Market</title>
</head>
<body>
<h3>Welcome!</h3>
<div>
    Username:<br>
    ${username}
</div>
<div>
    Password:<br>
    ${password}
</div>
<div>
    <h5>当前在线人数：${users}</h5>
</div>
<a href="logout.action?username=${username}">Logout</a>
</body>
</html>
