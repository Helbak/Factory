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
<h2>Raw Balance</h2>

<h2>${sumRaw}</h2>
<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

               <h2>Raws</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--String name, String producer, String measure, float amount, float purchasePrice, float costPrice--%>
                        <td><b>Id</b></td>
                        <td><b>Name</b></td>
                        <td><b>producer</b></td>
                        <td><b>measure</b></td>
                        <td><b>amount</b></td>
                        <td><b>Purchase Price</b></td>
                        <td><b>Cost Price</b></td>
                    </tr>
                    </thead>
                    <c:forEach items="${raws}" var="raws">
                        <tr>

                                <td>${raws.id }</td>
                                <td>${raws.name }</td>
                                <td>${raws.producer}</td>
                                <td>${raws.measure }</td>
                                <td>${raws.amount }</td>
                                <td>${raws.purchasePrice }</td>
                            <td>${raws.costPrice }</td>

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