package br.com.projeto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import br.com.projeto.enumerador.Status;


@MappedSuperclass
public abstract class EntidadePersistente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public abstract Long getId();
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}