<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h2>Réserver une topo</h2>
			<div class="wrapper">
				<div id="formContent">
					<!-- Login Form -->
					<form>
						<input type="text" id="lastename" class="fadeIn second" name="login" placeholder="Nom" required disabled>
						<input type="text" id="firstname" class="fadeIn third" name="login" placeholder="Prénom" required disabled>
						<div class="form-group form-control-sm">
						    <select class="form-control" id="topoList">
						      <option>Sites 1</option>
						      <option>Sites 2</option>
						      <option>Sites 3</option>
						      <option>Sites 4</option>
						      <option>Sites 5</option>
						    </select>
						</div>
						<input type="submit" class="fadeIn fourth" value="Réserver">
					</form>
					
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>