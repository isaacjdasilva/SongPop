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
	
<script type="text/javascript">
    $(document).ready(function(){
        
        $("#opcao1").click(function () {
    			$("#form_jogar").submit();
   		     	return true;
   	    });

        $("#opcao2").click(function () {
			$("#form_criardesafio").submit();
		     	return true;
	    });        
        
    });
</script>
	
</head>
<body>
    <div id="container">
		<%@ include file="/adm/inc/header.jsp" %>
    </div>
    
	<div class="telaDeBatalha">
		<div class="menu">
		 <div id="opcao1" class="opcao oEsquerda"><br>JOGAR<form id="form_jogar" action="/desafio/jogar.action" method="post"><input name="requestedUrl" type="hidden" value="${param.requestedUrl}"/></form></div>
		 <div id="opcao2" class="opcao oDireita"><br>CRIAR JOGO<form id="form_criardesafio" action="/desafio/exibircriardesafio.action" method="post"><input name="requestedUrl" type="hidden" value="${param.requestedUrl}"/></form></div>
		</div>
	</div>
 	
</body>
</html>