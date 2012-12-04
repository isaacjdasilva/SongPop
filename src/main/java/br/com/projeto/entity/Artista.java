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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Isaac, Waldir
 */
@Entity
@Table(name = "tb_artista")
@SequenceGenerator(name = "seq_artista", sequenceName = "seq_artista", allocationSize=1)
public class Artista extends EntidadePersistente {
    
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_artista")  
	@Column(name = "id_artista", nullable=false)
    private Long id;
	
	@Column(name = "nome", nullable=false, length = 40)
    private String nome;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_artista")
	@org.hibernate.annotations.Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
//  @org.hibernate.annotations.IndexColumn(name = "posicao_musica")
	private Set<Musica> musicas = new HashSet<Musica>(0);
	
    public Artista(String nome, Set<Musica> musicas) {
        setNome(nome);
        setMusicas(musicas);
    }
    
    public Artista(String nome, Musica musica) {
        setNome(nome);
        adicionarMusica(musica);
    }
    
    public Artista(Long id, String nome) {
        setId(id);
        setNome(nome);
    }
    
    public Artista(Long id, String nome, Set<Musica> musicas) {
        setId(id);
        setNome(nome);
        setMusicas(musicas);
    }
    
    public Artista(Long id) {
        setId(id);
    }

    public Artista() {
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

    public Set<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(Set<Musica> musicas) {
		this.musicas = musicas;
	}

	public void adicionarMusica(Musica musica) {
        getMusicas().add(musica);
    }
}