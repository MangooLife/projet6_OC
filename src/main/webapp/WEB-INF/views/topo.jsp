<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>
				${topo.name}
				<c:if test="${topo.status == 1}">
					<i class="fas fa-bookmark"></i>								
				</c:if>
			</h2>
			<c:if test="${!(empty message)}">
				<div class="alert alert-success" role="alert" style="margin: 5px;">
					${message}
				</div>
			</c:if>
			<c:choose>
				<c:when test="${!(empty sessionScope.username)}">
					<div class="card mb-3" style="margin-top:10px;">
						<div class="row no-gutters">
							<div class="col-md-4">
								<c:choose>
									<c:when test="${!(empty topo.image)}">
										<img src="<c:url value="${topo.image}"/>" class="card-img" alt="...">
									</c:when>
									<c:otherwise>
										<img src="<c:url value="/resources/image/LADE.png"/>"  
										     width="200" height="300" class="card-img-top" alt="..." />
									</c:otherwise>
								</c:choose>
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">${topo.name}</h5>
									<p class="card-text">${topo.description}</p>
									<table class="table table-hover">
										<thead>
											<tr>
												<th scope="col">N°</th>
												<th scope="col">Site</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${sites}" var="element" varStatus="loop">
												<tr>
													<th scope="row">
														${loop.index + 1}
													</th>
													<td>	
														<a href="<c:url value="/site/${element.id}"/>" 
														class="btn btn-primary">${element.name}</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<p class="card-text">Topo proposée par ${topo.person.firstname}.</p>
									<p class="card-text"><small class="text-muted">Date de parution : ${topo.parutionDate}</small></p>
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
													<c:out value="${element.description}" />, par <i><c:out value="${element.person.username }"/></i> 
													- Le <c:out value="${element.publicationDate}"/> 
													<c:if test="${(sessionScope.member == 1)}">
														<button type="button" class="btn btn-danger"
														data-toggle="modal" data-target="#deleteComment">
															Supprimer
														</button>
														<button type="button" class="btn btn-warning"
														data-toggle="modal" data-target="#updateComment${element.id}">
															Modifier
														</button>
														<div class="modal fade" id="deleteComment" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title" id="exampleModalLabel">Confirmer la suppression du commentaire</h5>
																		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																		</button>
																	</div>
																	<div class="modal-body">
																		<p> Voulez-vous vraiment supprimer le commentaire ?</p>
																		<form>
																			<a href="<c:url value="/deleteComment/${element.id}/topo"/>">
																				<button type="button" class="btn btn-danger">Supprimer</button>
																			</a>
																		</form>
																	</div>
																</div>
															</div>
														</div>
														<div class="modal fade" id="updateComment${element.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title" id="exampleModalLabel">Modifier le commentaire</h5>
																		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																		</button>
																	</div>
																	<div class="modal-body">
																		<form action="<c:url value="/updateComment/${element.id}/topo"/>"
																		method='POST'>
																			<div class="form-group">
																			<label for='comment'>Commentaire :</label>
																    		<textarea id='description' name='description' class="form-control" rows='3' cols='50' required >
																    			<c:out value="${element.description}"/>
																    		</textarea><br/>
																			</div>
																			<input type='submit' value='Valider'/>
																		</form>
																	</div>
																</div>
															</div>
														</div>
													</c:if>
													<hr/>
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
											<form action="<c:url value="/addCommentTopo/${topo.person.id}/${topo.id}" />"
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
				</c:when>
				<c:otherwise>
					<div class="col-sm-12">
						<h2>Veuillez vous connecter pour accèder à la topo. Merci :)</h2>
						<p><a href="<c:url value="/connexion"/>"> > Page de connexion</a></p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>