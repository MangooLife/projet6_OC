<%@ include file="header.jsp"%>
	<div class="container">
		<h2>
			Rechercher un site
		</h2>
		<div class="row">
			<div class="card mb-3 col-md-4 col-lg-4" style="margin:0px;padding:10px;">
				<div class="row no-gutters">
					<div class="col-md-12">
						<h3>
							Par nom (site ou secteur)
						</h3>
						<form action="<c:url value="/searchSitePerkeyword/" />"
							  method='POST' enctype="multipart/form-data"
							  content="text/html;charset=UTF-8">
							<input type="text" id="keyword" name="keyword" placeholder="Rechercher par nom">
				    		<input type="submit" value="Valider"/>
				    	</form>
					</div>
				</div>
			</div>
			<div class="card mb-3 col-md-4 col-lg-4" style="margin:0px;padding:10px;">
				<div class="row no-gutters">
					<div class="col-md-12">
						<h3>
							Par Voie
						</h3>
						<form action="<c:url value="/searchSiteByVoie" />"
							  method='POST' enctype="multipart/form-data"
							  content="text/html;charset=UTF-8">
							<label>Cotation</label>
				    		<select class="form-control" id="cotationVoie"  name="cotationVoie">
				    			<option>-----</option>
						   		<c:forEach items="${voies}" var="element">
						   			<option value="${element.cotation}">${element.cotation}</option>
						   		</c:forEach>
						    </select>
				    		OU <br/>
				    		<label>Largeur</label>
				    		<select class="form-control" id="widthVoie"  name="widthVoie">
						   		<option>-----</option>
						   		<c:forEach items="${voies}" var="element">
						   			<option value="${element.width}">${element.width}</option>
						   		</c:forEach>
						    </select>	  
				    		<br/>
				    		<input type="submit" value="Valider"/>
				    	</form>
					</div>
				</div>
			</div>
			<div class="card mb-3 col-md-4 col-lg-4" style="margin:0px;padding:10px;">
				<div class="row no-gutters">
					<div class="col-md-12">
						<h3>
							Par Longueur
						</h3>
						<form action="<c:url value="/searchSitePerLongueur" />"
							  method='POST' enctype="multipart/form-data"
							  content="text/html;charset=UTF-8">
				    		<label>Cotation</label>
				    		<select class="form-control" id="cotationLongueur"  name="cotationLongueur" required>
						   		<option>-----</option>
						   		<c:forEach items="${longueurs}" var="element">
						   			<option value="${element.cotation}">${element.cotation}</option>
						   		</c:forEach>
						    </select>
				    		OU <br/>
				    		<label>Largeur</label>
				    		<select class="form-control" id="widthLongueur"  name="widthLongueur" required>
						   		<option>-----</option>
						   		<c:forEach items="${longueurs}" var="element">
						   			<option value="${element.width}">${element.width}</option>
						   		</c:forEach>
						    </select>
						    OU <br/>
				    		<label>Nombre de spit</label>
				    		<select class="form-control" id="spitLongueur"  name="spitLongueur" required>
						   		<option>-----</option>
						   		<c:forEach items="${longueurs}" var="element">
						   			<option value="${element.spit}">${element.spit}</option>
						   		</c:forEach>
						    </select>	  
				    		<br/>
				    		<input type="submit" value="Valider"/>
				    	</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>