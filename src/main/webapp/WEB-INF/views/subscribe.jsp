<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>Inscription</h2>
			<div class="wrapper fadeInDown">
				<div id="formContent">
					<c:if test="${!(empty message)}">
						<div class="alert alert-warning" role="alert" style="margin: 5px;">
							${message}
						</div>
					</c:if>
					<!-- Login Form -->
					<form action="<c:url value="/newPerson" />" method="post">
						<input type="text" id="firstname" name="firstname" placeholder="Prénom" required>
						<input type="text" id="lastname" name="lastname" placeholder="Nom" required>
						<input type="date" id="birthdate" name="birthdate" max="2009-12-31" min="1900-01-01" placeholder="Date de naissance aaaa-mm-jj" required>
						<input type="text" id="username" name="username" placeholder="Pseudo" required>
						<input type="email" id="email" name="email" placeholder="Email" required>
						<input type="password" id="password" name="password" placeholder="Mot de passe" required>
						<input type="submit" value="Go ! Devenir un(e) ami(e)">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
	
