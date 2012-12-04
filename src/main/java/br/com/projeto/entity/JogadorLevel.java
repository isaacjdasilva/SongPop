/**
 * 
 */
package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author Isaac, Waldir
 *
 */

@Entity
@Table(name = "tb_jogador_level")
@SequenceGenerator(name = "seq_jogador_level", sequenceName = "seq_jogador_level", allocationSize=1)
public class JogadorLevel extends EntidadePersistente {

	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_jogador_level")  
	@Column(name = "id_jogador_level", nullable=false)
    private Long id;

	@Column(name = "moeda", nullable=false)
	private Integer moeda;

	@OneToOne(fetch = FetchType.LAZY, optional=true)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Jogador jogador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_level")
	private Level level;

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
}