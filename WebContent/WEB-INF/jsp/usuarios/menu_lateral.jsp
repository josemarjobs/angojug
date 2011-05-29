<ul>
	<li><a href=" <c:url value="/posts/novo" /> ">Novo Post</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/perfil" />">Ver Dados de Registo</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/postagens" />">Ver Postagens</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/mensagens/nova" />">Enviar Mensagem</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/mensagens" />">Ver Mensagens</a></li><!--VISUALIZAR MENSAGENS, QUANDO ESTÁ LOGADO-->
	<li><a href="/admin">Opções de Admin</a></li><!--SÓ PARA ADMIN-->
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id }"/>" >Editar Meus Dados</a></li>
</ul>