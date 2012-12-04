package br.com.projeto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.projeto.entity.Artista;
import br.com.projeto.entity.Categoria;
import br.com.projeto.entity.Desafio;
import br.com.projeto.entity.ItemDesafio;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Musica;
import br.com.projeto.entity.MusicaCategoria;
import br.com.projeto.entity.Opcao;
import br.com.projeto.entity.Resposta;
import br.com.projeto.enumerador.Status;
import br.com.projeto.enumerador.StatusDesafio;
import br.com.projeto.enumerador.TipoPergunta;
import br.com.projeto.service.ArtistaService;
import br.com.projeto.service.CategoriaService;
import br.com.projeto.service.DesafioService;
import br.com.projeto.service.JogadorService;
import br.com.projeto.service.MusicaCategoriaService;
import br.com.projeto.util.Constants;
import br.com.projeto.util.Util;

@Controller
public class DesafioController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private JogadorService service;
	
	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	JogadorService jogadorService;
	
	@Autowired
	DesafioService desafioService;	
	
	@Autowired
	MusicaCategoriaService musicaCategoriaService;
	
	@Autowired
	ArtistaService artistaService;
	
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

	@RequestMapping("desafio/exibircriardesafio")
	public ModelAndView exibirCriarDesafio(@RequestParam(value = "requestedUrl", required = true) String requestedUrl, HttpSession session)
			throws ServletException, IOException {

		Jogador jogador = (Jogador) session.getAttribute(Constants.USER_JOGADOR);

		List<Categoria> categorias = categoriaService.recuperarListaCtegoriaPorLevel(jogador.getJogadorLevel().getLevel().getId());
		session.setAttribute("categorias", categorias);
		
		
		List<Jogador> jogadores = jogadorService.jogadoresAtivo(jogador.getId());
		session.setAttribute("jogadores", jogadores);

		ModelAndView modelAndView = null;

		modelAndView = new ModelAndView(new RedirectView("../game/criarjogo.jsp"));
		return modelAndView;

	}
	
	@RequestMapping("desafio/criardesafio")
	public ModelAndView criarDesafio(@RequestParam(value = "requestedUrl", required = true) String requestedUrl, HttpSession session, HttpServletRequest req)
			throws ServletException, IOException {

		Jogador jogador = (Jogador) session.getAttribute(Constants.USER_JOGADOR);
		
		String stringIdDesafido = req.getParameter("idDesafiado");
		String stringIdCategoria = req.getParameter("idCategoria");
		
		Long idDesafiado = null;
		if (!Util.isNullOrEmpty(stringIdDesafido)) {
			idDesafiado = Long.parseLong(stringIdDesafido);
		} else {
			// Erro
		}
		
		Long idCategoria = null;
		if (!Util.isNullOrEmpty(stringIdCategoria)) {
			idCategoria = Long.parseLong(stringIdCategoria);
		} else {
			// Erro
		}
		
		Jogador desafiado = (Jogador) service.find(idDesafiado, new Jogador());
		Categoria categoria = (Categoria) categoriaService.find(idCategoria, new Categoria());
		
		if (desafiado == null) {
			// Erro
		}
		
		if (categoria == null) {
			// Erro
		}
		
		Desafio desafio = configuraDesafio(jogador, desafiado, categoria);
		
		desafio.setDataInicio(new Date());
		desafio.setStatus(Status.ATIVO);


		ModelAndView modelAndView = null;

		modelAndView = new ModelAndView(new RedirectView("../game/batalha.jsp"));
		return modelAndView;

	}

	public Desafio configuraDesafio(Jogador desafiante, Jogador desafiado, Categoria categoria) {

        Desafio desafio = new Desafio();
        desafio.setCategoria(categoria);
        desafio.setDesafiante(desafiante);
        desafio.setDesafiado(desafiado);
        desafio.setStatusDesafio(StatusDesafio.AGUARDANDO_OPONENTE);

        // Configura os intens
        Set<ItemDesafio> itensDesafios = criarItemDesafio(desafio);
        desafio.setItensDesafios(itensDesafios);

        desafio.setDataInicio(new Date());

        // Inserir Dados
        desafioService.create(desafio);

        return desafio;
    }

    private Set<ItemDesafio> criarItemDesafio(Desafio desafio) {

        int QTD_MUSICAS = 5;

        Set<ItemDesafio> itensDesafios = new HashSet<ItemDesafio>(QTD_MUSICAS);

        Set<Musica> musicasSostiadas = sortearMusicas(desafio, QTD_MUSICAS);

        Iterator<Musica> iMusicas = musicasSostiadas.iterator();
        
        for (int i = 0; i < QTD_MUSICAS; i++) {
			
            Musica musica = iMusicas.next();

            ItemDesafio itemDesafio = new ItemDesafio();
            itemDesafio.setMusica(musica);
            
            // Carrega artista da música
            Artista artista = (Artista) artistaService.find(musica.getArtista().getId(), new Artista());
            musica.setArtista(artista);

            Resposta resposta = new Resposta();
            
            TipoPergunta tipoPergunta;
            if (Util.gerarNumerosAleatorios(2) == 1) {
                tipoPergunta = TipoPergunta.ARTISTA;
            } else {
                tipoPergunta = TipoPergunta.MUSICA;
            }

            itemDesafio.setTipoPergunta(tipoPergunta);
            
            resposta.setTipoPergunta(tipoPergunta);
            itemDesafio.setRespostaCorreta(resposta);
            
            // opcoes de resposta
            itemDesafio.setOpcoes(criaOpcoes(desafio.getCategoria(), tipoPergunta, desafio, QTD_MUSICAS));
            
            resposta.setStatus(Status.ATIVO);

            // ******************************************************
            itensDesafios.add(itemDesafio);
        }

        return itensDesafios;
    }

	private Set<Musica> sortearMusicas(Desafio desafio, int QTD_MUSICAS) {
		ArrayList<MusicaCategoria> musicasCategorias = (ArrayList<MusicaCategoria>) musicaCategoriaService.recuperarMusicasCategoriaAtivo(desafio.getCategoria().getId());

        Set<Musica> musicasSostiadas = new HashSet<Musica>();

        while (musicasSostiadas.size() != QTD_MUSICAS) {
            LinkedList<Integer> idsMusicas = Util.gerarNumerosAleatoriosComIntervalo(QTD_MUSICAS, musicasCategorias.size());

            for (Integer idSorteado : idsMusicas) {
                if (idSorteado.intValue() < musicasCategorias.size()) {
                    musicasSostiadas.add((musicasCategorias.get(idSorteado)).getMusica());
                }

            }
        }
		return musicasSostiadas;
	}
    
    private Set<Opcao> criaOpcoes(Categoria categoria, TipoPergunta tipoPergunta, Desafio desafio, int QTD_MUSICAS){
    	
        
    	Set<Opcao> opcoes = new HashSet<Opcao>(4);
    	
    	Set<Musica> musicasSostiadas = sortearMusicas(desafio, QTD_MUSICAS);
    	
    	while (opcoes.iterator().hasNext()) {
			Opcao opcao = (Opcao) opcoes.iterator().next();
			opcao.setTipoPergunta(tipoPergunta);
			
			// Posteriormente deve-se melhorar a logica do sorteio
			Musica musica = (Musica) musicasSostiadas.iterator().next();
			
			if (tipoPergunta == TipoPergunta.ARTISTA) {
				opcao.setArtista(musica.getArtista());
			} else {
				// Musica
				opcao.setMusica(musica);
			}
		}
    	
    	return opcoes;
    }
}