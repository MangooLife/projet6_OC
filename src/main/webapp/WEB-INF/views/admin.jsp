<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<c:choose>
					<c:when test="${sessionScope.admin == 1}">
						<h2>
							Espace administrateur
						</h2>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item">
								<a class="nav-link active" id="profil-tab" data-toggle="tab" href="#profil" 
									role="tab" aria-controls="profil" aria-selected="true">Gérer les labels</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="topos-tab" data-toggle="tab" href="#topos" 
									role="tab" aria-controls="topos" aria-selected="false">Gérer les commentaires</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="sites-tab" data-toggle="tab" href="#sites" 
									role="tab" aria-controls="sites" aria-selected="false">Gérer les administrateurs</a>
							</li>
						</ul>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="profil" role="tabpanel" aria-labelledby="profil-tab">
								<div class="card mb-3" style="margin-top:10px;">
									<div class="row no-gutters">
										<div class="col-md-12">
											<div class="card-body">
												<h3 class="card-title">Sites :</h3>
												<ul>
													<c:choose>
														<c:when test="${!(empty sites)}">
															<c:forEach items="${sites}" var="element">
																<li>
																	<a href="<c:url value="./site/${element.id}"/>" target="_blank">
																		${element.name}
																	</a>
																	<c:if test="${element.label == 1}">
																		<a href="<c:url value="./getLabel/${element.id}/0"/>">
																			<button type="button" class="btn btn-danger">Label -</button>
																		</a>
																	</c:if>
																	<c:if test="${element.label  == 0}">
																		<a href="<c:url value="./getLabel/${element.id}/1"/>">
																			<button type="button" class="btn btn-success">Label +</button>
																		</a>
																	</c:if>
																</li>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<li>Pas de sites pour le moment :|</li>
														</c:otherwise>
													</c:choose>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="topos" role="tabpanel" aria-labelledby="topos-tab">
								<div class="card mb-3" style="margin-top:10px;">
									<div class="row no-gutters">
										<div class="col-md-12">
											<div class="card-body">
												<h3 class="card-title">Les commentaires :</h3>
												<ul>
													<c:choose>
														<c:when test="${!(empty comments)}">
															<c:forEach items="${comments}" var="element" varStatus="loop">
																<p>
																	<c:out value="${element.description}" />, par <i><c:out value="${element.person.username }"/></i> 
																	- Le <c:out value="${element.publicationDate}"/>
																	<a href="<c:url value="./deleteComment/${element.id}"/>">
																		<button type="button" class="btn btn-danger">Supprimer</button>
																	</a>
																	<button type="button" class="btn btn-warning"
																	data-toggle="modal" data-target="#updateComment">
																		Modifier
																	</button>
																</p>
																<c:if test="${!empty element.topo}">
																	<a href="./site/${element.topo.id}" target="_blank">
																		<b>Voir le site</b>
																	</a>
																</c:if>
																<c:if test="${!empty element.site}">
																	<a href="./topo/${element.site.id}" target="_blank">
																		<b>Voir la topo</b>
																	</a>
																</c:if>
																
																<%@ include file="updateComment.jsp"%>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<li>Pas de commentaires pour le moment :|</li>
														</c:otherwise>
													</c:choose>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="sites" role="tabpanel" aria-labelledby="sites-tab">
								<div class="card mb-3" style="margin-top:10px;">
									<div class="row no-gutters">
										<div class="col-md-12">
											<div class="card-body">
												<h3 class="card-title">Les administrateurs :</h3>
												<ul>
													<c:choose>
														<c:when test="${!(empty persons)}">
															<c:forEach items="${persons}" var="element" varStatus="loop">
																<li>
																	${element.firstname} ${element.lastname} - ${element.username}
																
																	<c:if test="${element.status == 1}">
																		<a href="<c:url value="./getAdmin/${element.id}/0"/>">
																			<button type="button" class="btn btn-danger">Admin -</button>
																		</a>
																	</c:if>
																	<c:if test="${element.status == 0}">
																		<a href="<c:url value="./getAdmin/${element.id}/1"/>">
																			<button type="button" class="btn btn-success">Admin +</button>
																		</a>
																	</c:if>
																</li>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<li>Pas d'admin pour le moment :|</li>
														</c:otherwise>
													</c:choose>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h2>
							Oups ! Vous n'êtes pas autorisé à cette partie du site
						</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>