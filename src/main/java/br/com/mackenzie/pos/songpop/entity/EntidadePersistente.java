package br.com.mackenzie.pos.songpop.entity;

import java.io.Serializable;

import br.com.mackenzie.pos.songpop.enumerador.Status;

@SuppressWarnings("serial")
public abstract class EntidadePersistente implements Serializable {
	
	public abstract Long getId();
	public abstract Status getStatus();
}
