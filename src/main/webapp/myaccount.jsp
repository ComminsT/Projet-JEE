<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="description" content="" />
    <title>Junno – Multipurpose eCommerce HTML Template</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico" />

    <!--********************************** 
        all css files 
    *************************************-->

    <!--*************************************************** 
       fontawesome,bootstrap,plugins and main style css
     ***************************************************-->

    <link rel="stylesheet" href="assets/css/fontawesome.min.css" />
    <link rel="stylesheet" href="assets/css/ionicons.min.css" />
    <link rel="stylesheet" href="assets/css/simple-line-icons.css" />
    <link rel="stylesheet" href="assets/css/plugins/jquery-ui.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.css" />
    <link rel="stylesheet" href="assets/css/style.min.css" />

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->

    <!--**************************** 
         Minified  css 
    ****************************-->

    <!--*********************************************** 
       vendor min css,plugins min css,style min css
     ***********************************************-->
    <!-- <link rel="stylesheet" href="assets/css/vendor/vendor.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css" />
    <link rel="stylesheet" href="assets/css/style.min.css" /> -->
</head>

<body>
    
<jsp:include page="Header"/>
<!-- breadcrumb-section start -->
<nav class="breadcrumb-section theme1 bg-lighten2 pt-30 pb-30">
    <div class="container">
        <div class="row">
            <div class="col-12">
               
            </div>
            <div class="col-12">
                <ol class="breadcrumb bg-transparent m-0 p-0 align-items-center justify-content-right">
                    <li class="breadcrumb-item"><a href="Index">Accueil</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Mon compte</li>
                </ol>
            </div>
        </div>
    </div>
</nav>
<!-- breadcrumb-section end -->
<!-- product tab start -->

<div class="my-account pt-80 pb-50">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h3 class="title text-capitalize mb-30 pb-25">my account</h3>
            </div>
            <!-- My Account Tab Menu Start -->
            <div class="col-lg-3 col-12 mb-30">
                <div class="myaccount-tab-menu nav" role="tablist">
                    <a href="#dashboad" data-toggle="tab" class="active"><i class="fas fa-tachometer-alt"></i>
                        Dashboard</a>

                    <a href="#orders" data-toggle="tab"><i class="fa fa-cart-arrow-down"></i>
                        Commandes</a>
                        <a href="#wishlist" data-toggle="tab"><i class="fas fa-heart"></i>
                            Liste d'envie</a>

                    
                    <a href="#address-edit" data-toggle="tab"><i class="fa fa-map-marker"></i>
                        Adresse</a>

                    <a href="#account-info" data-toggle="tab" ><i class="fa fa-user"></i> 
                        Mes informations</a>

                    <a href="login.html"><i class="fa fa-sign-out-alt"></i> Déconnexion</a>
                </div>
            </div>
            <!-- My Account Tab Menu End -->

            <!-- My Account Tab Content Start -->
            <div class="col-lg-9 col-12 mb-30">
                <div class="tab-content" id="myaccountContent">
                    <!-- Single Tab Content Start -->
                    <div class="tab-pane fade active show" id="dashboad" role="tabpanel">
                        <div class="myaccount-content">
                            <h3>Dashboard</h3>

                            <div class="welcome mb-20">
                                <p>Hello, <strong>Alex Tuntuni</strong> (If Not <strong>Tuntuni !</strong><a
                                        href="login-register.html" class="logout"> Logout</a>)</p>
                            </div>

                            <p class="mb-0">From your account dashboard. you can easily check &amp; view your
                                recent orders, manage your shipping and billing addresses and edit your
                                password and account details.</p>
                        </div>
                    </div>
                    <!-- Single Tab Content End -->
                    <!-- Single Tab Content Start -->
                    <div class="tab-pane fade" id="wishlist" role="tabpanel">
                        <div class="myaccount-content">
                            <!-- product tab start -->
