<div class="card mb-3" style="margin-top:10px;">
	<div class="row no-gutters">
		<div class="col-md-12">
			<div class="card-body">
				<h3>
					Ajouter et "composer" un site :
				</h3>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addSite">
					Etape 1 : Ajouter un site +
				</button>
				<%@ include file="createSite.jsp"%>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addSecteur">
					Etape 2 : Ajouter un secteur +
				</button>
				<%@ include file="createSecteur.jsp"%>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addVoie">
					Etape 3 : Ajouter une voie +
				</button>
				<%@ include file="createVoie.jsp"%>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addLongueur">
					Etape 4 : Ajouter une longueur +
				</button>
				<%@ include file="createLongueur.jsp"%>
			</div>
		</div>
	</div>
</div>
