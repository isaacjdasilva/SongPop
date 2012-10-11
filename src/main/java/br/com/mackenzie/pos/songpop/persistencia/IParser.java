/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia;

import java.util.Collection;

/**
 *
 * @author Isaac
 */
public interface IParser<T> {
    
    public String objetoParaLinha(T objeto);
    public Collection<String> objetosParaLinhas(Collection<T> objetos);
    
    public T linhaParaObjeto(String linha);
    public Collection<T> linhasParaObjetos(Collection<String> linhas);
    
}