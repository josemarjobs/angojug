<ul>
	<li><a href=" <c:url value="/posts/novo" /> ">Novo Post</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/perfil" />">Ver Dados de Registo</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/postagens" />">Ver Postagens</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/mensagens/nova" />">Enviar Mensagem</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/mensagens" />">Ver Mensagens</a></li><!--VISUALIZAR MENSAGENS, QUANDO EST� LOGADO-->
	<li><a href="/admin">Op��es de Admin</a></li><!--S� PARA ADMIN-->
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id }"/>" >Editar Meus Dados</a></li>
</ul>