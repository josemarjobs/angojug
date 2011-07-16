<%@ taglib uri="http://kindelbit.com/jgravatar" prefix="g"%>
<div class="comentarios">
	<!--INICIO COMENTATRIOS-->
	<h2 id="comments">
		Comentários [<a href="#" id="comentar">- form</a>]
	</h2>
	<c:forEach var="comentario" items="${postagem.comentarios }">

		<div class="comentario">
			<!--INICIO COMENTATRIO-->
			<div class="image">
				<!--INICIO IMAGE-->
				<g:gravatar email="${comentario.comentador.email }" size="200"
					defaultImage="mm" rating="g" />
			</div>
			<!--FIM IMAGE-->
			<div class="comentado">
				<!--INICIO COMENTADO-->
				<p class="dados">
					<a href="${comentario.site }"> ${comentario.comentador.nome }</a>
					comentou no dia ${comentario.created_at }
				</p>
				<p>${comentario.corpo }</p>
			</div>
			<!--FIM COMENTADO-->
		</div>
		<!--FIM COMENTATRIO-->
	</c:forEach>
	<div id="comentario_form">
		<!--INICIO COMENTATRIO FORM-->
		<form action="<c:url value="/posts/${postagem.id}/comentarios" />"
			method="post" id="formulario" accept-charset="utf-8">
			<div class="field" id="field_nome">
				<label for="nome">Nome*</label> <input type="text"
					name="comentario.comentador.nome"
					value="${comentario.comentador.nome }" id="nome" />
			</div>
			<div class="field" id="field_email">
				<label for="email">Email</label> <input type="text"
					name="comentario.comentador.email"
					value="${comentario.comentador.email }" id="email" /> <span
					class="info">Não será mostrado</span>
			</div>
			<div class="field" id="field_site">
				<label for="site">Web-Site</label> <input type="text"
					name="comentario.comentador.site"
					value="${comentario.comentador.site }" id="site" />
			</div>
			<div class="field" id="field_comentario">
				<label for="comentario">Comentário*</label>
				<textarea id="comentario" name="comentario.corpo" rows="8" cols="40">${comentario.corpo }</textarea>
			</div>
			<div class="button">
				<input type="submit" value="Comentar" />

			</div>
		</form>
	</div>
	<!--FIM COMENTATRIO FORM-->
</div>
<!--FIM COMENTATRIOS-->
<script type="text/javascript"
	src="<c:url value="/javascript/jquery-1.3.2.js" />"></script>
<script type="text/javascript">
	$(function() {//inicio document.ready
		$("#comentar").click(function(evt) {//inicio de comentario.click
			$("#comentario_form").slideToggle("slow", function() {//inicio de slideToggle
				if ($("#comentar").text() == "- form")
					$("#comentar").text("+ form");
				else
					$("#comentar").text("- form");
			});//fim de slideToggle
			evt.preventDefault();
		});//fim de comentario.click
		$("#formulario input:not(:eq(2))").bind("blur", validate);
		function validate() {//inicio validate
			var x = $(this);
			var div = "#field_" + x.attr("id");
			if (x.attr("value") == "") {
				var erro = $('<span class="error">O ' + x.attr("id")
						+ ' é obrigatório</span>');
				erro.css("opacity", "0.0");
				if ($(div + " .error").size() == 0) {
					$(div).append(erro);
					erro.animate({
						opacity : "1.0"
					}, 1000, "swing");
				}
			} else
				$(div + " span.error").fadeOut();
		}//fim de validate

		/*
		$("#formulario").submit(function(evt) {//inicio de form.submit
			evt.preventDefault();
			var form = $(this);
			var url = form.attr('action') + '/ajax';
			alert(url + " | sumiting: " + $(this).serialize());
			$.post(url, form.serialize(), callback);

			function callback(data) {
				alert("comentario adicionado, data: " + data);
			}
		});//fim de form.submit
		*/

	});//fim document.ready
</script>