<div id="opces_de_usuarios">
			<h1>O que fazer</h1>	
			<%@ include file="menu_lateral.jsp" %>
		</div>
		<div id="centro" class="perfil"><!--INICIO CENTRO-->
			<h1>angoJUG - Tudo sobre ${user.nome }</h1>
			<div id="dados"><!--INICIO DADOS-->
				<h3>Informações de Registo</h3>
				<div class="info_do_usuario">
					<span class="label">Nome:</span> <span class="dado">${user.nome }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">Email:</span> <span class="dado">${user.email }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">Web Site:</span> <span class="dado">${user.site }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">Yahoo Messenger:</span> <span class="dado">${user.yahooMessenger }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">MSN Messenger:</span> <span class="dado">${user.msnMessenger }</span>
				</div>
				
				<div class="info_do_usuario">
					<span class="label">Localização:</span> <span class="dado">${user.localizacao }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">Profissão:</span> <span class="dado">${user.profissao }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">Interesses:</span> <span class="dado">${user.interesses }</span>
				</div>
				<div class="info_do_usuario">
					<span class="label">Biografia Resumida:</span> 
					<span class="dado">
						${user.biografia }
					</span>
				</div>
				
				
			</div><!--FIM DADOS-->			
			<div id="avatar"><!--INICIO AVATAR-->
				<img src="images/logo.png" alt="avatar"/>
			</div><!--FIM AVATAR-->
			
		</div><!--FIM CENTRO-->