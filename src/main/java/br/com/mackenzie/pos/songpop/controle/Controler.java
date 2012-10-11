/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.controle;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.StatusDesafio;
import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;
import br.com.mackenzie.pos.songpop.controle.util.Util;
import br.com.mackenzie.pos.songpop.domain.Artista;
import br.com.mackenzie.pos.songpop.domain.Categoria;
import br.com.mackenzie.pos.songpop.domain.Desafio;
import br.com.mackenzie.pos.songpop.domain.ItemDesafio;
import br.com.mackenzie.pos.songpop.domain.Jogador;
import br.com.mackenzie.pos.songpop.domain.Musica;
import br.com.mackenzie.pos.songpop.domain.Resposta;
import br.com.mackenzie.pos.songpop.persistencia.dao.ArtistaDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.CategoriaDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.DesafioDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.ItemDesafioDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.JogadorDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.MusicaDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.RespostaDAO;
import br.com.mackenzie.pos.songpop.persistencia.dao.RespostaJogadorItemDesafioDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Isaac
 */
public class Controler {

    private static ArtistaDAO artistaDAO = null;
    private static CategoriaDAO categoriaDAO = null;
    private static DesafioDAO desafioDAO = null;
    private static ItemDesafioDAO itemDesafioDAO = null;
    private static JogadorDAO jogadorDAO = null;
    private static MusicaDAO musicaDAO = null;
    private static RespostaDAO respostaDAO = null;
    private static RespostaJogadorItemDesafioDAO respostaJogadorItemDesafioDAO = null;
    private static Controler controler = null;

    public synchronized static Controler getInstance() {
        if (controler == null) {
            controler = new Controler();
            inicializarSistema();
        }
        return controler;
    }

    private Controler() {
    }

    private static void inicializarSistema() {

        System.out.println(">>> Criando o Banco de Dados...");

        artistaDAO = new ArtistaDAO();
        categoriaDAO = new CategoriaDAO();
        desafioDAO = new DesafioDAO();
        itemDesafioDAO = new ItemDesafioDAO();
        jogadorDAO = new JogadorDAO();
        musicaDAO = new MusicaDAO();
        respostaDAO = new RespostaDAO();
        respostaJogadorItemDesafioDAO = new RespostaJogadorItemDesafioDAO();

        System.out.println(">>> Banco de Dados criado com Sucesso...");
    }

    public Desafio criarDesafio(Jogador desafiante, Jogador desafiado, Categoria categoria) {

        long proximoId = desafioDAO.proximaSequence();

        Desafio desafio = new Desafio();
        desafio.setId(proximoId);
        desafio.setCategoria(categoria);
        desafio.setDesafiante(desafiante);
        desafio.setDesafiado(desafiado);
        desafio.setStatusDesafio(StatusDesafio.AGUARDANDO_OPONENTE);

        // Configura os intens
        ItemDesafio[] itemDesafio = criarItemDesafio(desafio);
        desafio.setItemDesafio(itemDesafio);

        desafio.setDataInicio((new Date()).getTime());

        // Inserir Dados
        desafioDAO.inserir(desafio);
        itemDesafioDAO.inserirArrays(itemDesafio);

        return desafio;
    }

    private ItemDesafio[] criarItemDesafio(Desafio desafio) {

        int QTD_MUSICAS = 5;

        ItemDesafio[] itensDesafios = new ItemDesafio[QTD_MUSICAS];

        ArrayList<Musica> musicas = (ArrayList<Musica>) musicaDAO.recuperarColecaoPorColuna(5, "", "" + desafio.getCategoria().getId(), true);

        Set<Musica> musicasSostiadas = new HashSet<Musica>();

        while (musicasSostiadas.size() != QTD_MUSICAS) {
            LinkedList<Integer> idsMusicas = Util.gerarNumerosAleatoriosComIntervalo(QTD_MUSICAS, musicas.size());

            for (Integer idSorteado : idsMusicas) {
                if (idSorteado.intValue() < musicas.size()) {
                    musicasSostiadas.add(musicas.get(idSorteado));
                }

            }
        }

        Iterator<Musica> iMusicas = musicasSostiadas.iterator();

        for (int i = 0; i < itensDesafios.length; i++) {

            long proximoIdItem = itemDesafioDAO.proximaSequence();
            Musica musica = iMusicas.next();

            ItemDesafio itemDesafio = new ItemDesafio();
            itemDesafio.setId(proximoIdItem);
            itemDesafio.setMusica(musica);
            
            // Carrega artista da música
            Artista artista = this.obterArtistaPorId(musica.getArtista().getId());
            musica.setArtista(artista);

            long proximoIdResposta = respostaDAO.proximaSequence();
            Resposta resposta = new Resposta();
            resposta.setId(proximoIdResposta);
            
            TipoPergunta tipoPergunta;
            if (Util.gerarNumerosAleatorios(2) == 1) {
                tipoPergunta = TipoPergunta.ARTISTA;
                resposta.setDescricao(itemDesafio.getMusica().getArtista().getNome());
            } else {
                tipoPergunta = TipoPergunta.MUSICA;
                resposta.setDescricao(itemDesafio.getMusica().getNome());
            }

            itemDesafio.setTipoPergunta(tipoPergunta);
            
            resposta.setTipoPergunta(tipoPergunta);
            itemDesafio.setRespostaCorreta(resposta);

            itensDesafios[i] = itemDesafio;
        }

        return itensDesafios;
    }

    /**
     *
     * @param id
     * @return
     */
    public Categoria obterCateriaPorId(Long id) {
        return categoriaDAO.obterPorId(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public Jogador obterJogadorPorId(Long id) {
        return jogadorDAO.obterPorId(id);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Artista obterArtistaPorId(Long id) {
        return artistaDAO.obterPorId(id);
    }
    
    /**
     *
     * @return
     */
    public Collection<Artista> pesquisarTudosArtistas() {
        return artistaDAO.pesquisarTudo();
    }
    
    public Collection<Musica> pesquisarTudosMusicas() {
        return musicaDAO.pesquisarTudo();
    }
}