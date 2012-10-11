/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;

/**
 *
 * @author Isaac
 */
public class Resposta {
    
    private Long id;
    private String descricao;
    private TipoPergunta tipoPergunta;

    public Resposta() {
    }
    
    public Resposta(Long id) {
        this.id = id;
    }

    public Resposta(Long id, String descricao, TipoPergunta tipoPergunta) {
        this.id = id;
        this.descricao = descricao;
        this.tipoPergunta = tipoPergunta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoPergunta getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(TipoPergunta tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }
    
}