<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tech2etc Ecommerce Tutorial</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="apple-touch-icon" sizes="180x180" href="assert/img/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assert/img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assert/img/favicon/favicon-16x16.png">
    <link rel="manifest" href="assert/img/favicon/site.webmanifest">

    <link rel="stylesheet" href="assert/css/style.css">
</head>
<body>

<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>

<section id="hero">
    <h4>Trade-in-offer</h4>
    <h2>Super value deals</h2>
    <h1>On all products</h1>
    <p>Save more with coupons & up to 70% off!</p>
    <button>Shop now</button>
</section>

<section id="feature" class="section-p1">
    <div class="fe-box">
        <img src="assert/img/features/f1.png" alt="">
        <h6>Free Shipping</h6>
    </div>
    <div class="fe-box">
        <img src="assert/img/features/f2.png" alt="">
        <h6>Online Order</h6>
    </div>
    <div class="fe-box">
        <img src="assert/img/features/f3.png" alt="">
        <h6>Save Money</h6>
    </div>
    <div class="fe-box">
        <img src="assert/img/features/f4.png" alt="">
        <h6>Promotions</h6>
    </div>
    <div class="fe-box">
        <img src="assert/img/features/f5.png" alt="">
        <h6>Happy Sell</h6>
    </div>
    <div class="fe-box">
        <img src="assert/img/features/f6.png" alt="">
        <h6>F24/7 Support</h6>
    </div>
</section>

<section id="product1" class="section-p1">
    <div class="pro-container">
        <c:forEach var ="p" items="${Product1}">
            <div class="pro">
             <img src="${pageContext.request.contextPath}${p.img}" alt="">
                <div class="des">
                    <span>adidas</span>
                    <h5>${p.productName}</h5>
                    <h5>${p.price}</h5>

                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
<%--                    <h4><fmt:formatNumber value="${p.price }" pattern="#,##0 VNĐ"/></h4>--%>
                </div>
                <a href="${pageContext.request.contextPath}/shop?action=SProduct&productID=${p.productID}&type=${p.categoryID}"><i class="bi bi-cart cart"></i></a>
            </div>
        </c:forEach>
    </div>
</section>

<section id="banner" class="section-m1">
    <h4>Repair Services</h4>
    <h2>Up to <span>70% Off</span> - All t-Shirts & Accessorices</h2>
    <button class="normal">Explore More</button>
</section>


<section id="sm-banner" class="section-p1">
    <div class="banner-box">
        <h4>Crazy deals</h4>
        <h2>buy 1 get 1 free</h2>
        <span>The best classic dress is on sale at cara</span>
        <button class="white">Learn More</button>
    </div>
    <div class="banner-box banner-box2">
        <h4>Spring / Summer</h4>
        <h2>upcomming season</h2>
        <span>The best classic dress is on sale at cara</span>
        <button class="white">Collection</button>
    </div>
</section>

<section id="banner3">
    <div class="banner-box ">
        <h2>SEASONAL SALE</h2>
        <h3>Winter Collection -50% OFF</h3>
    </div>
    <div class="banner-box banner-box2">
        <h2>NEW FOOTWEAR COLLECTION</h2>
        <h3>Spring / Summer 2026</h3>
    </div>
    <div class="banner-box banner-box3">
        <h2>T-SHIRTS</h2>
        <h3>New Trendy Prints</h3>
    </div>
</section>

<section id="newsletter" class="section-p1 section-m1">
    <div class="newstext">
        <h4>Sign Up For Newsletters</h4>
        <p>Get E-mail updates about our latest shop and <span>special offers.</span></p>
    </div>
    <div class="form">
        <input type="text" placeholder=" Your email address">
        <button class="normal">Sign Up</button>
    </div>
</section>
<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>

</body>
</html>
