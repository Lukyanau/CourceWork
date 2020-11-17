<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Golden - Cars</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">
</head>

<body style="background-image: url(${pageContext.request.contextPath}/images/carHome.jpg);background-size: cover;">
<h1 class="text-center text-white d-none d-lg-block site-heading"><span class="text-primary site-heading-upper mb-3">Car is your best friend</span><span class="site-heading-upper">Elite Cars</span></h1>
<nav class="navbar navbar-light navbar-expand-lg bg-dark py-lg-4" id="mainNav">
    <div class="container"><a class="navbar-brand text-uppercase d-lg-none text-expanded" href="#">Brand</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav mx-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="controller?command=passing_home">Home</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="controller?command=passing_about_us">About us</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="products.html">Purchase</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="controller?command=passing_sign_in">LOG IN</a></li>
            </ul>
        </div>
    </div>
</nav>
<section class="page-section clearfix">
    <div class="container">
        <div class="intro"><img class="img-fluid intro-img mb-3 mb-lg-0 rounded" src="${pageContext.request.contextPath}/images/about.jpg">
            <div class="intro-text left-0 text-centerfaded p-5 rounded bg-faded text-center">
                <h2 class="section-heading mb-4"><span class="section-heading-upper">Everyday Comfort</span><span class="section-heading-lower">This is your Choice</span></h2>
                <p class="mb-3">
                    The cars presented in our salon are incredibly profitable and comfortable. Here you can find an elite car for every taste and color.</p>
                <div class="mx-auto intro-button"><a class="btn btn-primary d-inline-block mx-auto btn-xl" role="button" href="#">Buy right Now!</a></div>
            </div>
        </div>
    </div>
</section>
<section class="page-section cta">
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <div class="cta-inner text-center rounded">
                    <h2 class="section-heading mb-4"><span class="section-heading-upper">Our Guaranties</span><span class="section-heading-lower">To You</span></h2>
                    <p class="mb-0">When you walk into our shop, we are dedicated to providing you with friendly service, a welcoming atmosphere, and above all else, excellent products made with the highest quality. If you are not satisfied, please let us know and we will do whatever we can to make things right!</p>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="footer text-faded text-center py-5">
    <div class="container">
        <p class="m-0 small">Copyright&nbsp;©&nbsp;Brand 2020</p>
    </div>
</footer>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/current-day.js"></script>
</body>

</html>
