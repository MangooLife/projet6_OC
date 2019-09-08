<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<c:choose>
					<c:when test="${sessionScope.member == 1}">
						<h2>
							Espace membre
						</h2>
						<c:if test="${!(empty message)}">
							<div class="alert alert-success" role="alert" style="margin: 5px;">
								${message}
							</div>
						</c:if>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item">
								<a class="nav-link ${classActiveLabel}" id="profil-tab" data-toggle="tab" href="#label"
									role="tab" aria-controls="label" aria-selected="false">Gérer les labels</a>
							</li>
							<li class="nav-item">
								<a class="nav-link ${classActiveComment}" id="comments-tab" data-toggle="tab" href="#comments"
									role="tab" aria-controls="comments" aria-selected="false">Gérer les commentaires</a>
							</li>
							<li class="nav-item">
								<a class="nav-link ${classActiveMember}" id="member-tab" data-toggle="tab" href="#member"
									role="tab" aria-controls="member" aria-selected="false">Gérer les membres</a>
							</li>
						</ul>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show ${classActiveLabel}" id="label" role="tabpanel" aria-labelledby="label-tab">
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
							<div class="tab-pane fade show ${classActiveComment}" id="comments" role="tabpanel" aria-labelledby="comments-tab">
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
																	data-toggle="modal" data-target="#updateComment${element.id}">
																		Modifier
																	</button>
																	<%@ include file="updateComment.jsp"%>
																</p>
																<c:if test="${empty element.topo}">
																	<a href="./site/${element.site.id}" target="_blank">
																		<b>Voir la topo</b>
																	</a>
																</c:if>
																<c:if test="${empty element.site}">
																	<a href="./topo/${element.topo.id}" target="_blank">
																		<b>Voir le site</b>
																	</a>
																</c:if>
																<hr/>
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
							<div class="tab-pane fade show ${classActiveMember}" id="member" role="tabpanel" aria-labelledby="member-tab">
								<div class="card mb-3" style="margin-top:10px;">
									<div class="row no-gutters">
										<div class="col-md-12">
											<div class="card-body">
												<h3 class="card-title">Les membres :</h3>
												<ul>
													<c:choose>
														<c:when test="${!(empty persons)}">
															<c:forEach items="${persons}" var="element" varStatus="loop">
																<c:if test="${!(sessionScope.username == element.username)}">
																	<li>
																			${element.firstname} ${element.lastname} - ${element.username}

																		<c:if test="${element.status == 1}">
																			<a href="<c:url value="./getMember/${element.id}/0"/>">
																				<button type="button" class="btn btn-danger">Membre -</button>
																			</a>
																		</c:if>
																		<c:if test="${element.status == 0}">
																			<a href="<c:url value="./getMember/${element.id}/1"/>">
																				<button type="button" class="btn btn-success">Membre +</button>
																			</a>
																		</c:if>
																	</li>
																</c:if>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<li>Pas de membre pour le moment :|</li>
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
							Oups ! Vous n'ï¿½tes pas autorisï¿½ ï¿½ cette partie du site
						</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>