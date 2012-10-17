/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.controle.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Isaac
 */
public final class Util {

    private Util() {
    }
    
    public static boolean isNullOrEmpty(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean isNullOrVazio(Collection colecao) {
        if (colecao == null || colecao.isEmpty()) {
            return true;
        }

        return false;
    }

    public static LinkedList<Integer> gerarNumerosAleatoriosComIntervalo(int quantidadeDeNumeros, int valorMaximo) {
        LinkedList<Integer> lista = new LinkedList();

        while (lista.size() != quantidadeDeNumeros) {
            Integer numeroGerado = (int) (Math.random() * valorMaximo);

            if (!lista.contains(numeroGerado)) {
                lista.add(numeroGerado);
            }
        }

        return lista;
    }

    public static int gerarNumerosAleatorios(int valorMaximo) {
        return (int) (Math.random() * (valorMaximo)) + 1;
    }
    
    public static Collection removerNullColecao(Collection colecao) {
        
        if (!isNullOrVazio(colecao)) {
            
            Iterator interator = colecao.iterator();
            
            while (interator.hasNext()) {
                Object object = interator.next();
                
                if (object instanceof String) {
                    if (object == null) {
                        interator.remove();
                    } else if (Util.isNullOrEmpty((String)object)) {
                        interator.remove();
                    }
                }
                
            }
        }

        return colecao;
    }
}
