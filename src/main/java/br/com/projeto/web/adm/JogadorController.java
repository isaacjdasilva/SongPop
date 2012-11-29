package br.com.projeto.web.adm;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.entity.Jogador;
import br.com.projeto.enumerador.Status;
import br.com.projeto.service.JogadorService;

@Controller
public class JogadorController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JogadorService service;


	@RequestMapping("/adm/cadastro")
	public String cadastrar(@RequestParam(value="nome",required=true) String nome,
							@RequestParam(value="dataNascimento",required=true) String dataNascimento,
							@RequestParam(value="genero",required=true) String genero,
							@RequestParam(value="email",required=true) String email,
							@RequestParam(value="login",required=true) String login,
							@RequestParam(value="senha",required=true) String senha,
						 @RequestParam(value="requestedUrl",required=true) String requestedUrl) throws ServletException, IOException {
		
		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		jogador.setStatus(Status.ATIVO);
		
		service.createJogador(jogador);
		
		
//		if(service.login(login, password)!=null){
//			if(StringUtils.isNotBlank(requestedUrl)){
//				return"redirect:"+requestedUrl.replaceAll("\\$10","?").replaceAll("\\$11","&");
//			}else{
				return "redirect:/adm";
//			}
//		}
//		return "redirect:/adm/login.jsp?error=Usuário e/ou senha inválidos";
	}
	
}