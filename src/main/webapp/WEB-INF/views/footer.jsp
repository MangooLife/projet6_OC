		<footer>
			<div class="footerContainer">
				<div class="row">
					<div class="col-lg-3 col-sm-12">
						<h3>
							Les amis de l'escalade
						</h3>
						<p>
							Site communautaire dédié à l'escalade.
						<p>
					</div>
					<div class="col-lg-3 col-sm-12">
						<h3>
							Informations
						</h3>
						 <ul>
							<li><a class="navbar-brand" href="<c:url value="/topos" />">Topos</a></li>
							<li><a class="navbar-brand" href="<c:url value="/sites" />">Sites</a></li>
							<li><a class="navbar-brand" href="<c:url value="/booking" />">Réserver</a></li>
							<li>
								<c:choose>
								    <c:when test="${sessionScope.username == null}">
								        <a class="navbar-brand" href="<c:url value="/connexion" />">Se connecter</a>
								    </c:when>    
								    <c:otherwise>
										<a class="navbar-brand" href="<c:url value="/deconnexion" />">Se déconnecter</a>
								    </c:otherwise>
								</c:choose>
							</li>
						</ul>
					</div>
					<div class="col-lg-3 col-sm-12">
						<h3>
							Nous contacter
						</h3>
						<p>
							<i class="far fa-envelope"></i>
							<a href="mailto:test@test.com" target="_blank">
								 lade@mail.com
							</a>
						<p>
					</div>
					<div class="col-lg-3 col-sm-12">
						<h3>
							Rejoignez nous également sur...
						</h3>
						 <ul>
							<li>
								<i class="fab fa-twitter-square"></i>
								<a href="https://twitter.com" target="_blank">
									Twitter
								</a>
							</li>
							<li>
								<i class="fab fa-instagram"></i>
								<a href="https://instagram.com" target="_blank">
									Instagram
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</footer>
		<script src="<c:url value="/resources/js/navBar.js" />"></script>
    </body>
</html>