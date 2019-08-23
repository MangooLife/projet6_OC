<div class="card mb-3" style="margin-top:10px;">
	<div class="row no-gutters">
		<div class="col-md-12">
			<div class="card-body">
				<h3>
					Ajouter un site :
				</h3>
				<form action="<c:url value="/addTopo/${site.person.id}" />"
					  method='POST' content="text/html;charset=UTF-8">
					<input type="text" id="nameTopo" class="fadeIn second" name="nameTopo" placeholder="Nom du site" required>
		    		<textarea id="description" class="fadeIn second" name="description"  placeholder="Description du site..."
		    				  rows="3" required ></textarea>
		    		<input type="file" id="imageTopo" class="fadeIn second" name="imageTopo" required>	  
		    		<br/>
		    		<input type="submit" value="Valider"/>
		    	</form>
			</div>
		</div>
	</div>
</div>