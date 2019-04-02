<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>send_formula</title>
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

                <h4>Add Ingredient</h4>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--<td></td>--%>
                        <td><b>Id</b></td>
                        <td><b>Raw</b></td>
                        <td><b>Input Amount</b></td>


                    </tr>
                    </thead>

                    <c:forEach items="${raws}" var="raws">
                        <tr>
                            <form action="/add_formula_page_two" method="POST">
                                <td>${raws.id}</td>
                                <td>${raws.name}</td>

                                <input hidden name="nameFormula" value="${nameFormula}">
                                <input hidden name="measure" value="${measure}">
                                <input hidden name="rawId" value="${raws.id}">
                                <%--<input hidden name="sellingPrice" value="${product.sellingPrice}">--%>
                                <td><input type="number" name="amountOne"></td>
                                <td>
                                    <input type="submit" value="ADD" />
                                </td>


                            </form>
                        </tr>
                    </c:forEach>
                    <%--<h3>Name of Formula</h3>--%>
                    <h3>${nameFormula}</h3>
                    <%--<h3>Measure of Formula</h3>--%>
                    <h3>${measure}</h3>



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