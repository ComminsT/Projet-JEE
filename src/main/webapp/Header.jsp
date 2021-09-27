<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="models.Categorie"%>
<%@page import="models.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Panier"%>
<%@page import="models.PanierDetails"%>

<!-- offcanvas-overlay start -->
<div class="offcanvas-overlay"></div>
<!-- offcanvas-overlay end -->
<!-- offcanvas-mobile-menu start -->
<div id="offcanvas-mobile-menu" class="offcanvas theme1 offcanvas-mobile-menu">
    <div class="inner">
        <div class="border-bottom mb-4 pb-4 text
        -right">
            <button class="offcanvas-close">×</button>
        </div>
        <div class="offcanvas-head mb-4">
            <nav class="offcanvas-top-nav">
                <ul class="d-flex justify-content-center align-items-center">
                </ul>
            </nav>
        </div>
        <nav class="offcanvas-menu">
            <ul>
                <li><a href="Index"><span class="menu-text">Accueil</span></a>
                    <%
                    ArrayList<Categorie> cats = new ArrayList<Categorie>();
                    cats = (ArrayList) request.getAttribute("categories");
                    for (Categorie cat : cats) {
                    %>
                    <li><a href="Produits?id=<%=cat.getId()%>&p=0"><%=cat.getTitre()%></a></li>
                    <%}%>
            </ul>
        </nav>
        
    </div>
</div>
<!-- offcanvas-mobile-menu end -->


<!-- OffCanvas Cart Start -->
<div id="offcanvas-cart" class="offcanvas offcanvas-cart theme1">
    <div class="inner">
        <div class="head d-flex flex-wrap justify-content-between">
            <span class="title">Panier</span>
            <button class="offcanvas-close">×</button>
        </div>
        <ul class="minicart-product-list">
         <% Panier paniers=(Panier)session.getAttribute("panier");
            							for(PanierDetails pa:paniers.articles){ 
            								%>
            <li>
                <a href="Details?id=<%= pa.getProduit().getId() %>" class="image"><img src="<%=pa.getProduit().getImg()%>"
                        alt="Cart product Image"></a>
                <div class="content">
                    <a href="single-product.html" class="title"><%=pa.getProduit().getTitre() %></a>
                    <span class="quantity-price">Quantité : <%=pa.getQte() %></span><span class="amount"><%=pa.getProduit().getPrix() %> €</span>
                    <a href="#" class="remove">×</a>
                </div>
            </li>
            <%}%>
            
            
        </ul>
        <div class="sub-total d-flex flex-wrap justify-content-between">
            <strong>Total :</strong>
            <span class="amount">${panier.total()}€</span>
        </div>
        <a href="cart.html" class="btn theme--btn-default btn--lg d-block d-sm-inline-block rounded-5 mr-sm-2">Voir le panier</a>
        <a href="checkout.html"
            class="btn theme-btn--dark1 btn--lg d-block d-sm-inline-block mt-4 mt-sm-0 rounded-5">Commander</a>
        <p class="minicart-message">Frais de port offert à 60€ d'achat </p>
    </div>
</div>
<!-- OffCanvas Cart End -->

<!-- header start -->
<header>
    <!-- header-middle satrt -->
    <div class="header-middle pt-20">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-sm-6 col-lg-2 order-first">
                    <div class="logo text-center text-sm-left mb-30 mb-sm-0">
                        <a href="index.html"><img src="assets/img/logo/logo-dark.jpg" alt="logo"></a>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-5 col-xl-4">
                    <!-- search-form end -->
                    <div class="d-flex align-items-center justify-content-center justify-content-sm-end">
                        <!-- static-media end -->
                        <div class="cart-block-links theme1">
                            <ul class="d-flex">
                            <%
							if ((boolean) session.getAttribute("isConnected") == false) {
							%>
                                <li>
                                    <a href="Login">
                                        <span class="position-relative">
                                            Connexion/Inscription
                                            
                                        </span>
                                    </a>
                                </li>
                                <%
							} else {
							%>
							<li>
							
							<span class="mr-0 cart-block position-relative">
							Bonjour ${usernom}
							</span>
							</li>
							<li>
							<a href="Deconnexion">
							<i class="icon-logout"></i></a>
							</li>
							
							<%} %>
                                <li class="mr-0 cart-block position-relative">
                                    <a class="offcanvas-toggle" href="#offcanvas-cart">
                                        <span class="position-relative">
                                            <i class="icon-bag"></i>
                                            <span class="badge cbdg1">${panier.count()}</span>
                                        </span>
                                    </a>
                                </li>
                                <!-- cart block end -->
                            </ul>
                        </div>
                        <div class="mobile-menu-toggle theme1 d-lg-none">
                            <a href="#offcanvas-mobile-menu" class="offcanvas-toggle">
                                <svg viewbox="0 0 800 600">
                                    <path
                                        d="M300,220 C300,220 520,220 540,220 C740,220 640,540 520,420 C440,340 300,200 300,200"
                                        id="top"></path>
                                    <path d="M300,320 L540,320" id="middle"></path>
                                    <path
                                        d="M300,210 C300,210 520,210 540,210 C740,210 640,530 520,410 C440,330 300,190 300,190"
                                        id="bottom" transform="translate(480, 320) scale(1, -1) translate(-480, -318)">
                                    </path>
                                </svg>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 col-xl-6 order-lg-first">
                    <div class="search-form pt-30 pt-lg-0">
                        <form class="form-inline position-relative">
                            <input class="form-control theme1-border" type="search"
                                placeholder="Rechercher un jeu">
                            <button class="btn search-btn theme-bg btn-rounded" type="submit"><i
                                    class="icon-magnifier"></i></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- header-middle end -->
    <!-- header bottom start -->
    <nav id="sticky" class="header-bottom theme1 d-none d-lg-block">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-10 offset-lg-2 d-flex flex-wrap align-items-center position-relative">
                    <ul class="main-menu d-flex">
                        <li class="ml-0">
                            <a href="Index" class="pl-0">Accueil</a>
                        </li>
                        <%
						for (Categorie cat : cats) {
						%>
                        <li class="ml-0">
                            <a href="Produits?id=<%=cat.getId()%>&p=1"><%=cat.getTitre()%></a>
                        </li>
						<%
						}
						%>
                    </ul>

                </div>
            </div>
        </div>
    </nav>
    <!-- header bottom end -->
    
    <!--=======  End of category menu =======-->
</header>
<!-- header end -->