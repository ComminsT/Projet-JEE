<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="models.Produit"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<meta name="description" content="" />
<title>Junno – Multipurpose eCommerce HTML Template</title>
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico" />

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
	<jsp:include page="Header"></jsp:include>
	<%
	ArrayList<Produit> prod = new ArrayList<Produit>();
	prod = (ArrayList) request.getAttribute("prods");
	%>

	<!-- breadcrumb-section start -->
	<nav class="breadcrumb-section theme1 bg-lighten2 pt-30 pb-30">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<ol
						class="breadcrumb bg-transparent m-0 p-0 align-items-center justify-content-left">
						<li class="breadcrumb-item"><a href="Index">Accueil</a></li>
						<li class="breadcrumb-item active" aria-current="page">
							${titre}</li>
					</ol>
				</div>
			</div>
		</div>
	</nav>
	<!-- breadcrumb-section end -->
	<!-- product tab start -->
	<div class="product-tab bg-white pt-80 pb-50">
		<div class="container">
			<div class="row">
				<div class="col-lg-9 mb-30">
					<div class="grid-nav-wraper bg-lighten2 mb-30">
						<div class="row align-items-center">
							<div class="col-12 col-md-6 mb-3 mb-md-0">
								<nav class="shop-grid-nav">
									<ul class="nav nav-pills align-items-center" id="pills-tab"
										role="tablist">
										<li class="nav-item"><a class="nav-link"
											id="pills-home-tab" data-toggle="pill" href="#pills-home"
											role="tab" aria-controls="pills-home" aria-selected="true">
												<i class="fa fa-th"></i>

										</a></li>
										<li class="nav-item mr-0"><a class="nav-link active"
											id="pills-profile-tab" data-toggle="pill"
											href="#pills-profile" role="tab"
											aria-controls="pills-profile" aria-selected="false"><i
												class="fa fa-list"></i></a></li>
										<li><span class="total-products text-capitalize">${maxitem}
												article trouvé</span></li>
									</ul>
								</nav>
							</div>
							<div class="col-12 col-md-6 position-relative">
								<div class="shop-grid-button d-flex align-items-center">
									<span class="sort-by">Trier par:</span>
									<button
										class="btn-dropdown rounded d-flex justify-content-between"
										type="button" id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										Relevance <span class="ion-android-arrow-dropdown"></span>
									</button>
									<div class="dropdown-menu shop-grid-menu"
										aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item" href="#">Popularité</a> <a
											class="dropdown-item" href="#"> Nom croissant</a> <a
											class="dropdown-item" href="#"> Nom décroissant</a> <a
											class="dropdown-item" href="#"> Prix croissant</a> <a
											class="dropdown-item" href="#"> Prix décroissant</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- product-tab-nav end -->
					<div class="tab-content" id="pills-tabContent">
						<!-- first tab-pane -->
						<div class="tab-pane fade" id="pills-home" role="tabpanel"
							aria-labelledby="pills-home-tab">
							<div class="row grid-view theme1">
								<%
								String titre = "";
								for (Produit p : prod) {
									titre = p.getTitre();
									if (titre.length() > 25) {
										titre = titre.substring(0, 25) + "...";
									}
								%>
								<div class="col-sm-6 col-lg-4 col-xl-3 mb-30">
									<div class="card product-card">
										<div class="card-body">
											<div class="product-thumbnail position-relative">

												<a href="Details?id=<%=p.getId()%>"> <img
													src="<%=p.getImg()%>" alt="thumbnail">
												</a>
												<!-- product links -->
												<ul class="product-links d-flex justify-content-center">
													<li><a href="wishlist.html"> <span
															data-toggle="tooltip" data-placement="bottom"
															title="add to wishlist" class="icon-heart"> </span>
													</a></li>
													<li><a href="#" data-toggle="modal"
														data-target="#quick-view"> <span data-toggle="tooltip"
															data-placement="bottom" title="Quick view"
															class="icon-magnifier"></span>
													</a></li>
												</ul>
												<!-- product links end-->
											</div>
											<div class="product-desc py-0">
												<h3 class="title">
													<a href="Details?id=<%=p.getId()%>"><%=titre%></a>
												</h3>
												<div
													class="d-flex align-items-center justify-content-between">
													<h6 class="product-price"><%=p.getPrix()%>
														€
													</h6>
													<form method="POST">
														<button name="badd" value="<%=p.getId() %>"class="pro-btn">
															<i class="icon-basket" ></i>
														</button>
													</form>
												</div>
											</div>
										</div>
									</div>
									<!-- product-list End -->
								</div>
								<%
								}
								%>

							</div>
						</div>
						<!-- second tab-pane -->
						<div class="tab-pane fade show active" id="pills-profile"
							role="tabpanel" aria-labelledby="pills-profile-tab">
							<div class="row grid-view-list theme1">
								<%
								titre = "";
								for (Produit p : prod) {
									titre = p.getTitre();
									if (titre.length() > 25) {
										titre = titre.substring(0, 25) + "...";
									}
								%>
								<div class="col-12 mb-30">
									<div class="card product-card">
										<div class="card-body">
											<div class="media flex-column flex-md-row">
												<div class="product-thumbnail position-relative">
													 <a
														href="Details?id=<%=p.getId()%>"> <img class="first-img"
														src="<%=p.getImg() %>" alt="thumbnail">
													</a>
													<!-- product links -->
													<ul class="product-links d-flex justify-content-center">
														
														<li><a href="#" data-toggle="modal"
															data-target="#quick-view"> <span
																data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>
													</ul>
													<!-- product links end-->
												</div>
												<div class="media-body pl-30">
													<div class="product-desc py-0">
														<h3 class="title">
															<a href="Details?id=<%=p.getId()%>"><%=titre %></a>
														</h3>
														
														<h6 class="product-price"><%=p.getPrix() %> €</h6>
													</div>
													<%=p.getDescriptionsm()%>
													<div class="availability-list mb-30">
														<p>
															Quantité en stock: <span><%= p.getQuantite()%></span>
														</p>
													</div>
													<form method="POST">
													<%if(p.getQuantite()>0){ %>
													<button name="badd" value="<%=p.getId() %>" class="btn theme-btn--dark1 btn--xl rounded-5"
														data-toggle="modal" data-target="#add-to-cart">
														Ajouter au panier</button>
														<%}else{%>
															<button disabled  class="btn theme-btn--dark1 btn--xl rounded-5"
																	data-toggle="modal" data-target="#add-to-cart">
																	Ajouter au panier</button>
														<%}%>
														</form>
												</div>
											</div>
										</div>
									</div>
									<!-- product-list End -->
								</div>
								<%} %>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<nav class="pagination-section mt-30">
								<div class="row align-items-center">
									<div class="col-12">
										<ul class="pagination justify-content-center">
											<%
											int max = (Integer) request.getAttribute("nbrdepage");
											int id_cat = (Integer) request.getAttribute("id_cat");
											int currentp = (Integer) request.getAttribute("currentp");
											%>
											<!-- Moins-->
											<%if(currentp!=1){ %>
											<li class="page-item"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp-1%>"><i
													class="ion-chevron-left"></i></a></li>
													<%} %>
											<!-- Retour page 1-->
											<li class="page-item <%if(currentp==1){%>active<%}%>"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=1">1</a></li>
											<%if(currentp>4){ %>
											<!-- ... -->
											<li class="page-item"><i class="bi bi-three-dots"></i>...</li>
											<%} %>
											<!-- Page actuelle - 2-->
											<%if(currentp>3){ %>
											<li class="page-item"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp-2%>"><%=currentp-2 %></a></li>
											<%} %>
											<!-- Page actuelle - 1-->
											<%if(currentp>2){ %>
											<li class="page-item"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp-1%>"><%=currentp-1 %></a></li>
											<%} %>
											<!-- Page actuelle-->
											<%if(currentp!=1 && currentp!=max){ %>
											<li class="page-item active"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp%>"><%=currentp %></a></li>
											<%} %>
											<!-- Page actuelle + 1-->
											<%if(currentp<max-1){ %>
											<li class="page-item"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp+1%>"><%=currentp+1 %></a></li>
											<%} %>
											<!-- Page actuelle + 2-->
											<%if(currentp<max-2){ %>
											<li class="page-item"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp+2%>"><%=currentp+2 %></a></li>
											<%} %>
											<!-- ... -->
											<%if(currentp<max-3){ %>
											<li class="page-item"><i class="bi bi-three-dots"></i>...</li>
											<%} %>
											<!-- Retour dernière page-->
											<li class="page-item <%if(currentp==max){%>active<%}%>"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=max%>"><%=max %></a></li>
											<!-- Plus-->
											<%if(currentp!=max){ %>
											<li class="page-item"> <a class="page-link" href="Produits?id=<%=id_cat%>&p=<%=currentp+1%>"><i
													class="ion-chevron-right"></i></a></li>
													<%} %>
										</ul>
									</div>
								</div>
							</nav>
						</div>
					</div>
				</div>
				<div class="col-lg-3 mb-30 order-lg-first">
					<aside class="left-sidebar theme1">
						<!-- search-filter start -->
						<div class="search-filter">
							<div class="check-box-inner pt-0">
								<h4 class="title">${titre}</h4>
							</div>

						</div>



						<div class="search-filter">
							<form action="#">

								<!-- check-box-inner -->
								<div class="check-box-inner mt-10">
									<h4 class="sub-title">Prix</h4>
									<div class="price-filter mt-10">
										<div class="price-slider-amount">
											<input type="text" id="amount" name="price" readonly
												placeholder="Add Your Price" />
										</div>
										<div id="slider-range"></div>
									</div>
								</div>

								<!-- check-box-inner -->

								<!-- check-box-inner -->
								<div class="check-box-inner mt-10">
									<h4 class="sub-title">Brand</h4>
									<div class="filter-check-box">
										<input type="checkbox" id="20824"> <label for="20824">Graphic
											Corner<span>(5)</span>
										</label>
									</div>
									<div class="filter-check-box">
										<input type="checkbox" id="20825"> <label for="20825">Studio
											Design<span>(8)</span>
										</label>
									</div>
								</div>
							</form>
						</div>
						<!-- search-filter end -->
						<div class="product-widget mb-60 mt-30">
							<h3 class="title">Product Tags</h3>
							<ul class="product-tag d-flex flex-wrap">
								<li><a href="#">shopping</a></li>
								<li><a href="#">New products</a></li>
								<li><a href="#">Accessories</a></li>
								<li><a href="#">sale</a></li>
							</ul>
						</div>
						<!--second banner start-->

						<!--second banner end-->
					</aside>
				</div>
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
								<a href="index.html"> <img
									src="assets/img/logo/logo-dark.jpg" alt="footer logo">
								</a>
							</div>
							<p class="text mb-30">We are a team of designers and
								developers that create high quality Magento, Prestashop,
								Opencart.</p>
							<div class="address-widget mb-30">
								<div class="media">
									<span class="address-icon mr-3"> <img
										src="assets/img/icon/phone.png" alt="phone">
									</span>
									<div class="media-body">
										<p class="help-text text-uppercase">NEED HELP?</p>
										<h4 class="title text-dark">
											<a href="tel:+1(123)8889999">(+800) 345 678</a>
										</h4>
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
									<li class="mr-0"><a href="https://www.instagram.com/"
										target="_blank"><span class="icon-social-instagram"></span></a></li>
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
							<p class="text mb-20">You may unsubscribe at any moment. For
								that purpose, please find our contact info in the legal notice.</p>
							<div class="nletter-form mb-35">
								<form class="form-inline position-relative"
									action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef"
									target="_blank" method="post">
									<input class="form-control" type="text"
										placeholder="Your email address">
									<button class="btn nletter-btn text-capitalize" type="submit">Sign
										up</button>
								</form>
							</div>

							<div class="store d-flex">
								<a href="https://www.apple.com/" class="d-inline-block mr-3"><img
									src="assets/img/icon/apple.png" alt="apple icon"> </a> <a
									href="https://play.google.com/store/" class="d-inline-block"><img
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
							<p class="mb-3 mb-md-0">
								Copyright &copy; <a href="https://hasthemes.com/">HasThemes</a>.
								All Rights Reserved
							</p>
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

	<!-- modals start -->
	<!-- first modal -->
	<div class="modal fade theme1 style1" id="quick-view" role="dialog">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-8 mx-auto col-lg-5 mb-5 mb-lg-0">
							<div class="product-sync-init mb-20">
								<div class="single-product">
									<div class="product-thumb">
										<img src="assets/img/slider/thumb/1.jpg" alt="product-thumb">
									</div>
								</div>
								<!-- single-product end -->
								<div class="single-product">
									<div class="product-thumb">
										<img src="assets/img/slider/thumb/2.jpg" alt="product-thumb">
									</div>
								</div>
								<!-- single-product end -->
								<div class="single-product">
									<div class="product-thumb">
										<img src="assets/img/slider/thumb/3.jpg" alt="product-thumb">
									</div>
								</div>
								<!-- single-product end -->
								<div class="single-product">
									<div class="product-thumb">
										<img src="assets/img/slider/thumb/4.jpg" alt="product-thumb">
									</div>
								</div>
								<!-- single-product end -->
							</div>

							<div class="product-sync-nav">
								<div class="single-product">
									<div class="product-thumb">
										<a href="javascript:void(0)"> <img
											src="assets/img/slider/thumb/1.1.jpg" alt="product-thumb"></a>
									</div>
								</div>
								<!-- single-product end -->
								<div class="single-product">
									<div class="product-thumb">
										<a href="javascript:void(0)"> <img
											src="assets/img/slider/thumb/2.1.jpg" alt="product-thumb"></a>
									</div>
								</div>
								<!-- single-product end -->
								<div class="single-product">
									<div class="product-thumb">
										<a href="javascript:void(0)"><img
											src="assets/img/slider/thumb/3.1.jpg" alt="product-thumb"></a>
									</div>
								</div>
								<!-- single-product end -->
								<div class="single-product">
									<div class="product-thumb">
										<a href="javascript:void(0)"><img
											src="assets/img/slider/thumb/4.1.jpg" alt="product-thumb"></a>
									</div>
								</div>
								<!-- single-product end -->
							</div>
						</div>
						<div class="col-lg-7 mt-5 mt-md-0">
							<div class="modal-product-info">
								<div class="product-head">
									<h2 class="title">New Balance Running Arishi trainers in
										tqsdriple</h2>
									<h4 class="sub-title">Reference: demo_5</h4>
								</div>
								<div class="product-body">
									<span class="product-price text-center"> <span
										class="new-price">$29.00</span>
									</span>
									<p>Break old records and make new goals in the New Balance®
										Arishi Sport v1.</p>
									<ul>
										<li>Predecessor: None.</li>
										<li>Support Type: Neutral.</li>
										<li>Cushioning: High energizing cushioning.</li>
									</ul>
								</div>
								<div class="d-flex mt-30"></div>
								<div class="product-footer">
									<div
										class="product-count style d-flex flex-column flex-sm-row my-4">
										<div class="count d-flex">
											<input type="number" min="1" max="10" step="1" value="1">
											<div class="button-group">
												<button class="count-btn increment">
													<i class="fas fa-chevron-up"></i>
												</button>
												<button class="count-btn decrement">
													<i class="fas fa-chevron-down"></i>
												</button>
											</div>
										</div>
										<div>
											<button
												class="btn theme-btn--dark1 btn--xl mt-5 mt-sm-0 rounded-5">
												<span class="mr-2"><i class="ion-android-add"></i></span>
												Ajouter au panier
											</button>
										</div>
									</div>
									<div class="addto-whish-list">
										<a href="#"><i class="icon-heart"></i> Add to wishlist</a> <a
											href="#"><i class="icon-shuffle"></i> Add to compare</a>
									</div>
									<div class="pro-social-links mt-10">
										<ul class="d-flex align-items-center">
											<li class="share">Share</li>
											<li><a href="#"><i class="ion-social-facebook"></i></a></li>
											<li><a href="#"><i class="ion-social-twitter"></i></a></li>
											<li><a href="#"><i class="ion-social-google"></i></a></li>
											<li><a href="#"><i class="ion-social-pinterest"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- second modal -->
	<div class="modal fade style2" id="compare" role="dialog">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h5 class="title">
						<i class="fa fa-check"></i> Product added to compare.
					</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- second modal -->
	<div class="modal fade style3" id="add-to-cart" role="dialog">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header justify-content-center bg-dark">
					<h5 class="modal-title" id="add-to-cartCenterTitle">
						<span class="ion-checkmark-round"></span> Product successfully
						added to your shopping cart
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-5 divide-right">
							<div class="row">
								<div class="col-md-6">
									<img src="assets/img/modal/1.jpg" alt="img">
								</div>
								<div class="col-md-6 mb-2 mb-md-0">
									<h4 class="product-name">New Balance Running Arishi
										trainers in triple</h4>
									<h5 class="price">$$29.00</h5>
									<h6 class="color">
										<strong>Dimension: </strong>: <span class="dmc">40x60cm</span>
									</h6>
									<h6 class="quantity">
										<strong>Quantity:</strong>&nbsp;1
									</h6>
								</div>
							</div>
						</div>
						<div class="col-lg-7">
							<div class="modal-cart-content">
								<p class="cart-products-count">There is 1 item in your cart.</p>
								<p>
									<strong>Total products:</strong>&nbsp;$123.72
								</p>
								<p>
									<strong>Total shipping:</strong>&nbsp;$7.00
								</p>
								<p>
									<strong>Taxes</strong>&nbsp;$0.00
								</p>
								<p>
									<strong>Total:</strong>&nbsp;$130.72 (tax excl.)
								</p>
								<div class="cart-content-btn">
									<button type="button" class="btn theme-btn--dark1 btn--md mt-4"
										data-dismiss="modal">Continue shopping</button>
									<button class="btn theme-btn--dark1 btn--md mt-4">
										<i class="ion-checkmark-round"></i>Proceed to checkout
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- modals end -->



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