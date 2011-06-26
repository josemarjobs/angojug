<div id="opces_de_usuarios">
	<h1>O que fazer</h1>	
	<%@ include file="menu_lateral.jsp" %>
</div>
<div id="centro" class="perfil"><!--INICIO CENTRO-->
	<h1>angoJUG - Meus Posts</h1>
	<div id="mensagens"><!--INICIAO MENSAGENS-->
		<table><!--INICIAO TABELA DE MENSAGENS-->
			<tr class="header">
				<th></th>
				<th>Titulo</th>
				<th>Data</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="post" items="${postagemList }" varStatus="i">
				<tr class="mensagem ${ i.count % 2 == 0 ? 'even' : 'odd' }">
					<td class="email"><img src="<c:url value="/images/mensagem.png" />" alt="mensagem lida" /></td>
					<td><a href="<c:url value="/posts/${post.id}" />">${post.titulo }</a></td>
					<td><a href="<c:url value="/posts/${post.id}" />">${post.created_at }</a></td>
					<td class="email">
						<a href="<c:url value="/posts/${post.id }/edit" />"><img src="<c:url value="/images/edit.png" />" class="postOption"  title="Editar Post" alt="editar post"/></a>
					</td>
					<td class="email">
						<form action="<c:url value="/posts/${post.id }" />" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="" title="eliminar post" class="delete_icon">
						</form>	
					</td>
				</tr>
			</c:forEach>
		</table><!--FIM TABELA DE MENSAGENS-->
		
	</div><!--FIM MENSAGENS-->
	
	<div id="legenda"><!--FIM LEGENDA-->
			<a href=""><span>&lt;&lt;</span></a>
			<a href=""><span>1</span></a>
			<a href=""><span>2</span></a>
			<a href=""><span>3</span></a>
			<a href=""><span>4</span></a>
			<a href=""><span>&gt;&gt;</span></a>
	</div><!--FIM LEGENDA-->
	
</div><!--FIM CENTRO-->