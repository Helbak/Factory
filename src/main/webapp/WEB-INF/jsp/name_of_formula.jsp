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
                    <form action="/add_formula" method="POST">
                    <h3>Tape name of Formula</h3>
                    <input type="text" name="nameFormula">
                    <h3>Tape measure of Formula</h3>
                        <input type="text" name="measure">
                        <br/>
                        <br/>
                        <tr>
                        <input type="submit" value="NEXT" />
                        </tr>
                    </form>
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