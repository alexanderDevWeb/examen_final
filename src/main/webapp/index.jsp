<%@include file="/templates/head.jsp" %>
<div id="login">
${usuarios}
${nombre}
${password}
  <form class="form-signin" action="prueba" method="post">     
	<label for="usuario">Nombre Usuario</label>
      <div class="form-label-group">
        <input type="text" class="form-control"
               name="usuario" 
               value="administrador"
               placeholder="Nombre Usuario" 
               required autofocus>      
        
      </div>


      <div class="form-label-group">
        <label for="password">Contraseña</label>
        <input type="password" 
               name="password"
               value="123456" 
               class="form-control" 
               placeholder="Contraseña" required>
                              
    
      </div>
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>      
    </form>

</div>
<%@include file="/templates/footer.jsp" %>


<!-- RECORRER ARRAYS
	
<c:forEach items="${materiales}" var="material">	
	<pan>${material.precio > 5 && material.precio < 10}</span>
</c:forEach>



-------   SWITCH CASE   --------------

<c:choose>
	<c:when test="${material.precio > 6.0  && material.precio <= 25.0}">
		<li style="color:blue">
	</c:when>
	<c:when test="${material.precio > 25.0}">
		<li style="color:red">
	</c:when>
	<c:otherwise>
		<li>
	</c:otherwise>
</c:choose>








 -->

