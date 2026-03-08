<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%--Cấu hình bị tắt EL -SOS- --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tech2etc Ecommerce Tutorial</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="./assert/css/style.css">

    <link rel="apple-touch-icon" sizes="180x180" href="./assert/img/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./assert/img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./assert/img/favicon/favicon-16x16.png">
    <link rel="manifest" href="./assert/img/favicon/site.webmanifest">
    <link rel="stylesheet" href="assert/css/style_sproduct.css">

</head>
<body>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>

<section id="prodetails" class="section-p1">
    <div class="single-pro-image">
        <img src="${ctx}${sproduct.img}" width="100%" id="MainImg" alt="">

        <div class="small-img-group">
            <div class="small-img-col">
                <img src="${ctx}${sproduct.img}" width="100%" class="small-img"
                     alt="">
            </div>
            <div class="small-img-col">
                <img src="${ctx}${sproduct.img}" width="100%" class="small-img"
                     alt="">
            </div>
            <div class="small-img-col">
                <img src="${ctx}${sproduct.img}" width="100%" class="small-img"
                     alt="">
            </div>
            <div class="small-img-col">
                <img src="${ctx}${sproduct.img}" width="100%" class="small-img"
                     alt="">
            </div>
        </div>
    </div>

    <div class="sing-pro-details">
        <h6><a class="text-decoration-none" href="#" onclick="history.back()"></a> / ${sproduct.productName}</h6>
        <h4>${sproduct.productName}</h4>

        <h2>DEBUG</h2>

        ${sproduct} <br>
       ${sproduct.productName} <br>
         ${sproduct.description}



</section>

<section class="section-p1 mt-5">
    <div class="rating-flex d-flex flex-row justify-content-evenly">
        <div class="rating-panel">
            <div class="rating-title">Product Ratings</div>
            <div class="rating-summary">
                <div>
                    <span class="rating-summary-score">4.8</span>
                    <span class="rating-summary-out">/5</span>
                </div>
                <div style="display:flex;flex-direction:column;">
                    <span class="rating-summary-label">Satisfied Customers</span>
                    <span class="rating-summary-count">Based on 124 reviews</span>
                </div>
            </div>
            <div>
                <div class="rating-row">
                    <span class="rating-bar-label">5</span>
                    <span class="rating-bar-star"><i class="fa-solid fa-star"></i></span>
                    <span class="rating-bar-body"><span class="rating-bar-active" style="width:85%;"></span></span>
                    <span class="rating-bar-percent">85%</span>
                </div>
                <div class="rating-row">
                    <span class="rating-bar-label">4</span>
                    <span class="rating-bar-star"><i class="fa-solid fa-star"></i></span>
                    <span class="rating-bar-body"><span class="rating-bar-active" style="width:10%;"></span></span>
                    <span class="rating-bar-percent">10%</span>
                </div>
                <div class="rating-row">
                    <span class="rating-bar-label">3</span>
                    <span class="rating-bar-star"><i class="fa-solid fa-star"></i></span>
                    <span class="rating-bar-body"><span class="rating-bar-active" style="width:3%;"></span></span>
                    <span class="rating-bar-percent">3%</span>
                </div>
                <div class="rating-row">
                    <span class="rating-bar-label">2</span>
                    <span class="rating-bar-star"><i class="fa-solid fa-star"></i></span>
                    <span class="rating-bar-body"><span class="rating-bar-active" style="width:2%;"></span></span>
                    <span class="rating-bar-percent">2%</span>
                </div>
                <div class="rating-row">
                    <span class="rating-bar-label">1</span>
                    <span class="rating-bar-star"><i class="fa-solid fa-star"></i></span>
                    <span class="rating-bar-body"><span class="rating-bar-active" style="width:0%;"></span></span>
                    <span class="rating-bar-percent">0%</span>
                </div>
            </div>
        </div>

        <div class="product-info-extend">
            <div class="product-info-title">More Information</div>
            <ul class="product-info-list">
                <li><span class="product-info-label info-material"><i class="fa-solid fa-shirt"></i> Material:</span> <span class="product-info-value">100% Cotton</span></li>
                <li><span class="product-info-label info-weight"><i class="fa-solid fa-weight-hanging"></i> Weight:</span> <span class="product-info-value">180gsm</span></li>
                <li><span class="product-info-label info-color"><i class="fa-solid fa-palette"></i> Color:</span> <span class="product-info-value">Black</span></li>
                <li><span class="product-info-label info-style"><i class="fa-solid fa-tag"></i> Style:</span> <span class="product-info-value">Regular fit / Unisex</span></li>
                <li><span class="product-info-label info-care"><i class="fa-solid fa-box-archive"></i> Care:</span> <span class="product-info-value">Giặt nhiệt độ thấp, không tẩy, hạn chế sấy</span></li>
            </ul>
        </div>
    </div>
</section>

<section id="product1" class="section-p1 mt-5">
    <div class="text-center mb-4">
        <h2>Featured Products</h2>
        <p>Summer Collection New Modern Design</p>
    </div>

    <div class="pro-container d-flex justify-content-center flex-wrap gap-4">
        <div class="pro border p-3 rounded" style="width: 250px;">
            <img src="https://via.placeholder.com/250x250" alt="" class="img-fluid rounded mb-2">
            <div class="des">
                <span class="text-muted" style="font-size: 14px;">adidas</span>
                <h5 class="mt-1">Cartoon Astronaut T-Shirts</h5>
                <div class="star text-warning mb-2">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4 class="text-success">150,000 VNĐ</h4>
            </div>
            <a href="#" class="btn btn-outline-primary w-100 mt-2"><i class="bi bi-cart cart"></i> Add to Cart</a>
        </div>

        <div class="pro border p-3 rounded" style="width: 250px;">
            <img src="https://via.placeholder.com/250x250" alt="" class="img-fluid rounded mb-2">
            <div class="des">
                <span class="text-muted" style="font-size: 14px;">adidas</span>
                <h5 class="mt-1">Vintage Floral Shirt</h5>
                <div class="star text-warning mb-2">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
                <h4 class="text-success">220,000 VNĐ</h4>
            </div>
            <a href="#" class="btn btn-outline-primary w-100 mt-2"><i class="bi bi-cart cart"></i> Add to Cart</a>
        </div>
    </div>
</section>

<section id="newsletter" class="section-p1 section-m1 d-flex justify-content-between align-items-center flex-wrap mt-5 p-5" style="background-color: #041e42; color: white;">
    <div class="newstext">
        <h4>Sign Up For Newsletters</h4>
        <p class="mb-0">Get E-mail updates about our latest shop and <span class="text-warning">special offers.</span></p>
    </div>
    <div class="form d-flex mt-3 mt-md-0">
        <input type="text" class="form-control me-2" placeholder="Your email address" style="max-width: 300px;">
        <button class="btn btn-primary">Sign Up</button>
    </div>
</section>



<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>
