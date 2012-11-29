/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.enumerador;

/**
 *
 * @author Isaac, Waldir
 */
public enum Status {
    
	INATIVO(0), ATIVO(1);
	
	private Integer codigo;

	private Status(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public static Status fromValue(Integer value){

		for (Status pais : Status.values()) {
			if (pais.getCodigo().equals(value)) {
				return pais;
			}
		}

		throw new IllegalArgumentException("Status invalido: " + value);
	}
	
	public Integer toValue(){
    	return getCodigo();
    }
}