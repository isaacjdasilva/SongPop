<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/estilos.css" type="text/css" rel="stylesheet">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/funcao.js"></script>
<title>SongPop - Meus dados</title>
</head>

	body,
	html {
		margin:0;
		padding:0;
		color:#000;
		background:#a7a09a;
	}
	
	* {
		font-family: 'lucida grande',tahoma,verdana,arial,sans-serif;
	}
	
    #corpo {
		width:1000px;
		margin:0 auto;
		background:#99c;
	}
	#cabecalho {
                background:#ddd;
                padding:5px 10px;
        }
        h1 {
                margin:0;
        }
        #menu {
                background:#c99;
                padding:5px 10px;
        }
        #menu ul {
		margin:0;
		padding:0;
		list-style:none;
        }
        #menu li {
		display:inline;
		margin:0;
		padding:0;
       }
       #coluna1 {
                background:#9c9;
                float:left;
                width:480px;
                padding:10px;
        }
        h2 {
                margin:0 0 1em;
        }
        #coluna2 {
                background:#adc;
                float:right;
                width:auto;
                padding:10px;
        }
        #rodape {
                background:#cc9;
                padding:5px 10px;
                clear: both;
        }
        * html #rodape {
                height:1px;
         }
        #rodape p {
                margin:0;
        }
		
		.inputtext {
			width: 206px;
			border-color: #96A6C5;
			margin-top: 2px;
		}
		
    </style>
</head>
<body>
    <div id="corpo">
	<div id="cabecalho"><h1>oitavo passo - Layout de Duas colunas com CSS</h1></div>
	<div id="menu">
		<ul>
			<li><a href="#">Opção 1</a></li>
			<li><a href="#">Opção 2</a></li>
		</ul>
	</div>
	<div id="coluna1">
		<h2>Coluna 1</h2>
		<p>
		
		</p>
	</div>
	<div id="coluna2">
		<h2></h2>
		<p>
		<div id="" class="cadastro">
			<form>
				<table>
					<tr>
						<td colspan="2">Dados Pessoais<hr></td>
					</tr>
					<tr>
						<td>Nome:</td>
						<td class="inputtext"><input type="text" name="login" id="nome"/></td>
					</tr>
					<tr>
						<td>Data de Nascimento:</td>
						<td class="inputtext"><input type="text" name="data_nascimento" id="nome"/></td>
					</tr>
					<tr>
						<td>Gênero:</td>
						<td class="inputtext">
							<select class="select" name="genero" id="genero">
								<option value="1">Feminino</option>
								<option value="2">Masculino</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Email</td>
						<td class="inputtext"><input type="text" name="email" id="email"/></td>
					</tr>
					<tr>
						<td colspan="2"></br>Dados de Acesso<hr></td>
					</tr>
					<tr>
						<td>Login</td>
						<td class="inputtext"><input type="text" name="login" id="login"/></td>
					</tr>
					<tr>
						<td>Senha:</td>
						<td class="inputtext"><input type="password" name="senha" id="senha" /></td>
					</tr>
					<tr>
						<td>Confirma senha:</td>
						<td class="inputtext"><input type="password" name="confirmaSenha" id="confirmaSenha" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Cadastrar" name="btnAlterar" class="botao"></td>
						<td><input type="submit" value="Limpar" name="btnAlterar"class="botao"></td>
					</tr>
				</table>
			</form>
		</div>

		</p>
	</div>
	<div id="rodape">
		<p>Rodapé</p>
	</div>
    </div>
</body>
</html>