<div class="modal fade" id="addSite" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ajouter un site</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<c:url value="/addSite/${person.id}/" />"
					  method='POST' enctype="multipart/form-data"
					  content="text/html;charset=UTF-8">
					<input type="text" id="siteName" class="fadeIn second" name="siteName" placeholder="Nom du site" required />
		    		<textarea id="siteDescription" class="fadeIn second" name="siteDescription"  placeholder="Description du site..."
		    				  rows="3" required ></textarea>
		    		<input type="file" id="siteImage" class="fadeIn second" name="siteImage">
		    		<input type="submit" value="Valider"/>
		    	</form>
			</div>
		</div>
	</div>
</div>