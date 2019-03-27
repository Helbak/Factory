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

               <h2>Raw invoice</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--<td></td>--%>
                        <td><b>Id</b></td>
                        <td><b>Product</b></td>
                        <td><b>Plus Amount</b></td>
                        <td><b>Purchase Price</b></td>
                        <td><b>Get</b></td>

                    </tr>
                    </thead>
                    <c:forEach items="${raws}" var="raws">
                        <tr>
                            <form action="/check_raw_invoice" method="POST">
                                <td>${raws.id}</td>
                                <td>${raws.name}</td>
                                <input hidden name="id" value="${raws.id}">
                                <input hidden name="name" value="${raws.name}">
                                <td><input type="number" name="plusAmount"></td>
                                <td><input type="number" name="purchasePrice"></td>

                            <td>
                                <input type="submit" value="GET" />
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