<div id="centro"><!--INICIO CENTRO-->
		
	<h1>angoJUG - Tudo sobre Josemar da Costa</h1>
	<div id="dados"><!--INICIO DADOS-->
		<h2>Informações de Registo</h2>
		<form action="<c:url value="/usuarios/${user.id }" />" method="post" >
			<div class="field">
				<label for="nome">Nome</label>
				<input type="text" name="user.nome" value="${user.nome }" id="nome" class="required"/>
				<span class="error">Preencha os campos com(*)</span>
			</div>
			<div class="field">
				<label for="email">Email</label>
				<input type="text" name="user.email" value="${user.email }" 
						id="email" class="required"/>
				<span class="info">Preencha com um email válido</span>
			</div>
			<div class="field">
				<label for="password">Password</label>
				<input type="password" name="user.password" value="${user.password }" 
						id="password" class="required"/>
				<span class="notice">Precisa ser confirmado</span>
			</div>
			<div class="field">
				<label for="confirmacao">Confirme</label>
				<input type="password" name="confirmacao" value="" id="confirmacao" />
			</div>
			
			<h2>Informações Sobre Você</h2>
			
			<div class="field">
				<label for="site">Web Site</label>
				<input type="text" name="user.site" value="${user.site }" 
						id="site" class="required"/>
			</div>
			<div class="field">
				<label for="localizacao">Localização</label>
				<input type="text" name="user.localizacao" value="${user.localizacao }" 
						id="localizacao" class="required"/>
			</div>
			<div class="field">
				<label for="profissao">Profissão</label>
				<input type="text" name="user.profissao" value="${user.profissao }" 
						id="profissao" class="required"/>
			</div>
			<div class="field">
				<label for="interesses">Interesses</label>
				<input type="text" name="user.interesses" value="${user.interesses }" 
						id="interesses" class="required"/>
			</div>
			<div class="field">
				<label for="msn">MSN Messenger</label>
				<input type="text" name="user.msnMessenger" value="${user.msnMessenger }" 
						id="msnMessenger" class="required"/>
			</div>
			<div class="field">
				<label for="yahoo_msn">Yahoo Messenger</label>
				<input type="text" name="user.yahooMessenger" value="${user.yahooMessenger }" 
						id="yahooMessenger" class="required"/>
			</div>
			<div class="field">
				<label for="interesses">Biografia</label>
				<textarea name="user.biografia" rows="8" cols="35">${user.biografia }</textarea>
			</div>
			
			<h2>Avatar</h2>
			<div class="field">
				<div id="avatar_left">
					Esta imagem será mostrada junto com os seus posts e comentários.<br />
					Ela não pode ser maior do que 130x130 pixels
				</div>
				<div id="avatar_right">
					<img src="images/logo.png" alt="avatar"/>	
				</div>
			</div>
			<div class="field">
				<label for="avatar_pc">Carregar imagem do computador</label>
				<input type="file" name="nome" value="" id="avatar_pc" />
			</div>
			<div class="field">
				<label for="avatar_url">Utilizar uma imagem externa(digite a URL)</label>
				<input type="text" name="nome" value="" id="avatar_url" />
			</div>
			
			<div class="button">
				<button class="botao" type="submit" name="_method" value="PUT">Enviar</button>
				<input class="limpar" type="reset" value="Limpar" />
				<a href="perfil.html">Visializar Meu Perfil</a>
			</div>
		</form>
	</div><!--FIM DADOS-->			

	
</div><!--FIM CENTRO-->

<%@ include file="../index/barra_lateral.jsp"%>