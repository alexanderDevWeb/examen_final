<%@include file="/templates/head.jsp"%>

<div class="container mt-3">
	<%@include file="/templates/alert.jsp"%>
	<div class="col-sm-6 offset-sm-3">
		<div class="form-group row">
			<a class="btn btn-outline-info btn-SM" href="">Atrás</a>
		</div>
		<h1 class="text-center">Codigo Postal</h1>
		<hr>
		<form action="codigos" method="post">
			<label for="usuario">Codigo Postal:</label>
            <div class="form-label-group">
                <input type="text" class="form-control" name="codigo" value="" placeholder="Codigo Postal" required autofocus>
            </div>			
			<button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Buscar</button>	
		</form>
		<c:if test="${alumno.length() > 1}">
			<hr>	
			<p class="text-center font-weight-bold">${alumno}</p>
		</c:if>
		<c:if test="${provincia.length() > 1}">
			<hr>	
			<p class="text-center font-weight-bold">${provincia}</p>
		</c:if>
	</div>
</div>



<jsp:include page="/templates/footer.jsp"></jsp:include>