/**
 * 
 */
package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Isaac, Waldir
 *
 */
@Entity
@Table(name = "tb_level")
@SequenceGenerator(name = "seq_level", sequenceName = "seq_level", allocationSize=1)
public class Level extends EntidadePersistente {

	private static final long serialVersionUID = 1L;
	
	public static final Long ID_LEVEL_ZERO = new Long(100);
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_level")  
	@Column(name = "id_level", nullable=false)
	private Long id;
	
	@Column(name = "codigo_level", nullable=false)
	private Integer codigoLevel;
	
	@Column(name = "nome_level", nullable=false, length = 20)
	private String nomeLevel;
	
	@Column(name = "pontos_minimo", nullable=false)
	private Integer pontosMinimo;
	
	@Column(name = "pontos_maximo", nullable=false)
	private Integer pontosMaximo;

	public Level(Long id) {
		this.id = id;
	}

	public Level() {
	}

	/* (non-Javadoc)
	 * @see br.com.mackenzie.pos.songpop.domain.EntidadePersistente#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoLevel() {
		return codigoLevel;
	}

	public void setCodigoLevel(Integer codigoLevel) {
		this.codigoLevel = codigoLevel;
	}

	public String getNomeLevel() {
		return nomeLevel;
	}

	public void setNomeLevel(String nomeLevel) {
		this.nomeLevel = nomeLevel;
	}

	public Integer getPontosMinimo() {
		return pontosMinimo;
	}

	public void setPontosMinimo(Integer pontosMinimo) {
		this.pontosMinimo = pontosMinimo;
	}

	public Integer getPontosMaximo() {
		return pontosMaximo;
	}

	public void setPontosMaximo(Integer pontosMaximo) {
		this.pontosMaximo = pontosMaximo;
	}
}