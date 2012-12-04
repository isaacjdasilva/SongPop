<%@ include file="/inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>SongPop</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Content-Language" content="pt-BR" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="author" content="Eduardo Rodrigues Gomes" />
	<meta name="robots" content="no-follow" />
	<meta name="MSSmartTagsPreventParsing" content="true" />
	<script src="/js/jquery.js?v=1_0" type="text/javascript"></script>
	<script src="/js/jquery.validate.js?v=1_0" type="text/javascript"></script>
	<script src="/js/validate.methods.js?v=1_0" type="text/javascript"></script>
	<script src="/js/tiny_mce/tiny_mce.js?v=1_0" type="text/javascript"></script>
	<link href="/game/css/estilos.css" type="text/css" rel="stylesheet" />
	<script src="/game/js/jquery-1.8.2.min.js"></script>
	<script src="/game/js/funcao.js"></script>
</head>
<body>
    <div id="container">
		<%@ include file="/adm/inc/header.jsp" %>
    </div>
    <div id="" class="telaDeBatalha">
    	<form class="cadastro_jogo" id="form_cadastro_jogo" action="/desafio/criardesafio.action" method="post">
			<table>
			  <tr>
			    <td>Escolha a categoria</th>
			    <td><input name="requestedUrl" type="hidden" value="${param.requestedUrl}"/>
			    	
			    	<c:if test="${!empty categorias}">
						    <select id="idCategoria" name="idCategoria">
							  	<c:forEach var="categoria" items="${categorias}">
									<option value="<c:out value="${categoria.id}"/>"><c:out value="${categoria.nome}"/></option>
								</c:forEach>
					    	</select>

				  </c:if>
			    	
			    </td>
			  </tr>
			  <tr>
			    <td>Escolha o adversário</td>
			    <td>
			    
			      <c:if test="${!empty jogadores}">
				    <select id="idDesafiado" name="idDesafiado">
					  	<c:forEach var="jogador" items="${jogadores}">
							<option value="<c:out value="${jogador.id}"/>"><c:out value="${jogador.nome}"/></option>
						</c:forEach>
			    	</select>

				  </c:if>
			    
			    </td>
			  </tr>
			  <tr>
			    <td colspan="2"><input type="submit" value="Criar jogo" id="criar" /></td>
			  </tr>
			</table>
			
		</form>

	</div>
</body>
</html>