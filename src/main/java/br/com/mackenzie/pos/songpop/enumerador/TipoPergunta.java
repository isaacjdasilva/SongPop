/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.enumerador;

/**
 *
 * @author Isaac
 */
public enum TipoPergunta {
    MUSICA("Música", 1), ARTISTA("Artista", 2);
    
    private String descricao;
    private int codigo;

    private TipoPergunta(String descricao, int codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }
    
    public static TipoPergunta fromValue(int codigo){
        
        for (TipoPergunta tipoPergunta : TipoPergunta.values()) {
            if (tipoPergunta.getCodigo() == codigo) {
                return tipoPergunta;
            }
        }
        
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}