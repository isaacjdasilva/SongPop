/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.controle.domain.enumeracao;

/**
 *
 * @author Isaac
 */
public enum Pais {
    
    BRASIL("Brasil", "BR", 1), EUA("Estados Unidos", "EUA", 2);
    
    private String nome;
    private String sigla;
    private int codigo;
    
    private Pais(String nome, String sigla, int codigo) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
    
    public static Pais fromValue(int codigo){
        
        for (Pais pais : Pais.values()) {
            if (pais.getCodigo() == codigo) {
                return pais;
            }
        }
        
        return null;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}