<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>Les topos</h2>
   			<div class="row">
   				<c:forEach items="${topos}" var="element">
					<div class="card col-lg-4 col-sm-12 topoHome">
						<img src="<c:url value="${element.image}"/>" width="200" height="300" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								${element.name}
								<c:if test="${element.status != 'Libre'}">
									<i class="fas fa-bookmark"></i>								
								</c:if>
							</h5>
							<p class="card-text">
								${element.description}
							</p>
							<a href="./topo/${element.id}" class="btn btn-primary" target="_blank">Plus d'info ></a>
						</div>
					</div>
        		</c:forEach>
		     </div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>