<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 7/31/2020
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Joja Market Detail</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Welcome to Joja Market</h3>
    </div>

    <h4>Product Information:</h4>

    <table class="table table-striped">
        <tr>
            <td class="col-md-3">ProductName:</td>
            <td>${ name }</td>
        </tr>
        <tr>
            <td class="col-md-3">ProductDescription:</td>
            <td>${ description }</td>
        </tr>
        <tr>
            <td class="col-md-3">ProductPrice:</td>
            <td>${ price }</td>
        </tr>

    </table>
    <br>
    <a href="product-input.action" class="btn btn-primary btn-sm">Input more Products...</a>
</div>

</body>
</html>
