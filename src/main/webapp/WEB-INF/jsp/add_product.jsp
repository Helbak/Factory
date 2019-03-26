<!DOCTYPE html>
<html lang="en">
<body>
<div align="center">

    <h2>Enter information about product</h2>
    <form action="/write_product" method="POST">
        Name: <input type="text" name="name">
        <br>
        <br>
        Producer: <input type="text" name="producer">
        <br>
        <br>
        Measure: <input type="text" name="measure">
        <br>
        <br>
       <%--Amount: <input type="number" name="amount">--%>
        <%--<br>--%>
        <%--<br>--%>
        Purchase price: <input type="number" name="purchasePrice">
        <br>
        <br>
        Selling Price: <input type="number" name="sellingPrice">
        <br>
        <br>
        <input type="submit" value="ADD"/>
        <input hidden name="amount" value=0>
    </form>
    <br>
    <br>
    <br>
    <br>
    <%--<form action="/add_product" method="GET">--%>
        <%--<h2> Add new product:</h2>--%>
        <%--<input type="submit"/>--%>
    <%--</form>--%>
    <form action="/" method="GET">

         <input type="submit" value="BACK"/>

    </form>

</div>



</body>
</html>