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
					
					<!-- Login Form -->
					<form>
						<input type="text" id="login" class="fadeIn second" name="login" placeholder="Mail" required>
						<input type="text" id="password" class="fadeIn third" name="login" placeholder="Mot de passe" required>
						<input type="submit" class="fadeIn fourth" value="Connexion">
					</form>
					
					<!-- Remind Passowrd -->
					<div id="formFooter">
						<a class="underlineHover" href="#">Mot de passe oublié ?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
	
