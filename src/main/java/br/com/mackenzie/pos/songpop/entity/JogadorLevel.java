/**
 * 
 */
package br.com.mackenzie.pos.songpop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import br.com.mackenzie.pos.songpop.enumerador.Status;

/**
 * @author Isaac
 *
 */
@Entity
@Table(name = "tb_jogador_level")
public class JogadorLevel extends EntidadePersistente {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jogador_level", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="jogador"))
	private Long id;
	
	@Column(name = "moeda", nullable=false)
	private Integer moeda;
	
	@OneToOne(fetch = FetchType.LAZY, optional=true)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@PrimaryKeyJoinColumn
	private Jogador jogador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_level")
	private Level level;
	
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMoeda() {
		return moeda;
	}

	public void setMoeda(Integer moeda) {
		this.moeda = moeda;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	@Override
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
