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
<h2>Sum of Incoming Invoices</h2>

<h2>${sumBuying}</h2>
<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

               <h2>Incoming Invoices</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        (Product product, Date data, float sellingPrice, float purchasePrice, float plusAmount)
                        <td><b>Id</b></td>
                        <td><b>Name</b></td>
                        <td><b>Data</b></td>
                        <td><b>SellingPrice</b></td>
                        <td><b>purchasePrice</b></td>
                        <td><b>Amount</b></td>
                        <td><b>Sum</b></td>
                    </tr>
                    </thead>
                    <c:forEach items="${incomingInvoices}" var="incomingInvoices">
                        <tr>

                                <td>${incomingInvoices.id }</td>
                            <td>${incomingInvoices.product.name }</td>
                            <td>${incomingInvoices.data }</td>
                            <td>${incomingInvoices.sellingPrice }</td>
                            <td>${incomingInvoices.purchasePrice }</td>
                            <td>${incomingInvoices.plusAmount }</td>
                            <td>${incomingInvoices.plusAmount*incomingInvoices.purchasePrice }</td>
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