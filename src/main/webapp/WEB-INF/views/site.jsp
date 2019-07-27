<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>
				${site.name}
				<c:if test="${site.label}">
					<i class="fas fa-check-circle"></i>								
				</c:if>
			</h2>
			<div class="card mb-3" style="margin-top:10px;">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="<c:url value="${site.image}"/>" class="card-img" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">${site.name}</h5>
							<p class="card-text">${site.description}</p>
							<p class="card-text">Site proposé par ${site.person.firstname}.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>