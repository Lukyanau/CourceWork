<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/font-awesome.min.css">
</head>

<body id="page-top">
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
    <div class="container"><a class="navbar-brand" href="#page-top">GOLDEN CARS</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" data-toogle="collapse" aria-controls="navbarResponsive" aria-expanded="false"
                                                                                           aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto text-uppercase">
                <li class="nav-item" role="presentation"></li>
                <li class="nav-item" role="presentation"></li>
                <li class="nav-item" role="presentation"></li>
                <li class="nav-item" role="presentation"></li>
                <li class="nav-item" role="presentation"><a class="nav-link js-scroll-trigger" href="controller?command=passing_home">HOME</a></li>
            </ul>
        </div>
    </div>
</nav>
<header class="masthead" style="background-image:url('${pageContext.request.contextPath}/assets/img/header.jpg');">
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in"><span>Welcome To Our Shop!</span></div>
            <div class="intro-heading text-uppercase"><span>It's Nice To Meet You</span></div>
        </div>
    </div>
</header>
<section id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="text-uppercase">About</h2>
                <h3 class="text-muted section-subheading">Don’t dream it. Drive it!</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-group timeline">
                    <li class="list-group-item">
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${pageContext.request.contextPath}/assets/img/about/11.jpg"></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2010-2013</h4>
                                <h4 class="subheading">Our Humble Beginnings</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">Our luxury car store was opened in 2010 by two brothers, Jim and Alfred Sabinski, and has grown rapidly over the course of 3 years.</p>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item timeline-inverted">
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${pageContext.request.contextPath}/assets/img/about/22.jpg"></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2014-2016</h4>
                                <h4 class="subheading">Trade relations</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">Our store cooperates with such well-known automotive giants as BMW, Mercedes, Audi, Jaguar, Ford, Chevrolet, and others.</p>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${pageContext.request.contextPath}/assets/img/about/33.jpg"></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2017-2019</h4>
                                <h4 class="subheading">Incredible rise</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">During this period, our company has experienced an incredible increase in clients and then an incomprehensible financial rise.</p>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item timeline-inverted">
                        <div class="timeline-image"><img class="rounded-circle img-fluid" src="${pageContext.request.contextPath}/assets/img/about/44.jpg"></div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2020-Nowadays</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">Today we are expanding our client and trading partner base and growing rapidly internationally.</p>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item timeline-inverted">
                        <div class="timeline-image">
                            <h4>Be Part<br>&nbsp;Of Our<br>&nbsp;Story!</h4>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/agency.js"></script>
</body>

</html>