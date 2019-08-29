<div class="modal fade" id="addLongueur" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ajouter une longueur</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<c:url value="/addLongueur" />"
					  method='POST' content="text/html;charset=UTF-8">
					<div class="form-group form-control-sm">
					    <select class="form-control" id="longueurVoie"  name="longueurVoie" required>
					   		<c:forEach items="${sites}" var="element">
					   			<c:forEach items="${element.secteurs}" var="element2">
						   			<c:forEach items="${element2.voies}" var="element3">
						   				<option value="${element3.id}">${element3.name}</option>
						   			</c:forEach>
					   			</c:forEach>
					   		</c:forEach>
					    </select>
					</div>
					<input type="text" id="longueurName" class="fadeIn second" name="longueurName" placeholder="Nom de la longueur" required />
					<input type="text" id="longueurSpit" class="fadeIn second" name="longueurSpit" placeholder="Nombre de spit" required />
					<input type="text" id="longueurCotation" class="fadeIn second" name="longueurCotation" placeholder="Cotation(s)..." required />
					<input type="number" id="longueurWidth" class="fadeIn second" name="longueurWidth" placeholder="Largeur de la longueur" required />
					<input type="submit" value="Valider"/>
				</form>
			</div>
		</div>
	</div>
</div>
