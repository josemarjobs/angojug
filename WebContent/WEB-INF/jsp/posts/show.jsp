<div id="centro"><!--INICIO CENTRO-->
	<div class="postagem"><!--INICIO POSTAGEM-->
		<h1>${postagem.titulo}</h1>
		${postagem.corpo}		

		<div class="tags_comentarios round"><!--INICIO TAGS-->
			<span class="tags">tags: 
				<a href="">java</a>, <a href="">php</a>, <a href="">ruby on rails</a>
			</span>
			<span class="comentarios"><a href="#comentarios">${postagem.totalComentarios } comentário(s)</a></span>
		</div><!--FIM TAGS-->
		
	</div><!--FIM POSTAGEM-->
	
	<!-- comentários, e o formulario pra novo comentario -->	
	<%@ include file="comentarios.jsp" %>
	
</div><!--FIM CENTRO-->


<%@ include file="../index/barra_lateral.jsp" %>