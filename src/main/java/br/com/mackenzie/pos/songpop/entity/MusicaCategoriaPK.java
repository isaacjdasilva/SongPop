/**
 * 
 */
package br.com.mackenzie.pos.songpop.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import br.com.mackenzie.pos.songpop.enumerador.Status;

/**
 * @author Isaac
 * 
 */

@Embeddable
public class MusicaCategoriaPK extends EntidadePersistente {
	
	private static final long serialVersionUID = -5869094934725857817L;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Musica musica;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Categoria categoria;

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!(o instanceof MusicaCategoriaPK))
			return false;

		MusicaCategoriaPK that = (MusicaCategoriaPK) o;

		if (this.musica != null ? !this.musica.equals(that.musica)
				: that.musica != null)
			return false;
		if (this.categoria != null ? !this.categoria.equals(that.categoria)
				: that.categoria != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (this.categoria != null ? this.categoria.hashCode() : 0);
		result = 31 * result
				+ (this.musica != null ? this.musica.hashCode() : 0);
		return result;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}