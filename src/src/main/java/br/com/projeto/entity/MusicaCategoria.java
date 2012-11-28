/**
 * 
 */
package br.com.projeto.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Isaac, Waldir
 * 
 */

@Entity
@Table(name = "tb_musica_categoria")
@AssociationOverrides( {
		@AssociationOverride(name = "pk.musica", joinColumns = @JoinColumn(name = "id_musica")),
		@AssociationOverride(name = "pk.categoria", joinColumns = @JoinColumn(name = "id_categoria")) })
public class MusicaCategoria implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MusicaCategoriaPK pk = new MusicaCategoriaPK();
	
//	@Column(name = "nota")
//	private Integer nota;
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MusicaCategoria that = (MusicaCategoria) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	@Transient
	public Musica getMusica() {
		return this.getPk().getMusica();
	}
	
	@Transient
	public Categoria getCategoria() {
		return this.getPk().getCategoria();
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	public MusicaCategoriaPK getPk() {
		return pk;
	}

	public void setPk(MusicaCategoriaPK pk) {
		this.pk = pk;
	}

//	public Integer getNota() {
//		return nota;
//	}
//
//	public void setNota(Integer nota) {
//		this.nota = nota;
//	}
}