<section class="whish-list-section theme1 pb-80">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h3>Liste d'envie</h3>
                <div class="table-responsive">
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th> </th>
                                <th class="text-center" scope="col">Nom de l'article</th>
                                <th class="text-center" scope="col">Stock </th>
                                <th class="text-center" scope="col">Quantite</th>
                                <th class="text-center" scope="col">Prix</th>
                                <th ></th>
                                <th class="text-center" scope="col">Acheter</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="text-center" scope="row">
                                    <img src="assets/img/product/2.jpg" alt="img">
                                </th>
                                <td class="text-center">
                                    <span class="whish-title">Water and Wind Resistant</span>
                                </td>
                                <td class="text-center">
                                    <span class="badge badge-danger position-static">en stock</span>
                                </td>
                                <td class="text-center">
                                    <div class="product-count style">
                                        <div class="count d-flex justify-content-center">
                                            <input type="number" min="1" max="10" step="1" value="1">
                                            <div class="button-group">
                                                <button class="count-btn increment"><i
                                                        class="fas fa-chevron-up"></i></button>
                                                <button class="count-btn decrement"><i
                                                        class="fas fa-chevron-down"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td class="text-center">
                                    <span class="whish-list-price">
                                        38.24€
                                    </span></td>

                                <td class="text-center">
                                    <a href="#"> <span class="trash"><i class="fas fa-trash-alt"></i> </span></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="btn theme-btn--dark1 btn--lg">Acheter</a>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-center" scope="row">
                                    <img src="assets/img/product/4.jpg" alt="img">
                                </th>
                                <td class="text-center">
                                    <span class="whish-title">Originals Kaval Windbreaker</span>
                                </td>
                                <td class="text-center">
                                    <span class="badge badge-danger position-static">In Stock</span>
                                </td>
                                <td class="text-center">
                                    <div class="product-count style">
                                        <div class="count d-flex justify-content-center">
                                            <input type="number" min="1" max="10" step="1" value="1">
                                            <div class="button-group">
                                                <button class="count-btn increment"><i
                                                        class="fas fa-chevron-up"></i></button>
                                                <button class="count-btn decrement"><i
                                                        class="fas fa-chevron-down"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td class="text-center">
                                    <span class="whish-list-price">
                                        $38.24
                                    </span>
                                </td>

                                <td class="text-center">
                                    <a href="#"> <span class="trash"><i class="fas fa-trash-alt"></i> </span></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="btn theme-btn--dark1 btn--lg">buy now</a>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-center" scope="row">
                                    <img src="assets/img/product/6.jpg" alt="img">

                                </th>
                                <td class="text-center">
                                    <span class="whish-title">New Balance Arishi</span>
                                </td>
                                <td class="text-center">
                                    <span class="badge badge-danger position-static">In Stock</span>
                                </td>
                                <td class="text-center">
                                    <div class="product-count style">
                                        <div class="count d-flex justify-content-center">
                                            <input type="number" min="1" max="10" step="1" value="1">
                                            <div class="button-group">
                                                <button class="count-btn increment"><i
                                                        class="fas fa-chevron-up"></i></button>
                                                <button class="count-btn decrement"><i
                                                        class="fas fa-chevron-down"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td class="text-center">
                                    <span class="whish-list-price">
                                        $38.24
                                    </span></td>

                                <td class="text-center">
                                    <a href="#"> <span class="trash"><i class="fas fa-trash-alt"></i> </span></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="btn theme-btn--dark1 btn--lg">buy now</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product tab end -->
                        </div>
                    </div>
                    <!-- Single Tab Content End -->

                    <!-- Single Tab Content Start -->
                    <div class="tab-pane fade" id="orders" role="tabpanel">
                        <div class="myaccount-content">
                            <h3>Historique des commandes</h3>

                            <div class="myaccount-table table-responsive text-center">
                                <table class="table table-bordered">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>No</th>
                                            <th>Référence</th>
                                            <th>Date</th>
                                            <th>État</th>
                                            <th>Total</th>
                                           <th></th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>2462426</td>
                                            <td>Aug 22, 2018</td>
                                            <td>En cours</td>
                                            <td>$45</td>
                                            <td><a href="shopping-cart.html" class="ht-btn white-btn">Détail</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Single Tab Content End -->

                    <!-- Single Tab Content Start -->
                    <div class="tab-pane fade" id="download" role="tabpanel">
                        <div class="myaccount-content">
                            <h3>Downloads</h3>

                            <div class="myaccount-table table-responsive text-center">
                                <table class="table table-bordered">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>Product</th>
                                            <th>Date</th>
                                            <th>Expire</th>
                                            <th>Download</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <tr>
                                            <td>Mostarizing Oil</td>
                                            <td>Aug 22, 2018</td>
                                            <td>Yes</td>
                                            <td><a href="#" class="ht-btn black-btn">Download File</a></td>
                                        </tr>
                                        <tr>
                                            <td>Katopeno Altuni</td>
                                            <td>Sep 12, 2018</td>
                                            <td>Never</td>
                                            <td><a href="#" class="ht-btn black-btn">Download File</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Single Tab Content End -->

                    <!-- Single Tab Content Start -->
                    
                    <!-- Single Tab Content End -->

                    <!-- Single Tab Content Start -->
                    <div class="tab-pane fade" id="address-edit" role="tabpanel">
                        <div class="myaccount-content">
                            <h3>Adresse de facturation</h3>

                            <address>
                                <p><strong>Alex Tuntuni</strong></p>
                                <p>1355 Market St, Suite 900 <br>
                                    San Francisco, CA 94103</p>
                                <p>Mobile: (123) 456-7890</p>
                            </address>

                            <a href="#" class="ht-btn black-btn d-inline-block edit-address-btn"><i
                                    class="fa fa-edit"></i>Modifier mon adresse</a>
                        </div>
                    </div>
                    <!-- Single Tab Content End -->

                    <!-- Single Tab Content Start -->
                    <div class="tab-pane fade " id="account-info" role="tabpanel">
                        <div class="myaccount-content">
                            <h3>Vos informations personnelles</h3>

                            <div class="account-details-form">
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-6 col-12 mb-30">
                                            <input id="first-name" placeholder="Prénom" type="text">
                                        </div>

                                        <div class="col-lg-6 col-12 mb-30">
                                            <input id="last-name" placeholder="Nom" type="text">
                                        </div>

                                        <div class="col-12 mb-30">
                                            <input id="email" placeholder="Adresse e-mail" type="email">
                                        </div>

                                        <div class="col-12 mb-30">
                                            <h3>Changement de mot de passe</h3>
                                        </div>

                                        <div class="col-12 mb-30">
                                            <input id="current-pwd" placeholder="Mot de passe actuel" type="password">
                                        </div>

                                        <div class="col-lg-6 col-12 mb-30">
                                            <input id="new-pwd" placeholder="Nouveau mot de passe" type="password">
                                        </div>

                                        <div class="col-lg-6 col-12 mb-30">
                                            <input id="confirm-pwd" placeholder="Confirmez le nouveau mot de passe" type="password">
                                        </div>

                                        <div class="col-12">
                                            <button class="btn theme-btn--dark1 btn--md">Sauvegarder les modifications</button>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Single Tab Content End -->
                </div>
            </div>
            <!-- My Account Tab Content End -->
        </div>
    </div>
