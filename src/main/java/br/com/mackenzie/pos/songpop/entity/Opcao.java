package br.com.mackenzie.pos.songpop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.mackenzie.pos.songpop.enumerador.Status;
import br.com.mackenzie.pos.songpop.enumerador.TipoPergunta;

/**
 * @author Isaac
 *
 */
@Entity  
@Table(name = "tb_opcao")
@SequenceGenerator(name = "seq_opcao", sequenceName = "seq_opcao")
public class Opcao extends EntidadePersistente {
	
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_opcao")  
	@Column(name = "id_opcao", nullable=false)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_musica")
    private Musica musica;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_artista")
    private Artista artista;
    
	@Column(name="tipo_pergunta")
	@Enumerated(EnumType.ORDINAL)
    private TipoPergunta tipoPergunta;
	
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

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

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public TipoPergunta getTipoPergunta() {
		return tipoPergunta;
	}

	public void setTipoPergunta(TipoPergunta tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}
	
	@Override
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}