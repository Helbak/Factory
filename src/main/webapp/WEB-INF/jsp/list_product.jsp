<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>supply_product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<br>
<br>
<h2>Product Balance</h2>

<h2>${sumProduct}</h2>
<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

               <h2>Products</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>

                        <td><b>Id</b></td>
                        <td><b>Name</b></td>
                        <td><b>producer</b></td>
                        <td><b>measure</b></td>
                        <td><b>amount</b></td>
                        <td><b>sellingPrice</b></td>
                        <td><b>costPrice</b></td>
                    </tr>
                    </thead>
                    <c:forEach items="${products}" var="products">
                        <tr>

                                <td>${products.id }</td>
                                <td>${products.name }</td>
                                <td>${products.producer}</td>
                                <td>${products.measure }</td>
                                <td>${products.amount }</td>
                                <td>${products.sellingPrice }</td>
                            <td>${products.costPrice }</td>

                        </tr>
                    </c:forEach>
                </table>


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