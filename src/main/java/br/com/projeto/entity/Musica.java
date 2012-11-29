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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Isaac, Waldir
 */
@Entity  
@Table(name = "tb_musica")
@SequenceGenerator(name = "seq_musica", sequenceName = "seq_musica")
public class Musica extends EntidadePersistente {
    
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_musica")  
	@Column(name = "id_musica", nullable=false)
    private Long id;
	
	@Column(name = "nome", nullable=false, length = 35)
    private String nome;

	@Column(name = "primera_parte", nullable=false, length = 50)
	private String primeraParte;
    
	@Column(name = "segunda_parte", nullable=false, length = 50)
	private String segundaParte;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_artista", nullable = false, updatable = false, insertable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Artista artista;
    
	// Aqui estamos dizendo como a entidade deve ser carregada
	// e o que deve acontecer caso alguma coisa seja deletada ou atualizada.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.musica", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
			@Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
				org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	private Set<MusicaCategoria> musicaCategorias = new HashSet<MusicaCategoria>(0);

    public Musica() {
    }

    public Musica(Long id) {
        this.id = id;
    }

//    public Musica(String nome, String primeraParte, String segundaParte, Artista artista) {
//        this.nome = nome;
//        this.primeraParte = primeraParte;
//        this.segundaParte = segundaParte;
//        this.artista = artista;
//    }

//    public Musica(Long id, String nome, String primeraParte, String segundaParte, Artista artista) {
//        this.id = id;
//        this.nome = nome;
//        this.primeraParte = primeraParte;
//        this.segundaParte = segundaParte;
//        this.artista = artista;
//    }
//
//    public Musica(Long id, String nome, String primeraParte, String segundaParte, 
//    		Set<MusicaCategoria> musicaCategorias, Artista artista) {
//        setId(id);
//        setNome(nome);
//        setPrimeraParte(primeraParte);
//        setSegundaParte(segundaParte);
//        setMusicaCategorias(musicaCategorias);
//        setArtista(artista);
//    }
//
//    public Musica(Long id, String nome, String primeraParte, String segundaParte, Artista artista, MusicaCategoria musicaCategoria) {
//        setId(id);
//        setNome(nome);
//        setPrimeraParte(primeraParte);
//        setSegundaParte(segundaParte);
//        setArtista(artista);
//        adicionarMusicaCategoria(musicaCategoria);
//    }

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

    public String getPrimeraParte() {
        return primeraParte;
    }

    public void setPrimeraParte(String primeraParte) {
        this.primeraParte = primeraParte;
    }

    public String getSegundaParte() {
        return segundaParte;
    }

    public void setSegundaParte(String segundaParte) {
        this.segundaParte = segundaParte;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Set<MusicaCategoria> getMusicaCategorias() {
        return musicaCategorias;
    }

    public void setMusicaCategorias(Set<MusicaCategoria> musicaCategorias) {
        this.musicaCategorias = musicaCategorias;
    }

    public void adicionarMusicaCategoria(MusicaCategoria musicaCategoria) {
        getMusicaCategorias().add(musicaCategoria);
    }
}