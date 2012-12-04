/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.projeto.enumerador.TipoPergunta;
import br.com.projeto.util.Util;

/**
 *
 * @author Isaac, Waldir
 */
@Entity  
@Table(name = "tb_item_desafio")
@SequenceGenerator(name = "seq_item_desafio", sequenceName = "seq_item_desafio", allocationSize=1)
public class ItemDesafio extends EntidadePersistente {
    
	private static final long serialVersionUID = 1L;
    
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_item_desafio")  
	@Column(name = "id_item_desafio", nullable=false)
    private Long id;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_musica")
    private Musica musica;
    
	@Column(name="tipo_pergunta")
	@Enumerated(EnumType.ORDINAL)
    private TipoPergunta tipoPergunta;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resposta_correta")
    private Resposta respostaCorreta;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resposta_desafiante")
    private RespostaJogadorItemDesafio respostaDesafiante;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resposta_desafiado")
	private RespostaJogadorItemDesafio respostaDesafiado;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_desafio", nullable = false, updatable = false, insertable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Desafio desafio;
    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_item_desafio_opcao", joinColumns = { @JoinColumn(name = "id_item_desafio") }, inverseJoinColumns = { @JoinColumn(name = "id_opcao") })
    private Set<Opcao> opcoes = new HashSet<Opcao>(4);
	
    public ItemDesafio() {
    }
    
    public ItemDesafio(Long id) {
        this.id = id;
    }

    public ItemDesafio(Long id, Musica musica, TipoPergunta tipoPergunta, Resposta respostaCorreta, RespostaJogadorItemDesafio respostaDesafiante, RespostaJogadorItemDesafio respostaDesafiado) {
        this.id = id;
        this.musica = musica;
        this.tipoPergunta = tipoPergunta;
        this.respostaCorreta = respostaCorreta;
        this.respostaDesafiante = respostaDesafiante;
        this.respostaDesafiado = respostaDesafiado;
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

    public RespostaJogadorItemDesafio getRespostaDesafiante() {
		return respostaDesafiante;
	}

	public void setRespostaDesafiante(RespostaJogadorItemDesafio respostaDesafiante) {
		this.respostaDesafiante = respostaDesafiante;
	}

	public RespostaJogadorItemDesafio getRespostaDesafiado() {
		return respostaDesafiado;
	}

	public void setRespostaDesafiado(RespostaJogadorItemDesafio respostaDesafiado) {
		this.respostaDesafiado = respostaDesafiado;
	}

	public Resposta getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(Resposta respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    
    public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}

    public Set<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(Set<Opcao> opcoes) {
		this.opcoes = opcoes;
	}

	public void adicionarOpcoes(Opcao opcao) {
        if (Util.isNullOrVazio(getOpcoes())) {
            this.setOpcoes(new HashSet<Opcao>(4));
        }
        
        this.getOpcoes().add(opcao);
    }
}