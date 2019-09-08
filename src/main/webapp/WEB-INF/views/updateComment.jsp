<div class="modal fade" id="updateComment${element.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modifier le commentaire</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<c:url value="/updateComment/${element.id}"/>"
				method='POST'>
					<div class="form-group">
					<label for='comment'>Commentaire :</label>
		    		<textarea id='description' name='description' class="form-control" rows='3' cols='50' required >
		    			<c:out value="${element.description}"/>
		    		</textarea><br/>
					</div>
					<input type='submit' value='Valider'/>
				</form>
			</div>
		</div>
	</div>
</div>