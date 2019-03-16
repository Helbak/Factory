<!DOCTYPE html>
<html lang="en">
<body>
<div align="center">

    <h2>Enter information about product</h2>




    <form action="/write_supply_product" method="post">
        <input type="submit" value="Delete marked">
        <table class="table table-striped">
            <thead>
            <tr>
                <td></td>

                <td><b>Name</b></td>
                <td><b>Producer</b></td>
                <td><b>Amount</b></td>
                <td><b>Selling Price</b></td>
                <td><b>Amount for Sale</b></td>

            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${product.id}" id="checkbox_${product.id}"/></td>
                    <td>${product.name}</td>
                    <td>${product.producer}</td>
                    <td>${product.amount}</td>
                    <td>${product.sellingPrice}</td>
                    <td><input type="number" name="amount"></td>
                    </tr>
            </c:forEach>
        </table>
    </form>








    <form action="/write_suply_product" method="POST">
        Name: <input type="text" name="name">
        <br>
        <br>

       Amount Supply: <input type="number" name="amount">
        <br>
        <br>
        Purchase price: <input type="number" name="purchasePrice">
        <br>
        <br>
        Selling Price: <input type="number" name="sellingPrice">
        <br>
        <br>
        <input type="submit"/>
    </form>
    <br>
    <br>
    <br>
    <br>

    <form action="/" method="GET">
        <h2> Done </h2>
        <input type="submit"/>
    </form>

</div>



</body>
</html>