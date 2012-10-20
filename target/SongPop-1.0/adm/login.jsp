<%@ include file="/inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<%@ include file="/adm/inc/taghead.jsp" %>
</head>
<body>
    <div id="container">
		<div id="header">
			<h1><a href="#" title="Clique para retornar ao início" class="imgrpl">PROJETO - BACKEND</a></h1>
		</div>	
		<div class="clear"></div>
		<form class="form_login" action="/adm/login.action" method="post">
			<fieldset class="fieldset_login">
				<input name="requestedUrl" type="hidden" value="${param.requestedUrl}"/>
				<p>Para acessar a área administrativa do site, preencha os campos abaixo:</p>
				
				<p>
					<label for="email" class="left">Login :</label>
					<input type="text" name="usuario" id="usuario" value="${param.usuario}"/>
				</p>
				<p>					
					<label for="password" class="left">Senha :</label>
					<input type="password" name="senha" id="senha" value="${param.senha}"/>
				</p>
				<ul class="btns_form mt_20">
					<li><input type="submit" value="Acessar" /></li>
				</ul>
				<strong>&nbsp;
				<label class="error" for="email" generated="true">${error}</label>
				</strong>
			</fieldset>
		</form>
    </div>
</body>
</html>