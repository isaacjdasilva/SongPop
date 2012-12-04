/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.enumerador;

/**
 *
 * @author Isaac, Waldir
 */
public enum Pais {
    
	BRASIL(1), EUA(2), INGLATERRA(3);
	
	private Integer codigo;

	private Pais(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	public static Pais fromValue(Integer value){

		for (Pais pais : Pais.values()) {
			if (pais.getCodigo().equals(value)) {
				return pais;
			}
		}

		throw new IllegalArgumentException("País invalido: " + value);
	}
	
	public Integer toValue(){
    	return getCodigo();
    }
}