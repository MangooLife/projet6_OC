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
 		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 	 	<!-- Style CSS -->
        <link href="./resources/css/style.css" rel="stylesheet" />
    </head>
    <body class="website">
		<%@ include file="header.jsp"%>
			<c:forEach items="${msgs}" var="element">
	            <div>
	            	${element.name}
	           	</div>
	        </c:forEach>
		<%@ include file="footer.jsp"%>
    </body>
</html>