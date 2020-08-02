<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 7/31/2020
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome to Joja Market</title>
  </head>
  <body>
    <a href="product-input.action">Product Input</a>
    <br><br>
    <a href="ActionContextDemo.action?name=pangtou">Action Context Demo</a>
    <br><br>
    <a href="AwareActionDemo.action?name=pangtou2">Aware Action Demo</a>
    <br><br>
    <a href="ServletActionContextDemo.action?name=pangtou3">Servlet Action Context Demo</a>
    <br><br>
    <a href="ServletActionAwareDemo.action?name=pangtou4">Servlet Action Aware Demo</a>
    <br><br>
    <a href="welcome.action">Login</a>
    <br><br>
    <a href="ActionResultDemo.action?number=0">ActionResultDemo0</a><br>
    <a href="ActionResultDemo.action?number=1">ActionResultDemo1</a><br>
    <a href="ActionResultDemo.action?number=2">ActionResultDemo2</a><br>
    <a href="ActionResultDemo.action?number=3">ActionResultDemo3</a><br>

    <br><br>
    <a href="UserAction-query.action">User Query</a>
    <a href="UserAction-update.action">User Update</a>
    <a href="UserAction-insert.action">User Insert</a>
    <a href="UserAction-delete.action">User Delete</a>

    <%
      if (application.getAttribute("date") == null) {
        application.setAttribute("date", new java.util.Date());
      }
    %>
  </body>
</html>
