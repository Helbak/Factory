<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produce product</title>
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

                <h2>Choose Formula for produce product</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--<td></td>--%>
                        <td><b>Id</b></td>
                        <td><b>Name</b></td>
                        <%--<td><b>Measure</b></td>--%>
                            <%--<td><b>Amount</b></td>--%>
                            <td><b>Amount Product</b></td> percentage of markup
                            <td><b>Percentage of markup</b></td>

                    </tr>
                    </thead>

                    <c:forEach items="${formulas}" var="formulas">
                        <tr>
                            <form action="/add_product_to_trading" method="POST">
                                <td>${formulas.id}</td>
                                <td>${formulas.name}</td>
                                <%--<td>${formulas.raw.weight}</td>--%>
                                <%--<td>${formulas.name}</td>--%>

                                <input hidden name="formulaId" value="${formulas.id}">

                                <td><input type="number" name="amount"></td>
                                <td><input type="number" name="markup"></td>
                                <td>
                                    <input type="submit" value="ADD" />
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