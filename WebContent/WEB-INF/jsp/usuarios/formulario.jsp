
<div id="centro"><!--INICIO CENTRO-->
			<h1>angoJUG - Cadastro</h1>
			<p>
				Por favor, note que você precisará escrever um endereço de e-mail válido 
				para que o seu registro seja ativado. Você vai receber um e-mail contendo as 
				informações necessárias para a sua ativação.	
			</p>
			
			<div id="cadastro"><!--INICIO CADASTRO-->
				<form action="<c:url value="/usuarios" />" method="post" >
					<div class="field">
						<label for="nome">Nome</label>
						<input type="text" name="user.nome" value="${user.nome }" id="nome" class="required"/>
					</div>
					<div class="field">
						<label for="email">Email</label>
						<input type="text" name="user.email" value="${user.email }" 
						id="email" class="required"/>
					</div>
					<div class="field">
						<label for="password">Password</label>
						<input type="password" name="user.password" value="${user.password }" 
						id="password" class="required"/>
					</div>
					<div class="field">
						<label for="confirmacao">Confirme</label>
						<input type="password" name="password_confirmation" value="" id="confirmacao" />
					</div>
					<div class="button">
						<input type="submit" value="Enviar" />
						<input class="limpar" type="reset" value="Limpar" />
					</div>
				</form>
			</div><!--FIM CADASTRO-->
			
			
		</div><!--FIM CENTRO-->

<%@ include file="../index/barra_lateral.jsp" %>