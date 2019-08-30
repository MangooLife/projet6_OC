<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<%@ include file="carousel.jsp"%>
			<div class="row">
				<c:choose>
					<c:when test="${sites != null}">
						<div class="col-md-12">
							<h4>
								Les sites
							</h4>
						</div>
		   				<c:forEach begin="0" end="2" items="${sites}" var="element">
							<div class="card col-lg-4 col-sm-12 topoHome">
								<c:choose>
									<c:when test="${!(empty element.image)}">
										<img src="<c:url value="${element.image}"/>"
										     width="200" height="300" class="card-img-top" alt="...">
									</c:when>
									<c:otherwise>
										<img src="<c:url value="/resources/image/LADE.png"/>"  
										     width="200" height="300" class="card-img-top" alt="..." />
									</c:otherwise>
								</c:choose>
								<div class="card-body">
									<h5 class="card-title">
										${element.name}
										<c:if test="${element.label == 1}">
											<i class="fas fa-check-circle"></i>
										</c:if>
									</h5>
									<p class="card-text">
										${element.description}
									</p>
									<a href="./site/${element.id}" class="btn btn-primary" target="_blank">Plus d'info ></a>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h2>Pas de sites pour le moment...</h2>
					</c:otherwise>
				</c:choose>
		    </div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
