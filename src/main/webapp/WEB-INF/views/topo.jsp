<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>
				${topo.name}
				<c:if test="${topo.status != 'Libre'}">
					<i class="fas fa-bookmark"></i>								
				</c:if>
			</h2>
			<div class="card mb-3" style="margin-top:10px;">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="<c:url value="${topo.image}"/>" class="card-img" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">${topo.name}</h5>
							<p class="card-text">${topo.description}</p>
							<p class="card-text">Topo proposée par ${topo.person.firstname}.</p>
							<p class="card-text"><small class="text-muted">Date de parution : ${topo.parutionDate}</small></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>