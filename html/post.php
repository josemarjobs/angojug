<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>AngoJUG</title>
	<link rel="stylesheet" href="estilo.css" type="text/css" charset="utf-8" />
	<link href="styles/hl/shCore.css" rel="stylesheet" type="text/css" />
	<link href="styles/hl/shThemeDefault.css" rel="stylesheet" type="text/css" />
</head>
<body id="corpo">
	
	<div id="cabecalho"><!--INICIO CABECALHO-->
		<div id="topo" class="round"><!--INICIO TOPO-->
			<div id="logo">
				<a href="index.html"><img src="images/logo.png" alt="logo" /></a>
			</div>
			<div id="direita">
				<div id="search">
					<form action="" method="get" accept-charset="utf-8">
						<input type="text" name="term" value="" id="term" class="term"/>
						<input class="botao" type="submit" value="Buscar" />
					</form>
				</div>
			</div>
		</div><!--FIM TOPO-->
		<div id="barra_horizontal"><!--INICIO BARRAHORIZONTAL-->
			<div id="menu" class="top_round"><!--INICIO MENU-->
			<div class="opcoes">
				<ul>
					<li><a href="">HOME</a></li>
					<li><a href="">SOBRE</a></li>
					<li><a href="">CONTATO</a></li>
				</ul>
			</div>
			<div class="cadastro">
				<ul>
					<li class="cadastre-se sombra"><a href="cadastro.html">Cadastre-se</a></li>
					<li class="login sombra"><a href="login.html">Login</a></li>
				</ul>
			</div>
		</div><!--FIM MENU-->
	</div><!--FIM BARRAHORIZONTAL-->
	</div><!--FIM CABECALHO-->
	
	<div id="conteudo" class="bottom_round"><!--INICIO CONTEUDO-->
		
		<div id="centro"><!--INICIO CENTRO-->
			<div class="postagem"><!--INICIO POSTAGEM-->
				
	
	<!-- Include required JS files -->
	<script type="text/javascript" src="javascript/hl/shCore.js"></script>
	 
	<!--
	    At least one brush, here we choose JS. You need to include a brush for every 
	    language you want to highlight
	-->
	<script type="text/javascript" src="javascript/hl/shBrushJava.js"></script>
				
				
				<?php 
	
					$post = $_POST['content'];
					
					echo $post;
				
				?>		
				
				
				
	<!-- Finally, to actually run the highlighter, you need to include this JS on your page -->
	<script type="text/javascript">
	     SyntaxHighlighter.all()
	</script>	
				
			</div><!--FIM POSTAGEM-->
		
		</div><!--FIM CENTRO-->
		
		<div id="lateral" class="bottom_round"><!--INICIO LATERAL-->
			<div class="gadget_lateral feed">
				<a href=""><img class="feed" src="images/feed.png" alt="rss feed" /></a>
			</div>
			<div class="gadget_lateral"><!--INICIO GADGET LATERAL-->
				<h1>Últimos Posts</h1>
				<ul>
					<li><a href="">I/O is a great opportunity to connect</a></li> 
					<li><a href="">with new and familiar faces.</a></li> 
					<li><a href="">We're excited to have so many bright </a></li> 
					<li><a href="">range of apps, companies, and technol</a></li> 
					<li><a href="">from around the world.</a></li> 
					<li><a href="">You'll be able to meet other develope</a></li>
					<li><a href="">and share what you've been working on.</a></li>
				</ul>
			</div><!--FIM GADGET LATERAL-->
			<div class="gadget_lateral"><!--INICIO GADGET LATERAL-->
				<h1>Tag Cloud</h1>
					<a href="" class="tag">grails</a><a href="" class="tag">agile</a>
					<a href="" class="tag">ruby</a><a href="" class="tag">joomla</a>
					<a href="" class="tag">apache</a><a href="" class="tag">drupal</a>
					<a href="" class="tag">java</a><a href="" class="tag">google</a>
					<a href="" class="tag">hibernate</a><a href="" class="tag">facebook</a>
					<a href="" class="tag">php</a><a href="" class="tag">app engie</a>
					<a href="" class="tag">ruby on rails</a><a href="" class="tag">maps api</a>
					<a href="" class="tag">spring MVC</a><a href="" class="tag">webtoolkit</a>
					
			</div><!--FIM GADGET LATERAL-->
			<div class="gadget_lateral"><!--INICIO GADGET LATERAL-->
				<h1>Blog Roll</h1>
				<ul>
					<li><a href="">opportunity to connect</a></li> 
					<li><a href="">and familiar faces.</a></li> 
					<li><a href="">have so many bright </a></li> 
					<li><a href="">apps, companies, and technol</a></li> 
					<li><a href="">ound the world.</a></li> 
					<li><a href="">to meet other develope</a></li>
					<li><a href="">I've been working on.</a></li>
				</ul>
			</div><!--FIM GADGET LATERAL-->
			<div class="gadget_lateral"><!--INICIO GADGET LATERAL-->
				<h1>Arquivo</h1>
				<ul>
					<li><a href="">Janeiro(10)</a></li> 
					<li><a href="">Fevereiro(3)</a></li> 
					<li><a href="">Março(89)</a></li> 
					<li><a href="">Janeiro(10)</a></li> 
					<li><a href="">Fevereiro(3)</a></li> 
					<li><a href="">Março(89)</a></li> 
					<li><a href="">Janeiro(10)</a></li> 
					<li><a href="">Fevereiro(3)</a></li> 
					<li><a href="">Março(89)</a></li> 
					<li><a href="">Janeiro(10)</a></li> 
					<li><a href="">Fevereiro(3)</a></li> 
					<li><a href="">Março(89)</a></li> 
					<li><a href="">Janeiro(10)</a></li> 
					<li><a href="">Fevereiro(3)</a></li> 
					<li><a href="">Março(89)</a></li> 
				</ul>
			</div><!--FIM GADGET LATERAL-->
			
		</div><!--FIM LATERAL-->
	</div><!--FIM CONTEUDO-->
	
	
	<div id="rodape" class="round"><!--INICIO RODAPE-->
		<div class="copy">
		Powered By: <a href="">SoftSystems Corp - &copy; 2011</a>
		</div>
	</div><!--FIM RODAPE-->
</body>
</html>