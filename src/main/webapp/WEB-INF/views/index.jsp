<%@ include file="header.jsp"%>
	<div class="container">
       	<div class="row">
       		<div class="col-sm-12">
       			<%@ include file="carousel.jsp"%>
       			<a href="./site" class="btn btn-primary" target="_blank">Plus d'info ></a>
       			<div class="row">
       				<c:forEach items="${sites}" var="element">
						<div class="card col-lg-4 col-sm-12 topoHome">
							<img src="./resources/image/LADE.png" width="200" height="300" class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">${element.name}</h5>
								<p class="card-text">
									Gummies cake gingerbread gingerbread sesame snaps brownie biscuit ice cream gingerbread. Danish danish tiramisu candy halvah
									liquorice donut fruitcake. 
								</p>
								<a href="./site?id=${element.id}" class="btn btn-primary" target="_blank">Plus d'info ></a>
							</div>
						</div>
			        </c:forEach>
			     </div>
       		</div>
       	</div>
	</div>
<%@ include file="footer.jsp"%>
