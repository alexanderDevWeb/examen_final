<%@include file="/templates/head.jsp" %>

<div class="container mt-3">
		<%@include file="/templates/alert.jsp"%>
    	<div class="col-sm-6 offset-sm-3">
	    <div id="login">
	        <h1 class="text-center">Login</h1>
	        <form class="form-signin" action="login" method="post">
	            <label for="usuario">Nombre Usuario</label>
	            <div class="form-label-group">
	                <input type="text" class="form-control" name="usuario" value="admin" placeholder="Nombre Usuario" required autofocus>
	            </div>
	            <div class="form-label-group">
	                <label for="password">Contraseña</label>
	                <input type="password" name="password" value="123456" class="form-control" placeholder="Contraseña" required>
	            </div>
	            <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Entrar</button>	           
	        </form>
	    </div>
		</div>		
    </div>
    <%@include file="/templates/footer.jsp" %>