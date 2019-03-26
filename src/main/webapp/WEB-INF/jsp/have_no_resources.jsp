<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>send_product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<br>
<br>

<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div align="center">
                    <img height="50" width="55" src="<c:url value="/src/main/webapp/WEB-INF/static/logo1.png"/>">
                <h1>you do not have enough resources</h1>
                </div>

            </div>

        </div>
    </nav>
</div>
<div align="center">
    <form action="/" method="POST">
        <input type="submit" value="BACK" />
    </form>
</div>
</body>
</html>