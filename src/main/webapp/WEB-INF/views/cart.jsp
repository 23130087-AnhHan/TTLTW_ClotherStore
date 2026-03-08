<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tech2etc Ecommerce Tutorial</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>

<section id="cart" class="section-p1">
    <div class="table-warraper">
        <table>
            <thead>
            <tr>
                <td>Remove</td>
                <td>Image</td>
                <td>Product</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Subtotal</td>
            </tr>

            </thead>
            <tbody class="main_clothes">
            <tr>
                <td> <a href="#"><i class="bi bi-x-circle"></i></a></td>
                <td><img src="img/products/f1.jpg" alt=""></td>
                <td>Cartoon Astronaut T-Shirts</td>
                <td>$118.19</td>
                <td><input type="number" value="1"></td>
                <td>$118.19</td>
            </tr>
            </tbody>
        </table>
    </div>
</section>

<section id="cart-add" class="section-p1">

    <div id="subtotal">
        <h3>Cart Totals</h3>
        <table>
            <tr>
                <c:forEach var ="items" items="${sessionScope.Cart.items}">
            <tr>
<%--               loop here--%>
            </tr>
            </c:forEach>
            </tr>
        </table>
        <button class="normal">Proceed to checkout</button>
    </div>
</section>
<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>



<!--<script src="script.js"></script>-->
</body>

</html>