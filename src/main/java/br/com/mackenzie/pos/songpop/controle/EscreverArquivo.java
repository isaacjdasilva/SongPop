/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.controle;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Isaac
 */
public class EscreverArquivo {

    public static void main(String[] args) {
        EscreverArquivo escreverArquivo = new EscreverArquivo();
        escreverArquivo.adicionaPessoa();
    }

    public boolean adicionaPessoa() {
        try { // Todas as operações de IO podem gerar exceções
// Instanciamos um PrintWriter associado ao FileWriter
            FileWriter fw = new FileWriter(Constantes.CAMINHO_BD + Constantes.BD_ITEM_DESAFIO_TXT, true);
// true pois vamos adicionar dados ao nosso arquivo
            BufferedWriter out = new BufferedWriter(fw);
// Escrevendo os números inteiros (atributos da árvore)
            out.newLine();
            out.write("Test"); // Escrevendo o código
            out.write("OK"); // Escrevendo a idade
// Fechando o stream (importante)
            out.close();
            fw.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
