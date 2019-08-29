<div class="modal fade" id="addSecteur" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ajouter un secteur</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<c:url value="/addSecteur" />"
					  method='POST' content="text/html;charset=UTF-8">
					<div class="form-group form-control-sm">
					    <select class="form-control" id="secteurSite"  name="secteurSite" required>
					   		<c:forEach items="${sites}" var="element">
					   			<option value="${element.id}">${element.name}</option>
					   		</c:forEach>
					    </select>
					</div>
					<input type="text" id="secteurName" class="fadeIn second" name="secteurName" placeholder="Nom du secteur" required />
					<input type="submit" value="Valider"/>
				</form>
			</div>
		</div>
	</div>
</div>