<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 8/1/2020
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Joja Market</title>
</head>
<body>
    <h3>Login</h3>
    <br>
    <form action="login.action" method="post">
        <div>
            Username:<br>
            <input type="text" name="username" />
        </div>
        <br>
        <div>
            Password:<br>
            <input type="text" name="password" />
        </div>
        <br>
        <input type="submit" value="Login" />
    </form>
</body>
</html>
