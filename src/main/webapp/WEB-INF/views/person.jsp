<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h2>
					Bienvenue sur votre espace membre ${person.username} !
				</h2>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item">
						<a class="nav-link active" id="profil-tab" data-toggle="tab" href="#profil" 
							role="tab" aria-controls="profil" aria-selected="true">Profil</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="topos-tab" data-toggle="tab" href="#topos" 
							role="tab" aria-controls="topos" aria-selected="false">Topos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="sites-tab" data-toggle="tab" href="#sites" 
							role="tab" aria-controls="sites" aria-selected="false">Sites</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="comments-tab" data-toggle="tab" href="#comments" 
							role="tab" aria-controls="comments" aria-selected="false">Commentaires</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="profil" role="tabpanel" aria-labelledby="profil-tab">
						<div class="card mb-3" style="margin-top:10px;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="card-body">
										<h3 class="card-title">Vos informations personnelles :</h3>
										<ul>
											<li>Prénom : ${person.firstname}</li>
											<li>Nom : ${person.lastname}</li>
											<li>Login : ${person.username}</li>
											<li>Date de naissance : ${person.birthdate}</li>
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
										<h3 class="card-title">Vos topos :</h3>
										<ul>
											<c:choose>
												<c:when test="${!(empty topos)}">
													<c:forEach items="${topos}" var="element">
														<li>
															<a href=<c:url value="/topo/${element.id}"/> target="_blank">
																${element.name}
															</a>
														</li>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<li>Pas de topos pour le moment</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<%@ include file="newTopo.jsp"%>
					</div>
					<div class="tab-pane fade" id="sites" role="tabpanel" aria-labelledby="sites-tab">
						<div class="card mb-3" style="margin-top:10px;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="card-body">
										<h3 class="card-title">Vos sites :</h3>
										<ul>
											<c:choose>
												<c:when test="${!(empty topos)}">
													<c:forEach items="${topos}" var="element">
														<c:forEach items="${element.topoSites}" var="element2">
															<li>
																<a href="./site/${element2.id}" target="_blank">
																	${element2.name}
																</a>
															</li>
														</c:forEach>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<li>Pas de sites pour le moment</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<%@ include file="newSite.jsp"%>
					</div>
					<div class="tab-pane fade" id="comments" role="tabpanel" aria-labelledby="comments-tab">
						<div class="card mb-3" style="margin-top:10px;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="card-body">
										<h3 class="card-title">Vos commentaires :</h3>
										<ul>
											<c:choose>
												<c:when test="${!(empty comments)}">
													<c:forEach items="${comments}" var="element">
														<li>
															<p>
																<c:out value="${element.description}" />, par <i><c:out value="${element.person.username}"/></i> 
																- Le <c:out value="${element.publicationDate}"/>
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
														</li>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<li>Pas de commentaires pour le moment</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>