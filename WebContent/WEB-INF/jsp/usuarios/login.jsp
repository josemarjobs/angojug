<div id="centro"><!--INICIO CENTRO-->
	<h1>angoJUG - Login</h1>
	<div id="login"><!--INICIO LOGIN-->
		<form action="<c:url value="/usuarios/autentica" />" method="post" accept-charset="utf-8">

			<p>
				Por favor forneça os seus dados e faça login!!!<br />
				Caso não tenha ainda cadastro <a href="">clique aqui</a>, só demora alguns segundos.
			</p>
			<div class="field">
				<label for="email">Email</label>
				<input type="text" name="user.email" value="${user.email }" id="email"/>
				<!-- <br />&nbsp;&nbsp;<span class="error">Preencha os campos com(*)</span> -->
			</div>
			<div class="field">
				<label for="password">Password</label>
				<input type="password" name="user.password" value="" id="password" />
			</div>
			<div class="field">
				<input class="check" type="checkbox" name="nome" value="" id="lembrar" />
				Lembrar meu login<br />
				<p><a href="">Esqueci a senha</a></p>
				<p><a href="">Reenviar e-mail de ativação</a></p>
			</div>
			<div class="button">
				<input type="submit" value="Login" />
				<input class="limpar" type="reset" value="Limpar" />
			</div>
		</form>
	</div><!--FIM LOGIN-->
	
	
</div><!--FIM CENTRO-->
<%@ include file="../index/barra_lateral.jsp"%>