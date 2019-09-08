<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>Connexion à l'espace membre</h2>
			<div class="wrapper fadeInDown">
				<div id="formContent">
					<!-- Icon -->
					<div class="fadeIn first">
						<img src="./resources/image/LADE.png" height="200" widht="200" id="icon" alt="User Icon" />
					</div>
					<c:if test="${!(empty message)}">
						<div class="alert alert-warning" role="alert" style="margin: 5px;">
							${message}
						</div>
					</c:if>
					<c:if test="${!(empty messageSuccess)}">
						<div class="alert alert-success" role="alert" style="margin: 5px;">
							${messageSuccess}
						</div>
					</c:if>
					<!-- login Form -->
					<form action="<c:url value="/authentificate" />" method="post" content="text/html;charset=UTF-8">
						<input type="text" id="username" class="fadeIn second" name="username" placeholder="Login" required>
						<input type="password" id="password" class="fadeIn third" name="password" placeholder="Mot de passe" required>
						<input type="submit" class="fadeIn fourth" value="Connexion">
					</form>
					
					<!-- Remind Passowrd -->
					<div id="formFooter">
						<a class="underlineHover" href="<c:url value="/subscribe" />">Devenir un(e) ami(e) de LADE ?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
	
