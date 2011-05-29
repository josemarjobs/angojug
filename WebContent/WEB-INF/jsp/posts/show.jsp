<div id="centro"><!--INICIO CENTRO-->
	<div class="postagem"><!--INICIO POSTAGEM-->
		<h1 class="titulo">${postagem.titulo}</h1>
		<p class="post_info">Por: <a href="">${postagem.autor.nome }</a> 
		no dia ${postagem.created_at }</p>

		${postagem.corpo}		

		<br />
		<div class="tags_comentarios round"><!--INICIO TAGS-->
			<span class="tags">tags:
			<c:forEach var="tag" items="${postagem.tags }"> 
				<a href="<c:url value="/tags/${tag.id }"/>">${tag.nome }</a>
			</c:forEach>
			</span>
			<span class="comentarios"><a href="#comentarios">${postagem.totalComentarios } comentário(s)</a></span>
		</div><!--FIM TAGS-->
		
	</div><!--FIM POSTAGEM-->
	<br /><br />
	<!-- comentários, e o formulario pra novo comentario -->	
	<%@ include file="comentarios.jsp" %>
	
</div><!--FIM CENTRO-->


<%@ include file="../index/barra_lateral.jsp" %>