</div>
<!-- product tab end -->
<!-- footer strat -->
<footer class="bg-light theme1 position-relative">
    <!-- footer bottom start -->
    <div class="footer-bottom pt-80 pb-30">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-4 mb-30">
                    <div class="footer-widget mx-w-400">
                        <div class="footer-logo mb-35">
                            <a href="index.html">
                                <img src="assets/img/logo/logo-dark.jpg" alt="footer logo">
                            </a>
                        </div>
                        <p class="text mb-30">We are a team of designers and developers that create high quality
                            Magento, Prestashop, Opencart.</p>
                        <div class="address-widget mb-30">
                            <div class="media">
                                <span class="address-icon mr-3">
                                    <img src="assets/img/icon/phone.png" alt="phone">
                                </span>
                                <div class="media-body">
                                    <p class="help-text text-uppercase">NEED HELP?</p>
                                    <h4 class="title text-dark"><a href="tel:+1(123)8889999">(+800) 345 678</a></h4>
                                </div>
                            </div>
                        </div>

                        <div class="social-network">
                            <ul class="d-flex">
                                <li><a href="https://www.facebook.com/" target="_blank"><span
                                            class="icon-social-facebook"></span></a></li>
                                <li><a href="https://twitter.com/" target="_blank"><span
                                            class="icon-social-twitter"></span></a></li>
                                <li><a href="https://www.youtube.com/" target="_blank"><span
                                            class="icon-social-youtube"></span></a></li>
                                <li class="mr-0"><a href="https://www.instagram.com/" target="_blank"><span
                                            class="icon-social-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-2 mb-30">
                    <div class="footer-widget">
                        <div class="border-bottom cbb1 mb-25">
                            <div class="section-title pb-20">
                                <h2 class="title text-dark text-uppercase">Information</h2>
                            </div>
                        </div>
                        <!-- footer-menu start -->
                        <ul class="footer-menu">
                            <li><a href="#">Delivery</a></li>
                            <li><a href="about-us.html">About us</a></li>
                            <li><a href="#">Secure payment</a></li>
                            <li><a href="contact.html">Contact us</a></li>
                            <li><a href="#">Sitemap</a></li>
                            <li><a href="#">Stores</a></li>
                        </ul>
                        <!-- footer-menu end -->
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-2 mb-30">
                    <div class="footer-widget">
                        <div class="border-bottom cbb1 mb-25">
                            <div class="section-title pb-20">
                                <h2 class="title text-dark text-uppercase">Custom Links</h2>
                            </div>
                        </div>
                        <!-- footer-menu start -->
                        <ul class="footer-menu">
                            <li><a href="#">Legal Notice</a></li>
                            <li><a href="#">Prices drop</a></li>

                            <li><a href="#">New products</a></li>

                            <li><a href="#">Best sales</a></li>

                            <li><a href="login.html">Login</a></li>

                            <li><a href="myaccount.html">My account</a></li>
                        </ul>
                        <!-- footer-menu end -->
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4 mb-30">
                    <div class="footer-widget">
                        <div class="border-bottom cbb1 mb-25">
                            <div class="section-title pb-20">
                                <h2 class="title text-dark text-uppercase">Newsletter</h2>
                            </div>
                        </div>
                        <p class="text mb-20">You may unsubscribe at any moment. For that purpose, please find our
                            contact info in the legal notice.</p>
                        <div class="nletter-form mb-35">
                            <form class="form-inline position-relative"
                                action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef"
                                target="_blank" method="post">
                                <input class="form-control" type="text" placeholder="Your email address">
                                <button class="btn nletter-btn text-capitalize" type="submit">Sign
                                    up</button>
                            </form>
                        </div>

                        <div class="store d-flex">
                            <a href="https://www.apple.com/" class="d-inline-block mr-3"><img
                                    src="assets/img/icon/apple.png" alt="apple icon"> </a>
                            <a href="https://play.google.com/store/" class="d-inline-block"><img
                                    src="assets/img/icon/play.png" alt="apple icon"> </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer bottom end -->
    <!-- coppy-right start -->
    <div class="coppy-right pb-80">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="text-left">
                        <p class="mb-3 mb-md-0">Copyright &copy; <a href="https://hasthemes.com/">HasThemes</a>. All
                            Rights Reserved</p>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-8">
                    <div class="text-left">
                        <img src="assets/img/payment/1.png" alt="img">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- coppy-right end -->
</footer>
<!-- footer end -->



    <!--*********************** 
        all js files
     ***********************-->

    <!--****************************************************** 
        jquery,modernizr ,poppe,bootstrap,plugins and main js
     ******************************************************-->

    <script src="assets/js/vendor/jquery-3.5.1.min.js"></script>
    <script src="assets/js/vendor/modernizr-3.7.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins/jquery-ui.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/plugins/plugins.js"></script>
    <script src="assets/js/main.js"></script>

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->

    <!--*************************** 
          Minified  js 
     ***************************-->

    <!--*********************************** 
         vendor,plugins and main js
      ***********************************-->

    <!-- <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    <script src="assets/js/main.js"></script> -->


</body>

</html>