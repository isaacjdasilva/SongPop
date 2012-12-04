/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.enumerador;

/**
 *
 * @author Isaac, Waldir
 */
public enum Sexo {
    
	FEMININO(1), MASCULINO(2);
	
	private Integer codigo;

	private Sexo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	public static Sexo fromValue(Integer value){

		for (Sexo pais : Sexo.values()) {
			if (pais.getCodigo().equals(value)) {
				return pais;
			}
		}

		throw new IllegalArgumentException("Sexo invalido: " + value);
	}
	
	public Integer toValue(){
    	return getCodigo();
    }
}