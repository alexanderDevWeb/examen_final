<%@include file="/templates/head.jsp"%>

Usuarios: ${usuarios}
<hr>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">¿ Estas seguro que deseas Eliminar ?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<a href="backoffice/materiales?id=${usuarios}&op=">
					<button type="button" class="btn btn-primary">Aceptar</button>
				</a>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="col-sm-6 offset-sm-3">
	<div class="form-group row">
		<a class="btn btn-outline-dark btn-lg" href="">Volver</a>
	</div>
	<form action="prueba2" method="post">
		<div class="form-group row">
			<label for="id" class="col-sm-2 col-form-label">Param1:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="id" readonly
					value="${usuarios}">
			</div>
		</div>
		<div class="form-group row">
			<label for="param2" class="col-sm-2 col-form-label">Param2:</label>
			<div class="col-sm-10">
				<input type="text" value="${usuarios}" class="form-control"
					name="param2" placeholder="Introduce el nombre del parametro">
			</div>
		</div>
		<div class="form-group row">
			<label for="param3" class="col-sm-2 col-form-label">Param3:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" value="" name="param2"
					placeholder="Introduce el parametro 3">
				<!-- 	      <span class="input-group-text">&euro;</span> -->
			</div>
		</div>

		<br>

		<c:if test="${true}">
			<div class="form-group row">
				<div class="col-sm-12">
					<input type="hidden" name="op" value="">
					<button type="submit" class="btn btn-primary btn-lg btn-block">Crear</button>
				</div>
			</div>
		</c:if>

		<c:if test="${true}">
		<div class="form-group row">
			<div class="col-sm-12">				
				<input type="hidden" name="op" value="">
				<button type="submit" class="btn btn-success btn-lg btn-block">Modificar</button>
						
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-danger btn-lg btn-block"
					data-toggle="modal" data-target="#exampleModal">Cuidado
				</button>				
			</div>
			</div>
		</c:if>
	</form>
	</div>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>