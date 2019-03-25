<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Factory</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>

       <h5>Cash Balance</h5>
<h4>${cash}</h4>

<form action="/list_cashBill" method="GET">
    <input type="submit" value="LIST"/>
</form>
<br>

<h5>Total Profit</h5>
<h4>${profit}</h4>

<div align="center">
    <table border = "3">
        <div align="center">
            <tr border = "3"><h1 >TRAIDING</h1></tr>
        <tr >
         <td border = "3">
<form action="/add_product" method="GET">
   <h2>  Add new product  </h2>
    <div align="center">
    <input type="submit" value="ADD"/>
    </div>
</form>
             <form action="/list_product" method="GET">
                  <div align="center">
                     <input type="submit" value="LIST"/>
                  </div>
             </form>
         </td>
            <td border = "3">
            <form action="/sales_invoice" method="GET">
        <h2>   Sales Invoice  </h2>
                <div align="center">
        <input type="submit" value="SALE"/>
                </div>
    </form>
                <form action="/list_sales_invoice" method="GET">
                    <div align="center">
                        <input type="submit" value="LIST"/>
                    </div>
                </form>
            </td>
            <td>
            <form action="/incoming_invoice" method="GET">
        <h2> Incoming Invoice  </h2>
                <div align="center">
        <input type="submit" value="BUY"/>
                </div>
    </form>
                <form action="/list_incoming_invoice" method="GET">
                    <div align="center">
                        <input type="submit" value="LIST"/>
                    </div>
                </form>
            </td>

        </tr>

        </div>
    </table>
<table border = "3">
            <tr border = "3">
                <div align="center">
                    <br>

<tr border = "3"><h1>PRODUCING</h1></tr>
                    <tr >
                        <td border = "3">
                            <form action="/add_raw" method="GET">
                                <h2>  Add new raw material:  </h2>
                                <div align="center">
                                    <input type="submit" value="ADD"/>
                                </div>
                            </form>

                        </td>

                        <td>
                            <form action="/buy_raw" method="GET">
                                <h2> Buy Raw Material  :</h2>
                                <div align="center">
                                    <input type="submit" value="BUY RAW"/>
                                </div>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form action="/add_formula" method="GET">
                                <h2>  Add new formula of Product:  </h2>
                                <div align="center">
                                    <input type="submit" value="ADD"/>
                                </div>
                            </form>
                        </td>
                        <td>
                            <form action="/coverse_raw" method="GET">
                                <h2>   Produce Product:  </h2>
                                <div align="center">
                                    <input type="submit" value="SALE"/>
                                </div>
                            </form>
                        </td>

                    </tr>
</table>

    </div>

</body>
</html>