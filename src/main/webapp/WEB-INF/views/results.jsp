<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h2>
					Résultat
				</h2>
				<div class="card mb-3" style="padding:10px;">
					<div class="row no-gutters">
						<div class="col-md-12">
							<c:choose>
								<c:when test="${!(empty results)}">
									<c:forEach items="${results}" var="element">
								   		<a href="<c:url value="/site/${element.secteur.site.id}" />">
								   			${element.secteur.site.name}
								   		</a><hr/>
								   	</c:forEach>
								</c:when>
								<c:when test="${!(empty sites) or !(empty secteurs)}">
									<c:forEach items="${sites}" var="element">
								   		<a href="<c:url value="/site/${element.id}" />">
								   			${element.name}
								   		</a><hr/>
								   	</c:forEach>
									<c:forEach items="${secteurs}" var="element">
								   		<a href="<c:url value="/site/${element.site.id}" />">
								   			${element.site.name}
								   		</a><hr/>
								   	</c:forEach>
								</c:when>
								<c:when test="${!(empty resultsLongueur)}">
									<c:forEach items="${resultsLongueur}" var="element">
								   		<a href="<c:url value="/site/${element.voie.secteur.site.id}" />">
								   			${element.voie.secteur.site.name}
								   		</a><hr/>
								   	</c:forEach>
								</c:when>
								<c:otherwise>
									Pas de résultat...
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>