/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.enumerador;

/**
 * 
 * @author Isaac
 */
public enum StatusDesafio {

	AGUARDANDO_OPONENTE(1), PROCESSANDO(2), FINALIZADO(3);

	private int codigo;

	private StatusDesafio(int codigo) {
		this.codigo = codigo;
	}

	public static StatusDesafio fromValue(int codigo) {

		for (StatusDesafio statusDesafio : StatusDesafio.values()) {
			if (statusDesafio.getCodigo() == codigo) {
				return statusDesafio;
			}
		}

		return null;
	}

	/**
	 * Get the value of codigo
	 * 
	 * @return the value of codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Set the value of codigo
	 * 
	 * @param codigo
	 *            new value of codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}