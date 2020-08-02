<%--
  Created by IntelliJ IDEA.
  User: aband
  Date: 7/31/2020
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Joja Market Input</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Welcome to Joja Market</h3>
    </div>

    <h4>Input Product Information:</h4>

    <form action="product-save.action" method="post">
        <table class="table table-striped">
            <tr>
                <td class="col-md-3">ProductName:</td>
                <td><input type="text" name="name" class="form-control"/></td>
            </tr>
            <tr>
                <td class="col-md-3">ProductDescription:</td>
                <td><input type="text" name="description" class="form-control"/></td>
            </tr>
            <tr>
                <td class="col-md-3">ProductPrice:</td>
                <td><input type="text" name="price" class="form-control"/></td>
            </tr>

        </table>
        <br/>

        <button class="btn btn-default" type="submit">Submit</button>
    </form>
</div>
</body>
</html>
