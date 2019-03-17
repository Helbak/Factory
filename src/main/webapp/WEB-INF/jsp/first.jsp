<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Factory</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<div align="center">

<form action="/add_product" method="GET">
   <h2> Add new product:</h2>
    <input type="submit"/>
</form>
    <form action="/send_product" method="GET">
        <h2> Sale product:</h2>
        <input type="submit"/>
    </form>
    <form action="/supply_product" method="GET">
        <h2> Supply product:</h2>
        <input type="submit"/>
    </form>
    </div>
</body>
</html>