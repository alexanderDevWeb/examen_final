<%@include file="/templates/head.jsp" %>
<ul class="list-group">
	<c:forEach items="${usuarios}" var="usuario">	
		<li class="list-group-item">${usuario.id} - ${usuario.nombre}</li>					
	</c:forEach>
</ul>
<%@include file="/templates/footer.jsp" %>