<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="card mb-3" style="margin-top:10px;">
			<c:choose>
				<c:when test="${!(empty sessionScope.username)}">
					<div class="col-sm-12">
						<h2>
							${topo.name}
							<c:if test="${topo.status != 'Libre'}">
								<i class="fas fa-bookmark"></i>								
							</c:if>
						</h2>
						
						<div class="row no-gutters">
							<div class="col-md-4">
								<img src="<c:url value="${topo.image}"/>" class="card-img" alt="...">
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
					<div class="card mb-3" style="margin-top:10px;">
						<div class="row no-gutters">
			        		<div class="card col-lg-12 col-sm-12">
								<div class="card-body">
									<h4 class="card-title">
										Les commentaires :
									</h4>
									<c:forEach items="${comments}" var="element">
										<p class="card-text">
											Le 10/07/2019 - ${element.description}, par <i>${element.person.username }</i>
										</p>
									</c:forEach>
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