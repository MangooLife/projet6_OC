<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>Réserver une topo</h2>
			<div class="wrapper">
				<div id="formContent">
					<c:if test="${!(empty message)}">
						<div class="alert alert-success" role="alert" style="margin: 5px;">
							${message}
						</div>
					</c:if>
					<!-- Login Form -->
					<form action="<c:url value="/bookingTopo/${sessionScope.username}" />"
						method='POST' enctype="multipart/form-data"
						content="text/html;charset=UTF-8">
						<c:choose>
							<c:when test="${empty sessionScope.username}">
								<div class="form-group form-control-sm" style="margin-bottom: 30px;">
								    <select class="form-control" id="topoList">
								    	<option>------</option>
								    </select>
								    <br/>
								</div>
								<div class="alert alert-info" role="alert" style="margin: 5px;">
									Veuillez vous connecter pour réserver une topo :)
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-group form-control-sm" style="margin-bottom: 30px;">
								    <select class="form-control" id="topoList" name="topoList" required>
								    	<option>------</option>
								   		<c:forEach items="${topos}" var="element">
								   			<c:if test="${element.status == 0}">
								   				<c:if test="${element.person.username != sessionScope.username}">
								   					<option value="${element.id}">${element.name}</option>
								   				</c:if>
								   			</c:if>
								   		</c:forEach>
								    </select>
								    <br/>
								</div>
								<input type="submit" class="fadeIn fourth" value="Réserver">
							</c:otherwise>
						</c:choose>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>