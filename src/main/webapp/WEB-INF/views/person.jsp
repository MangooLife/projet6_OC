<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h2>
					Bienvenue sur votre espace personnel ${person.username} !
				</h2>
				<c:if test="${!(empty message)}">
					<div class="alert alert-success" role="alert" style="margin: 5px;">
						${message}
					</div>
				</c:if>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item">
						<a class="nav-link ${sessionScope.classActiveProfil}" id="profil-tab" data-toggle="tab" href="<c:url value="#profil"/>" 
							role="tab" aria-controls="profil" aria-selected="true">Profil</a>
					</li>
					<li class="nav-item">
						<a class="nav-link ${sessionScope.classActiveReservation}" id="reservation-tab" data-toggle="tab" href="<c:url value="#reservation"/>" 
							role="tab" aria-controls="reservation" aria-selected="false">Réservations</a>
					</li>
					<li class="nav-item">
						<a class="nav-link ${sessionScope.classActiveTopos}" id="topos-tab" data-toggle="tab" href="<c:url value="#topos"/>"
							role="tab" aria-controls="topos" aria-selected="false">Topos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link ${sessionScope.classActiveSitesPage}" id="sites-tab" data-toggle="tab" href="<c:url value="#sitesPage"/>" 
							role="tab" aria-controls="sitesPage" aria-selected="false">Sites</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="comments-tab" data-toggle="tab" href="<c:url value="#comments"/>" 
							role="tab" aria-controls="comments" aria-selected="false">Commentaires</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show ${sessionScope.classActiveProfil}" id="profil" role="tabpanel" aria-labelledby="profil-tab">
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
											<li>Email : ${person.email}</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade show ${sessionScope.classActiveReservation}" id="reservation" role="tabpanel" aria-labelledby="reservation-tab">
						<div class="card mb-3" style="margin-top:10px;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="card-body">
										<h3 class="card-title">Gérez les réservations:</h3>
										<ul>	
											<c:forEach items="${topos}" var="element">
												<c:choose>
													<c:when test="${!(empty element.booking)}">
														<div class=" table-responsive-sm table-responsive-md table-responsive-lg">
															<table class="table">
																<thead>
																	<tr>
																		<th scope="col">Topo</th>
																		<th scope="col">L'ami(e)</th>
																		<th scope="col">Email</th>
																		<th scope="col">Date</th>
																		<th scope="col">Accepter ?</th>
																	</tr>
																</thead>
																<tbody>
																<c:forEach items="${element.booking.bookingPerson}" var="element2">
																	<tr>
																		<th scope="row">
																			<a href=<c:url value="/topo/${element.id}"/> target="_blank">
																				${element.name}
																			</a>
																		</th>
																		<td>${element2.username}</td>
																		<td>${element2.email}</td>
																		<td>${element.booking.date}</td>
																		<td>
																			<c:choose>
																				<c:when test="${element.status == 0}">
																					<a href="<c:url value="/acceptBooking/${element.booking.id}"/>">
																						<button type="button" class="btn btn-success">Accepter</button>
																					</a>
																				</c:when>
																				<c:otherwise>
																					<a href="#">
																						<button type="button" class="btn btn-success" disabled>Accepter</button>
																					</a>
																				</c:otherwise>
																			</c:choose>
																		</td>
																	</tr>
																</c:forEach>
																</tbody>
															</table>
														</div>
													</c:when>
													<c:otherwise>
														<li>Pas de réservation pour la topo ${element.name}</li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:if test="${empty topos}">
												<li>Vous n'avez pas de topos pour le moment</li>
											</c:if>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade show ${sessionScope.classActiveTopos}" id="topos" role="tabpanel" aria-labelledby="topos-tab">
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
															<c:choose>
																<c:when test="${element.status == 1}">
																	<a href="<c:url value="/topoStatus/${element.id}"/>">
																		<button type="button" class="btn btn-success">Disponible</button>
																	</a>
																</c:when>
																<c:otherwise>
																	<a href="#">
																		<button type="button" class="btn btn-warn" disabled>Disponible</button>
																	</a>
																</c:otherwise>
															</c:choose>
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
					<div class="tab-pane fadeshow ${sessionScope.classActiveSitesPage}" id="sitesPage" role="tabpanel" aria-labelledby="sites-tab">
						<div class="card mb-3" style="margin-top:10px;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="card-body">
										<h3 class="card-title">Vos sites :</h3>
										<ul>
											<c:choose>
												<c:when test="${!(empty sites)}">
													<c:forEach items="${sites}" var="element">
														<li>
															<a href="./site/${element.id}" target="_blank">
																${element.name}
															</a>
														</li>
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
																<a href="./topo/${element.topo.id}" target="_blank">
																	<b>Voir le topo</b>
																</a>
															</c:if>
															<c:if test="${!empty element.site}">
																<a href="./site/${element.site.id}" target="_blank">
																	<b>Voir la site</b>
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