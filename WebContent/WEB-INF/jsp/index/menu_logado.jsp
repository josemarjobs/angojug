<span> <a href="#" classe="close" id="fechar_menu"><img src="<c:url value="/images/close.png" />"/> </a></span>

<ul>
	<li><a href="<c:url value="/posts/novo" />">Postar</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id }/perfil" />">Meus dados</a></li>
	<li><a href="">Mensagens Privadas</a></li>
	<li><a href="<c:url value="/usuarios/${usuarioWeb.user.id}/postagens" />">Meus Posts</a></li>
	<li><a href="">Logout</a></li>
</ul>


<script type="text/javascript"
	src="<c:url value="/javascript/jquery-1.3.2.js" />"></script>
<script type="text/javascript">
	$(function() {//inicio document.ready
		$("#fechar_menu").click(function(evt) {
			$("#menu_logado").slideUp("slow");
		});
	});//fim document.ready
</script>