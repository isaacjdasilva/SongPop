/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.projeto.enumerador.Sexo;
import br.com.projeto.util.Util;

/**
 *
 * @author Isaac, Waldir
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
	
	@Column(name = "dt_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="sexo")
	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

	@Column(name = "email", nullable=false, length = 35)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
    private User user;
	
    
	@OneToOne(mappedBy = "jogador", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_jogador")
    private JogadorLevel jogadorLevel;
    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_jogador_desafio", joinColumns = { @JoinColumn(name = "id_jogador") }, inverseJoinColumns = { @JoinColumn(name = "id_desafio") })
    private List<Desafio> desafios = new ArrayList<Desafio>();
	
    public Jogador(Long id) {
        this.id = id;
    }

    public Jogador(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Jogador() {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}