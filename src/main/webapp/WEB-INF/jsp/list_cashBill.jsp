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
<h2>Cash Balance</h2>

<h2>${cash}</h2>
<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

               <h2>Invoices</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--<td></td>--%>
                        <td><b>Id</b></td>
                        <td><b>Data</b></td>
                        <td><b>Id Invoice</b></td>
                        <td><b>Pay / Receive</b></td>
                        <td><b>Balance</b></td>

                    </tr>
                    </thead>
                    <c:forEach items="${cashBalances}" var="cashBalances">
                        <tr>

                                <td>${cashBalances.id}</td>
                                <td>${cashBalances.data }</td>
                                <td>${cashBalances.idInvoice }</td>
                                <td>${cashBalances.payReceive }</td>
                                <td>${cashBalances.cashBalance }</td>


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