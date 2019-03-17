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

                    <li>
                        <button type="button" id="write_sale_product" class="btn btn-default navbar-btn">Sale Product
                        </button>
                    </li>

    <table class="table table-striped">
        <thead>
        <tr>
            <td></td>

            <td><b>Id</b></td>
            <td><b>Producer</b></td>
            <td><b>Amount</b></td>
            <td><b>Selling Price</b></td>
            <td><b>Amount for Sale</b></td>

        </tr>
        </thead>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${product.id}" id="checkbox_${product.id}"/></td>
                <td>${product.name}</td>
                <td>${product.producer}</td>
                <td>${product.amount}</td>
                <td>${product.sellingPrice}</td>
                <td><input type="number" name="amount"></td>


            </tr>
        </c:forEach>
    </table>


</div>


</body>
</html>