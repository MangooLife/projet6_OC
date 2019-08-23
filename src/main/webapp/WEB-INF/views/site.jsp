<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>
				${site.name}
				<c:if test="${site.label == 1}">
					<i class="fas fa-check-circle"></i>
				</c:if>
			</h2>
			<div class="card mb-3" style="margin-top:10px;">
				<div class="row no-gutters">
					<c:if test="${element.image}">
						<div class="col-md-6">
							<img src="<c:url value="${site.image}"/>" class="img-thumbnail float-left" alt="...">
						</div>
					</c:if>
					<c:if test="${(empty element.image)}">
						<div class="col-md-6">
							<img src="<c:url value="/resources/image/LADE.png"/>"  
							width="200" height="300" class="card-img-top" alt="..." />
						</div>
					</c:if>
					<div class="col-md-6">
						<div class="card-body">
							<h3>${site.name}</h3>
							<p class="card-text">${site.description}</p>
						</div>
					</div>
					<div class="col-md-12">
						<div class="card-body">
							<h4>Les secteurs</h4>
							<ol>
								<c:forEach items="${secteurs}" var="element">
									<li>
										<p><b>${element.name}</b></p>
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">N°</th>
													<th scope="col">Voie</th>
													<th scope="col">Cotation</th>
													<th scope="col">Largeur (m)</th>
													<th scope="col">Longueurs</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${element.voies}" var="element2" varStatus="loop">
													<tr>
														<th scope="row"> 
															${loop.index + 1}
														</th>
														<td>
															${element2.name}
														</td>
														<td>
															${element2.cotation}
														</td>
														<td>
															${element2.width}
														</td>
														<td> 
															<c:choose>
																<c:when test="${!(empty element2.longueurs)}">
																	<div class="container">
																		<div class="row">
																			<div  class="col-sm-12 col-md-12 col-lg font-weight-bold">
																				Nom 
																			</div>
																			<div  class="col-sm-12 col-md-12 col-lg font-weight-bold">
																				Cotation
																			</div>
																			<div  class="col-sm-12 col-md-12 col-lg font-weight-bold">
																				Largeur (m)
																			</div>
																			<div  class="col-sm-12 col-md-12 col-lg font-weight-bold">
																				Nb spit
																			</div>
																		</div>
																		<c:forEach items="${element2.longueurs}" var="element3" varStatus="loop">	
																			<div class="row">
																				<div  class="col-sm-12 col-md-12 col-lg">
																					${element3.name}
																				</div>
																				<div  class="col-sm-12 col-md-12 col-lg">
																					${element3.cotation}
																				</div>
																				<div  class="col-sm-12 col-md-12 col-lg">
																					${element3.width}
																				</div>
																				<div  class="col-sm-12 col-md-12 col-lg">
																					${element3.spit}
																				</div>
																			</div>
																			<hr/>
																		</c:forEach>
																	</div>
																</c:when>
																<c:otherwise>
																	<p> Pas de longueurs </p>
																</c:otherwise>
															</c:choose>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</li>
								</c:forEach>
							</ol>
							<hr/>
							<p class="card-text">Site proposé par ${site.person.firstname}.</p>
						</div>
					</div>
				</div>
			</div>
			<h4 class="card-title">
				Les commentaires :
			</h4>
			<div class="card mb-3" style="margin-top:10px;">
				<div class="row no-gutters">
	        		<div class="card col-lg-12 col-sm-12">
						<div class="card-body">
							<c:choose>
								<c:when test="${!(empty comments)}">
									<c:forEach items="${comments}" var="element">
										<p class="card-text">
											<c:out value="${element.description}" />, par <i><c:out value="${element.person.username}"/></i> 
											- Le <c:out value="${element.publicationDate}" /> 
										</p>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<p>Aucun commentaire pour le moment, soyez le premier !</p>
								</c:otherwise>
							</c:choose>
							<hr/>
							<c:choose>
								<c:when test="${!(empty sessionScope.username)}">
									<form action="<c:url value="/addCommentSite/${site.person.id}/${site.id}" />"
										  method='POST'>
							    		<label for='comment'>Commentaire :</label>
							    		<textarea id='description' name='description' class="form-control" placeholder='Un commentaire ?' rows='3' cols='50' required ></textarea><br/>
							    		<input type='submit' value='Valider'/>
							    	</form>
								</c:when>
								<c:otherwise>
									<b>Veuillez vous connecter pour pouvoir ajouter un commentaire. Merci :)</b>
									<p><a href="<c:url value="/connexion"/>"> > Page de connexion</a></p>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>