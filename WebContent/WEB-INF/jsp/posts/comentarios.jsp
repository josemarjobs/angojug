<div class="comentarios"><!--INICIO COMENTATRIOS-->
	<h2 id="comments">Comentários</h2>
	<c:forEach var="comentario" items="${postagem.comentarios }">
	
		<div class="comentario"><!--INICIO COMENTATRIO-->
			<div class="image"><!--INICIO IMAGE-->
				<img src="images/angoJUG.png" alt="photo" />
			</div><!--FIM IMAGE-->
			<div class="comentado"><!--INICIO COMENTADO-->
				<p class="dados"><a href="${comentario.site }">
					${comentario.comentador.nome }</a> comentou no dia ${comentario.created_at }</p>
				<p>
					${comentario.corpo }
				</p>
			</div><!--FIM COMENTADO-->
		</div><!--FIM COMENTATRIO-->
	
	</c:forEach>

	<form action="<c:url value="/posts/${postagem.id}/comentarios" />" method="post" >
		<div class="field">
			<label for="nome">Nome*</label>
			<input type="text" name="comentario.comentador.nome" 
			value="${comentario.comentador.nome }" id="nome" />
		</div>
		<div class="field">
			<label for="email">Email</label>
			<input type="text" name="comentario.comentador.email" 
			value="${comentario.comentador.email }" id="email" />
			<span class="info">Não será mostrado</span>
		</div>
		<div class="field">
			<label for="site">Web-Site</label>
			<input type="text" name="comentario.comentador.site" 
			value="${comentario.comentador.site }" id="site" />
		</div>
		<div class="field">
			<label for="comentario">Comentário*</label>
			<textarea id="comentario" name="comentario.corpo" 
			rows="8" cols="40">${comentario.corpo }</textarea>
		</div>
		<div class="button">
			<input type="submit" value="Comentar" />
			
		</div>
	</form>
</div><!--FIM COMENTATRIOS-->