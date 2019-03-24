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

<h2>Cash Balance</h2>

<h2>${cash}</h2>
<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <h2>Sales Invoice</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--<td></td>--%>
                        <td><b>Id</b></td>
                        <td><b>Product</b></td>
                        <td><b>Amount</b></td>
                        <td><b>Selling Price</b></td>
                        <td><b>Sale Amount</b></td>
                        <td><b>Sale</b></td>

                    </tr>
                    </thead>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <form action="/check_sales_invoice" method="POST">
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.amount}</td>
                                <td>${product.sellingPrice}</td>
                                <input hidden name="id" value="${product.id}">
                                <input hidden name="name" value="${product.name}">
                                <input hidden name="amount" value="${product.amount}">
                                <input hidden name="sellingPrice" value="${product.sellingPrice}">
                                <td><input type="number" name="saleAmount"></td>

                                <td>
                                    <input type="submit" value="SALE" />
                                </td>
                            </form>

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