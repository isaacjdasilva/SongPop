<%@ include file="/inc/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<%@ include file="/adm/inc/taghead.jsp" %>
	
	<script type="text/javascript">
    $(document).ready(function(){
        $('#form_cadastro_jogador').validate({
            rules:{
                nome:{
                    required: true,
                    minlength: 20
                },
                dataNascimento:{
                    required: true,
                    date: true,
                    length: 10
                },
                email: {
                    required: true,
                    email: true
                },
                login:{
                    required: true,
                    minlength: 5,
                    maxlength: 7
                },
                password: {
                    required: true,
                    minlength: 5,
                    maxlength: 7
                },
                confirmePassword:{
                    required: true,
                    minlength: 5,
                    maxlength: 7,
                    equalTo: "#password"
                }
            },
            messages:{
                nome:{
                    required: "O campo nome é obrigatorio.",
                    minlength: "O campo nome deve conter no mínimo 20 caracteres."
                },
                dataNascimento:{
                    required: "O campo data de nascimento é obrigatorio.",
                    date: "Data de nascimento invalida",
                    length: "O campo data de nascimento deve conter 10 caracteres."
                },
                email: {
                    required: "O campo email é obrigatorio.",
                    email: "O campo email deve conter um email válido."
                },
                login:{
                    required: "O campo login é obrigatorio.",
                    minlength: "O campo login deve conter no mínimo 5 caracteres.",
                    maxlength: "O campo login deve conter no máximo 7 caracteres."
                },
                password: {
                    required: "O campo senha é obrigatorio.",
                    minlength: "O campo senha deve conter no mínimo 5 caracteres.",
                    maxlength: "O campo senha deve conter no máximo 7 caracteres."
                },
                confirmePassword:{
                    required: "O campo confirmação de senha é obrigatorio.",
                    minlength: "O campo confirmação de senha deve conter no mínimo 5 caracteres.",
                    maxlength: "O campo confirmação de senha deve conter no máximo 7 caracteres.",
                    equalTo: "O campo confirmação de senha deve ser identico ao campo senha."
                }
            }
 
        });

        $("#cadatrar").click(function () {

    		var cont = 0;

   	        if ( $.trim($("#nome").val()) == $.trim(""))
           	{
   	           	cont++;
           	}

   	     	if ( $.trim($("#dataNascimento").val()) == $.trim(""))
        	{
	           	cont++;
        	}

	   	     if ( $.trim($("#email").val()) == $.trim(""))
	     	{
	           	cont++;
	     	}

	   	  	if ( $.trim($("#login").val()) == $.trim(""))
	      	{
		           	cont++;
	      	}

	   	 	if ( $.trim($("#password").val()) == $.trim(""))
	      	{
		           	cont++;
	      	}

		   	if ( $.trim($("#confirmePassword").val()) == $.trim(""))
	      	{
		           	cont++;
	      	}
	   	    
		   	if(cont != 0)
   	         {
   	             alert("Preencha os campos obrigatórios.");
   	             return false;
   	         }

    		var n = $("#cadastro_jogador .error").length;

    		if (n == 0) {
    			$("#form_cadastro_jogador").submit();
        	}
        	return true;

   	    });        
        
    });
</script>
	
</head>
<body>
    <div id="container">
		<div id="header">
			<h1><a href="#" title="Clique para retornar ao início" class="imgrpl">SongPop</a></h1>
		</div>	
		<div class="clear"></div>
			<fieldset class="fieldset_login">
				<div id="divCadastro" style="float:left;">
					<form class="cadastro_jogador" id="form_cadastro_jogador" action="/jogador/cadastrar.action" method="post">
					
						<table>
						  <tr>
						    <td colspan="2"><input name="requestedUrl" type="hidden" value="${param.requestedUrl}"/></td>
						  </tr>
						  <tr>
						    <td colspan="2">Dados Pessoais</td>
						  </tr>
						  
						  <c:if test="${!empty request.erros}">
							  <tr>
							    <td colspan="2">
								    
								  	<c:forEach var="erro" items="${request.erros}">
										<span style="color: red; font-weight: bold;"><c:out value="${erro}"/></span><br />
									</c:forEach>
								</td>
							  </tr>  
						  </c:if>
						  						  
						  <tr>
						    <td>Nome:</td>
						    <td><input type="text" name="nome" id="nome" size="35" maxlength="30"/></td>
						  </tr>
						  <tr>
						    <td>Data Nascimento:</td>
						    <td><input type="text" name="dataNascimento" id="dataNascimento" maxlength="10" size="10"/></td>
						  </tr>
						  <tr>
						    <td>Sexo:</td>
						    <td>
						    	<select id="genero" name="genero">
						    		<option value="1">Feminino</option>
						    		<option value="2">Masculino</option>
						    	</select>
						    </td>
						  </tr>
						  <tr>
						    <td>Email:</td>
						    <td><input type="text" name="email" id="email" maxlength="20" size="20"/></td>
						  </tr>
						  <tr>
						    <td colspan="2"><br /><hr /></td>
						  </tr>
						  <tr>
						    <td colspan="2">Dados de Acesso</td>
						  </tr>
						  <tr>
						    <td>Login:</td>
						    <td><input type="text" name="login" id="login" maxlength="7" size="7"/></td>
						  </tr>
						  <tr>
						    <td>Senha:</td>
						    <td><input type="password" name="password" id="password" maxlength="7" size="7"/></td>
						  </tr>
						  <tr>
						    <td>Confirmar Senha:</td>
						    <td><input type="password" name="confirmePassword" id="confirmePassword" maxlength="7" size="7"/></td>
						  </tr>
						  <tr>
						    <td colspan="2" style="text-align: center;"><input type="submit" value="Cadastrar" id="cadatrar" /></td>
						  </tr>
						</table>
					</form>
				</div>
				
				<div id="divLogin" style="float:right;">
					<form class="form_login" action="/adm/login.action" method="post">
					
						<input name="requestedUrl" type="hidden" value="${param.requestedUrl}"/>
						<p>Para acessar a área administrativa <br />do site, preencha os campos abaixo:</p>
						
						<p>
							<label for="email" class="left">Login:</label>
							<input type="text" name="usuario" id="usuario" value="${param.usuario}"/>
						</p>
						<p>					
							<label for="password" class="left">Senha:</label>
							<input type="password" name="senha" id="senha" value="${param.senha}"/>
						</p>
						<ul class="btns_form mt_20">
							<li><input type="submit" value="Entrar" /></li>
						</ul>
						<strong>&nbsp;
						<label class="error" for="email" generated="true">${error}</label>
						</strong>
					
					</form>
				</div>
					
			</fieldset>		
    </div>
</body>
</html>