/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.mackenzie.pos.songpop.enumerador.Status;
import br.com.mackenzie.pos.songpop.util.Util;

/**
 *
 * @author Isaac
 */
@Entity  
@Table(name = "tb_jogador")
@SequenceGenerator(name = "seq_jogador", sequenceName = "seq_jogador", allocationSize=1)
public class Jogador extends EntidadePersistente {
    
	private static final long serialVersionUID = 1L;
    
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_jogador")  
	@Column(name = "id_jogador", nullable=false)
    private Long id;
	
	@Column(name = "nome", nullable=false, length = 35)
	private String nome;
    
	@OneToOne(mappedBy = "jogador", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_jogador")
    private JogadorLevel jogadorLevel;
    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_jogador_desafio", joinColumns = { @JoinColumn(name = "id_jogador") }, inverseJoinColumns = { @JoinColumn(name = "id_desafio") })
    private List<Desafio> desafios = new ArrayList<Desafio>();
	
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
    public Jogador(Long id) {
        this.id = id;
    }

    public Jogador(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void adicionarDesafio(Desafio desafio) {
    
        if (Util.isNullOrVazio(getDesafios()))
            setDesafios(new ArrayList<Desafio>());
        
        getDesafios().add(desafio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Desafio> getDesafios() {
        return desafios;
    }

    public void setDesafios(List<Desafio> desafios) {
        this.desafios = desafios;
    }

	public JogadorLevel getJogadorLevel() {
		return jogadorLevel;
	}

	public void setJogadorLevel(JogadorLevel jogadorLevel) {
		this.jogadorLevel = jogadorLevel;
	}
	
	@Override
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
}