<div class="card mb-3" style="margin-top:10px;">
	<div class="row no-gutters">
		<div class="col-md-12">
			<div class="card-body">
				<h3>
					Ajouter une topo :
				</h3>
				<form action="<c:url value="/addTopo/${person.id}/" />"
					  method='POST' enctype="multipart/form-data"
					  content="text/html;charset=UTF-8">
					<input type="text" id="topoName" class="fadeIn second" name="topoName" placeholder="Nom de la topo" required />
		    		<textarea id="description" class="fadeIn second" name="description"  placeholder="Description de la topo..."
		    				  rows="3" required ></textarea>
		    		<input type="file" id="topoImage" class="fadeIn second" name="topoImage">
		    		<br/>
		    		<c:forEach items="${person.sites}" var="element">
			    		<input type="checkbox" id="sites" name="sites" value="<c:out value="${element.id}" />">
	  					<label for="sites" />
	  						<c:out value="${element.name}" />
	  					</label>
		    		</c:forEach>	  
		    		<br/>
		    		<input type="submit" value="Valider"/>
		    	</form>
			</div>
		</div>
	</div>
</div>
