/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;
import br.com.mackenzie.pos.songpop.controle.util.Util;
import java.util.HashSet;

/**
 *
 * @author Isaac
 */
public class ItemDesafio {
    
    private Long id;
    
    private Musica musica;
    
    private TipoPergunta tipoPergunta;
    
    private Resposta respostaCorreta;
    
    private RespostaJogadorItemDesafio respostaJogadorDesafianteItemDesafio;
    
    private RespostaJogadorItemDesafio respostaJogadorDesafiadoItemDesafio;
    
    private HashSet<String> opcoes;

    public ItemDesafio() {
    }
    
    public ItemDesafio(Long id) {
        this.id = id;
    }

    public ItemDesafio(Long id, Musica musica, TipoPergunta tipoPergunta, Resposta respostaCorreta, RespostaJogadorItemDesafio respostaJogadorDesafianteItemDesafio, RespostaJogadorItemDesafio respostaJogadorDesafiadoItemDesafio) {
        this.id = id;
        this.musica = musica;
        this.tipoPergunta = tipoPergunta;
        this.respostaCorreta = respostaCorreta;
        this.respostaJogadorDesafianteItemDesafio = respostaJogadorDesafianteItemDesafio;
        this.respostaJogadorDesafiadoItemDesafio = respostaJogadorDesafiadoItemDesafio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public TipoPergunta getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(TipoPergunta tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }

    public RespostaJogadorItemDesafio getRespostaJogadorDesafianteItemDesafio() {
        return respostaJogadorDesafianteItemDesafio;
    }

    public void setRespostaJogadorDesafianteItemDesafio(RespostaJogadorItemDesafio respostaJogadorDesafianteItemDesafio) {
        this.respostaJogadorDesafianteItemDesafio = respostaJogadorDesafianteItemDesafio;
    }

    public Resposta getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(Resposta respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public RespostaJogadorItemDesafio getRespostaJogadorDesafiadoItemDesafio() {
        return respostaJogadorDesafiadoItemDesafio;
    }

    public void setRespostaJogadorDesafiadoItemDesafio(RespostaJogadorItemDesafio respostaJogadorDesafiadoItemDesafio) {
        this.respostaJogadorDesafiadoItemDesafio = respostaJogadorDesafiadoItemDesafio;
    }

    public HashSet<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(HashSet<String> opcoes) {
        this.opcoes = opcoes;
    }
    
    public void adicionarOpcoes(String opcao) {
        if (Util.isNullOrVazio(getOpcoes())) {
            this.setOpcoes(new HashSet<String>());
        }
        this.getOpcoes().add(opcao);
    }
}