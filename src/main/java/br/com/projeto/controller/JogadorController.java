package br.com.projeto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.User;
import br.com.projeto.enumerador.Sexo;
import br.com.projeto.enumerador.Status;
import br.com.projeto.service.JogadorService;
import br.com.projeto.util.Constants;
import br.com.projeto.util.CryptUtils;
import br.com.projeto.util.Util;

@Controller
public class JogadorController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private JogadorService service;

	List<String> erros = new ArrayList<String>();

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public void adicionarErro(String erro) {
		if (Util.isNullOrVazio(getErros())) {
			setErros(new ArrayList<String>());
		}

		getErros().add(erro);
	}
	
	public void cleanErro() {
		setErros(new ArrayList<String>());
	}

	@RequestMapping("jogador/cadastrar")
	public ModelAndView cadastrar(
			@RequestParam(value = "nome", required = true) String nome,
			@RequestParam(value = "dataNascimento", required = true) String dataNascimento,
			@RequestParam(value = "genero", required = true) String genero,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "requestedUrl", required = true) String requestedUrl,
			HttpSession session, HttpServletRequest req)
			throws ServletException, IOException {
		
		cleanErro();

		ModelAndView modelAndView = null;

		Jogador jogador = validarECriarJogador(nome, dataNascimento, genero,
				email, login, password);

		String retornarPagina = "../index.jsp";

		if (StringUtils.isNotBlank(requestedUrl)) {
			retornarPagina += requestedUrl;
		}

		if (!Util.isNullOrVazio(getErros())) {
			modelAndView = new ModelAndView(new RedirectView(retornarPagina));
			modelAndView.addObject("erros", erros);
			req.setAttribute("erros", erros);
			return modelAndView;
		}

		try {
			service.createJogador(jogador);
		} catch (Exception e) {
			adicionarErro("Op's, aconteceu algum problema");
			modelAndView = new ModelAndView(new RedirectView(retornarPagina));
			modelAndView.addObject("erros", erros);
			req.setAttribute("erros", erros);
			return modelAndView;
		}

		session.setAttribute(Constants.USER_JOGADOR, jogador);

		String mensagem = "Seja Bem-vindo e boa diversão";
		modelAndView = new ModelAndView(new RedirectView("../game/jogadorescolhas.jsp"));
		modelAndView.addObject("mensagemSucesso", mensagem);
		return modelAndView;

	}

	private Jogador validarECriarJogador(String nome, String dataNascimento,
			String genero, String email, String login, String password) {

		if (Util.isNullOrEmpty(nome)) {
			adicionarErro("Nome é Obrigatório");
		}

		Date dataNascimentoJogador = null;

		if (!Util.isNullOrEmpty(dataNascimento)) {
			try {
				dataNascimentoJogador = Util.transformaData(dataNascimento);
			} catch (RuntimeException e) {
				adicionarErro("Data de Nascimento Inválida");
				e.printStackTrace();
			}

		} else {
			adicionarErro("Data de Nascimento é Obrigatória");
		}

		Sexo sexo = obterSexoJogador(genero);

		if (Util.isNullOrEmpty(email)) {
			adicionarErro("Email eh Obrigatorio");
		}

		if (Util.isNullOrEmpty(login)) {
			adicionarErro("Login é Obrigatório");
		}

		if (Util.isNullOrEmpty(password)) {
			adicionarErro("Password é Obrigatório");
		}

		if (service.existeJogadorComLoginOuEmail(login, email)) {
			adicionarErro("Usuário já cadastrado para login e/ou email");
		}

		return criarJogador(nome, dataNascimentoJogador, email, sexo, login,
				password);
	}

	private Sexo obterSexoJogador(String genero) {
		Sexo sexo = null;
		if (!Util.isNullOrEmpty(genero)) {
			if (Sexo.FEMININO.getCodigo() == Integer.parseInt(genero)) {
				sexo = Sexo.FEMININO;
			} else if (Sexo.MASCULINO.getCodigo() == Integer.parseInt(genero)) {
				sexo = Sexo.MASCULINO;
			} else {
				adicionarErro("Opçao de Sexo não existe");
			}
		} else {
			adicionarErro("Sexo é Obrigatório");
		}

		return sexo;
	}

	private User criarUser(String login, String password) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(CryptUtils.md5(password));
		user.setStatus(Status.ATIVO);
		user.setInsertDate(new Date());
		return user;
	}

	private Jogador criarJogador(String nome, Date dataNascimento,
			String email, Sexo sexo, String login, String password) {

		User user = criarUser(login, password);

		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		jogador.setDataNascimento(dataNascimento);
		jogador.setEmail(email);
		jogador.setSexo(sexo);
		jogador.setStatus(Status.ATIVO);
		jogador.setUser(user);

		return jogador;
	}

}