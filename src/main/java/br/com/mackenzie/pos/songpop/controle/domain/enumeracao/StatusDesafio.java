/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.controle.domain.enumeracao;

/**
 *
 * @author Isaac
 */
public enum StatusDesafio {

    AGUARDANDO_OPONENTE("Aguardando Oponente", 1), PROCESSANDO("Processando", 2), FINALIZADO("Finalizado", 3);

    private String descricao;
    private int codigo;

    private StatusDesafio(String descricao, int codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }
    
    public static StatusDesafio fromValue(int codigo){
        
        for (StatusDesafio statusDesafio : StatusDesafio.values()) {
            if (statusDesafio.getCodigo() == codigo) {
                return statusDesafio;
            }
        }
        
        return null;
    }

    /**
     * Get the value of descricao
     *
     * @return the value of descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set the value of descricao
     *
     * @param descricao new value of descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @param codigo new value of codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}