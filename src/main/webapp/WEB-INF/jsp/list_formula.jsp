<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list_formula</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<br>
<br>
<%--<h2>Raw Balance</h2>--%>

<%--<h2>${sumRaw}</h2>--%>
<div class="container">


    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

               <h2>Formulas</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--String name, String measure, Ingredient one, Ingredient two, Ingredient three, Ingredient four, Ingredient fiv--%>
                        <td><b>Id</b></td>
                        <td><b>Name</b></td>
                        <td><b>Measure</b></td>
                        <td><b>Ingredient one</b></td>
                        <td><b>Ingredient two</b></td>
                        <td><b>Ingredient three</b></td>
                        <td><b>Ingredient four</b></td>
                            <td><b>Ingredient five</b></td>
                    </tr>
                    </thead>
                    <c:forEach items="${formulas}" var="formulas">
                        <tr>

                                <td>${formulas.id }</td>
                                <td>${formulas.name }</td>
                                <td>${formulas.measure}</td>
                                <td>${formulas.one.raw.name }</td>
                                <td>${formulas.two.raw.name }</td>
                                <td>${formulas.three.raw.name }</td>
                            <td>${formulas.four.raw.name }</td>
                            <td>${formulas.five.raw.name }</td>
                        </tr>
                    </c:forEach>
                </table>
                <h2>Ingredients</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <%--float weight, Raw raw--%>
                        <td><b>Id</b></td>
                            <td><b>For Formula</b></td>
                        <td><b>Total Weight</b></td>
                        <td><b>RawId</b></td>
                        <td><b>Raw Name</b></td>
                            <td><b>Weight in Formula</b></td>
                    </tr>
                    </thead>
                    <c:forEach items="${ingredients}" var="ingredients">
                        <tr>

                            <td>${ingredients.id }</td>
                           <td>Formula</td>
                            <%--<td>${ingredients.formula }</td>--%>
                            <td>${ingredients.raw.amount }</td>
                            <td>${ingredients.raw.id}</td>
                            <td>${ingredients.raw.name }</td>
                            <td>${ingredients.weight }</td>
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