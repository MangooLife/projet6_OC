<div class="modal fade" id="addVoie" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ajouter une voie</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<c:url value="/addVoie" />"
					  method='POST' content="text/html;charset=UTF-8">
					<div class="form-group form-control-sm">
					    <select class="form-control" id="voieSecteur"  name="voieSecteur" required>
					   		<c:forEach items="${sites}" var="element">
					   			<c:forEach items="${element.secteurs}" var="element2">
					   				<option value="${element2.id}">${element2.name}</option>
					   			</c:forEach>
					   		</c:forEach>
					    </select>
					</div>
					<input type="text" id="voieName" class="fadeIn second" name="voieName" placeholder="Nom de la voie" required />
					<input type="text" id="voieCotation" class="fadeIn second" name="voieCotation" placeholder="Cotation(s)..." required />
					<input type="number" id="voieWith" class="fadeIn second" name="voieWith" placeholder="Largeur de la voie" required />
					<input type="submit" value="Valider"/>
				</form>
			</div>
		</div>
	</div>
</div>