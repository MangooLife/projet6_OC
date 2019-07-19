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
		<%@ include file="header.jsp"%>
	        <div class="container">
	        	<div class="row">
	        		<div class="col-sm-12">
	        			<div class="row">
	        				<c:out items="${sites}" var="element">
								<div class="card col-lg-4 col-sm-12 topoHome">
									<img src="./resources/image/LADE.png" width="200" height="300" class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">${element.name}</h5>
										<p class="card-text">
											Gummies cake gingerbread gingerbread sesame snaps brownie biscuit ice cream gingerbread. Danish danish tiramisu candy halvah
											liquorice donut fruitcake. 
										</p>
										<a href="./site?id=${element.id}" class="btn btn-primary" target="_blank">Plus d'info ></a>
									</div>
								</div>
					        </c:out>
					     </div>
	        		</div>
	        	</div>
	       	</div>
		<%@ include file="footer.jsp"%>
		<script src="./resources/js/navBar.js"></script>
    </body>
</html>