<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check_sales_invoice</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<br>
<br>
<div align="center">
<h2>Check. Do you confirm sale..? </h2>
    <br>
    <br>

    <div class="container">

        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <table class="table table-striped">
                        <thead>
                        <tr>

                            <td><b>Id</b></td>
                            <td><b>Name</b></td>
                            <td><b>Amount</b></td>
                            <td><b>Price for Sale</b></td>
                            <td><b>Sale Amount</b></td>

                        </tr>
                        </thead>

                            <tr>

                                <td>${id}</td>
                                <td>${name}</td>
                                <td>${amount}</td>
                                <td>${sellingPrice}</td>
                                <td>${saleAmount}</td>

                            </tr>

                    </table>
                    <form action="/write_sales_invoice" method="POST">

                        <input hidden name="id" value="${id}">
                        <input hidden name="name" value="${name}">
                        <input hidden name="amount" value="${amount}">
                        <input hidden name="sellingPrice" value="${sellingPrice}">
                        <input hidden name="saleAmount" value="${saleAmount}">

                            <input type="submit" value="CONFIRM" />

                    </form>

                </div>

</div>

        </nav>

            </div>
    <form action="/sale_product" method="POST">
        <input type="submit" value="BACK" />
    </form>
</div>
</body>
</html>