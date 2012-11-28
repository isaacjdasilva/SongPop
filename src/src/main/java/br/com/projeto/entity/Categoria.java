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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import br.com.projeto.enumerador.Pais;

/**
 *
 * @author Isaac, Waldir
 */
@Entity  
@Table(name = "tb_categoria")
@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize=1)
public class Categoria extends EntidadePersistente {
    
	private static final long serialVersionUID = 1L;

	@Id  
	@Column(name = "id_categoria", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_categoria")
    private Long id;
	
	@Column(name = "nome", nullable=false, length = 30)
    private String nome;
	
	@Column(name = "quantidade_moeda", nullable=false)
	private Integer quantidadeMoeda;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.categoria", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
			@Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
				org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	private Set<MusicaCategoria> musicaCategorias = new HashSet<MusicaCategoria>(0);

	@Column(name="pais")
	@Enumerated(EnumType.ORDINAL)
	private Pais pais;
	
	public Categoria() {
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

    public Set<MusicaCategoria> getMusicaCategorias() {
		return musicaCategorias;
	}

	public void setMusicaCategorias(Set<MusicaCategoria> musicaCategorias) {
		this.musicaCategorias = musicaCategorias;
	}

	public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public void adicionarMusicaCategoria(MusicaCategoria musicaCategoria) {
        getMusicaCategorias().add(musicaCategoria);
    }

	public Integer getQuantidadeMoeda() {
		return quantidadeMoeda;
	}

	public void setQuantidadeMoeda(Integer quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
	}
}