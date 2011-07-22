<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="centro"><!--INICIO CENTRO-->
	<div id="menu_logado">
		<c:if test="${usuarioWeb.logado }">
			<%@ include file="menu_logado.jsp" %>
		</c:if>				
	</div>
	<div id="banner">
		<img alt="banner" src="<c:url value="/images/banner.jpg" />" />
	</div>
	<div id="posts"><!--INICIO POSTS-->
		
		<c:forEach var="post" items="${posts }">
			<div class="post"><!--INICIO POST-->
				<h1 class="titulo"><a href="<c:url value="/posts/${post.id}" />">${post.titulo }</a></h1>
				<p class="post_info">Por: <a href="">${post.autor.nome }</a> 
					no dia ${post.created_at }</p>
					
					${post.corpo }
					
				<p class="continue_lendo">
					<a href="<c:url value="/posts/${post.id}" />">Continue Lendo&rarr;</a>
				</p>
				<br />
				<div class="tags_comentarios round"><!--INICIO TAGS-->
					<span class="tags">tags:
					<c:forEach var="tag" items="${post.tags }"> 
						<a href="<c:url value="/tags/${tag.id }"/>">${tag.nome }</a>
					</c:forEach>
					</span>
					<span class="comentarios">
						<a href="<c:url value="/posts/${post.id}" />#comments">
							${post.totalComentarios } comentário(s)
						</a>
					</span>
				</div><!--FIM TAGS-->
			</div><!--FIM POST-->
		</c:forEach>
		
	</div><!--FIM POSTS-->
	
</div><!--FIM CENTRO-->
<%@ include file="barra_lateral.jsp" %>
