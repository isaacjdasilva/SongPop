<%@ include file="jsp/inc/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ include file="/adm/inc/taghead.jsp"%>

<style type="text/css" media="screen, print, projection">
body,html {
	margin: 0;
	padding: 0;
	color: #000;
	background: #fff;
}

* {
	font-family: 'lucida grande', tahoma, verdana, arial, sans-serif;
}

#corpo {
	width: 1000px;
	margin: 0 auto;
	background: #fff;
}

#cabecalho {
	background: #fff;
	padding: 5px 10px;
}

h1 {
	margin: 0;
}

#menu {
	background: #fff;
	padding: 5px 10px;
}

#menu ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

#menu li {
	display: inline;
	margin: 0;
	padding: 0;
}

#coluna1 {
	background: #fff;
	float: left;
	width: 480px;
	padding: 10px;
}

h2 {
	margin: 0 0 1em;
}

#coluna2 {
	background: #fff;
	float: right;
	width: auto;
	padding: 10px;
}

#rodape {
	background: #fff;
	padding: 5px 10px;
	clear: both;
}

* html #rodape {
	height: 1px;
}

#rodape p {
	margin: 0;
}

.inputtext {
	width: 206px;
	border-color: #96A6C5;
	margin-top: 2px;
}

.estiloBotao {
	background-repeat: no-repeat;
	background-size: auto;
	background-position: -1px -539px;
	background-color: #ccc;
	border-color: #3B6E22 #3B6E22 #2C5115;
}

table thead tr th, table tbody tr td {
	text-align: left;
}

</style>
</head>
<body>
<div id="corpo">
<div id="cabecalho">
<form action="/adm/login.action" method="post">
<table>
	<tr>
		<td>Login:</td>
		<td class="inputtext">Senha:</td>
		<td></td>
	</tr>
	<tr>
		<td><input type="text" name="usuario" id="usuario"
			value="${param.usuario}" /></td>
		<td class="inputtext"><input type="password" name="senha"
			id="senha" value="${param.senha}" /></td>
		<td><input type="submit" value="Acessar" class="estiloBotao" /></td>
	</tr>
	<tr>
		<td><input name="requestedUrl" type="hidden"
			value="${param.requestedUrl}" /></td>
		<td class="inputtext">Esqueceu a Senha</td>
		<td><strong>&nbsp; <label class="error" for="email"
			generated="true">${error}</label> </strong></td>
	</tr>
</table>
</form>
</div>
<div id="menu"></div>
<div id="coluna1"></div>
<div id="coluna2">
<h2></h2>
<p>
<div id="" class="cadastro">
<form class="form_cadastro" action="/adm/cadastro.action" method="post">
<table>
	<tr>
		<td colspan="2">Dados Pessoais
		<hr>
		</td>
	</tr>
	<tr>
		<td>Nome:</td>
		<td class="inputtext"><input type="text" name="login" id="nome" /></td>
	</tr>
	<tr>
		<td>Data de Nascimento:</td>
		<td class="inputtext"><input type="text" name="data_nascimento"
			id="nome" /></td>
	</tr>
	<tr>
		<td>Gênero:</td>
		<td class="inputtext"><select class="select" name="genero"
			id="genero">
			<option value="1">Feminino</option>
			<option value="2">Masculino</option>
		</select></td>
	</tr>
	<tr>
		<td>Email</td>
		<td class="inputtext"><input type="text" name="email" id="email" /></td>
	</tr>
	<tr>
		<td colspan="2"></br>
		Dados de Acesso
		<hr>
		</td>
	</tr>
	<tr>
		<td>Login</td>
		<td class="inputtext"><input type="text" name="login" id="login" /></td>
	</tr>
	<tr>
		<td>Senha:</td>
		<td class="inputtext"><input type="password" name="senha"
			id="senha" /></td>
	</tr>
	<tr>
		<td>Confirma senha:</td>
		<td class="inputtext"><input type="password" name="confirmaSenha"
			id="confirmaSenha" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Cadastre-se"
			name="btnCadastrar" class="estiloBotao" /></td>
	</tr>
</table>
</form>
</div>

</p>
</div>
<div id="rodape"></div>
</div>
</body>
</html>