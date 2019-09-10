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
							<div class=" table-responsive-sm table-responsive-md table-responsive-lg">
								<table class="table">
									<thead>
										<tr>
											<th scope="col">Nom</th>
											<th scope="col">Description</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${!(empty results)}">
												<c:forEach items="${results}" var="element">
													<tr>
														<th scope="row">
															<a href="<c:url value="/site/${element.secteur.site.id}" />">
													   			${element.secteur.site.name}
													   		</a>
														</th>
														<td>${element.secteur.site.description}</td>
													</tr>
											   	</c:forEach>
											</c:when>
											<c:when test="${!(empty sites) or !(empty secteurs)}">
												<c:forEach items="${sites}" var="element">
													<tr>
														<th scope="row">
															<a href="<c:url value="/site/${element.id}" />">
													   			${element.name}
													   		</a>
														</th>
														<td>${element.description}</td>
													</tr>
											   	</c:forEach>
											   	<c:forEach items="${secteurs}" var="element2">
													<tr>
														<th scope="row">
															<a href="<c:url value="/site/${element2.site.id}" />">
													   			${element2.site.name}
													   		</a>
														</th>
														<td>${element2.site.description}</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:when test="${!(empty resultsLongueur)}">
												<c:forEach items="${resultsLongueur}" var="element">
													<tr>
														<th scope="row">
													   		<a href="<c:url value="/site/${element.voie.secteur.site.id}" />">
													   			${element.voie.secteur.site.name}
													   		</a>
														</th>
														<td>${element.voie.secteur.site.description}</td>
													</tr>
											   	</c:forEach>
											</c:when>
											<c:otherwise>
												Pas de résultat...
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>