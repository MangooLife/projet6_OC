<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head lang="fr">
	   <meta charset="utf-8" />
    	<meta name="viewport" content="width=device-width,initial-scale=1" />
		<link rel="icon" type="image/png" href="./resources/image/LADE.png" sizes="32x32" />
        <title>Les amis de l'escalade</title>
        <!-- Metadescription nécessaire au SEO -->
		<meta name="description" content="Les amis de l'escalade - Site communautaire autour de l'escalade">
		<!-- Opengraph -->
		<meta property="og:title" content="Les amis de l'escalade - Site communautaire autour de l'escalade" />
		<meta property="og:type" content="article" />
		<meta property="og:url" content="#" />
		<meta property="og:image" content="#" />
		<!-- Twitter card -->
		<meta name='twitter:card' content='summary_large_image' />
		<meta name='twitter:site' content='@LADE' />
		<meta name='twitter:creator' content='@LADE' />
		<meta name='twitter:title' content="Les amis de l'escalade" />
		<meta name='twitter:description' content="Site communautaire autour de l'escalade" />
		<meta name='twitter:image' content='#' />
		<!--******************************** Feuilles de style ********************************-->
		<!-- FontAwesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
		<!-- Bootstrap CSS et JS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 	 	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 	 	<!-- Style CSS -->
        <link href="./resources/css/style.css" rel="stylesheet" />
    </head>
    <body class="website">
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light" id="header">
				<a class="navbar-brand" href="./">
					<img src="./resources/image/LADE.png" width=150 height=150 alt="Les amis de l'escalade" id="imgHeader"/>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="./">Accueil</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./topos">Topos</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./sites">Sites</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./booking">Réserver</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./connexion">
								Se connecter
								<i class="fas fa-power-off off"></i>
							</a>
							
						</li>
					</ul>
					<form class="form-inline search">
						<input class="form-control mr-sm-2" type="search" placeholder="" aria-label="Search">
						<button class="btn" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</form>
				</div>
			</nav>
		</header>