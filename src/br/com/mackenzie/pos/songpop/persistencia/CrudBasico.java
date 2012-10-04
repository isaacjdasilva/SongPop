/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia;

import br.com.mackenzie.pos.songpop.controle.util.Util;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Isaac
 */
public abstract class CrudBasico<T> implements IParser<T> {
    
    private BaseDeDados baseDeDados;
    private String nomeArquivo;
    private long sequence;
    
    public abstract void remover(T t);
    public abstract void alterar(T t);
    
    public long sequenceAtual(){
        return getBaseDeDados().proximaSequence() - 1;
    }
    
    public long proximaSequence(){
        return getBaseDeDados().proximaSequence();
    }
    
    public void inserir(T t) {
        String novaLinha = objetoParaLinha(t);
        getBaseDeDados().escreverLinhasEmArquivo(novaLinha);
    }
    
    public void inserirColecao(Collection<T> ts) {
        if (!Util.isNullOrVazio(ts)) {
            for (T t : ts) {
                inserir(t);
            }
        }
    }
    
    public void inserirArrays(T[] tArray) {
        if (tArray != null && tArray.length != 0) {
            for (T t : tArray) {
                inserir(t);
            }
        }
    }
    
    public Collection<T> pesquisarTudo() {
        ArrayList<String> linhas = (ArrayList<String>) getBaseDeDados().recuperarLinhasArquivo();
        
        Collection<T> colecao = new ArrayList<T>();
        
        if (!Util.isNullOrVazio(linhas)) {
            for (String linha : linhas) {
                colecao.add(this.linhaParaObjeto(linha));
            }
        }
        
        return colecao;
    }
    
    public T obterPorId(Long id) {
        return linhaParaObjeto(recuperarPorId(id));
    }
    
    /**
     *
     * @param coluna
     * @param conteudo
     * @param conteudoArray
     * @param contemArray
     * @return
     */
    public Collection<T> recuperarColecaoPorColuna(int coluna, String conteudo, String conteudoArray, boolean contemArray) {
        return linhasParaObjetos(this.getBaseDeDados().recuperarColecaoPorColuna(coluna, conteudo, conteudoArray, contemArray));
    }
    
    /**
     *
     * @param objetos
     * @return
     */
    public Collection<String> objetosParaLinhas(Collection<T> objetos) {
        Collection<String>  linhas = new ArrayList<String>();
        
        if (!Util.isNullOrVazio(objetos)) {
            
            for (T t : objetos) {
                linhas.add(objetoParaLinha(t));
            }
        }
        
        return linhas;
    }

    public Collection<T> linhasParaObjetos(Collection<String> linhas) {
        Collection<T>  ts = new ArrayList<T>();
        
        if (!Util.isNullOrVazio(linhas)) {
            
            for (String linha : linhas) {
                ts.add(linhaParaObjeto(linha));
            }
        }
        
        return ts;
    }
    
    public T recuperarPorIdColuna(int coluna, Long id) {
        String linha = this.getBaseDeDados().recuperarPorId(coluna, id);
        return linhaParaObjeto(linha);
    }
    
    public String recuperarPorId(Long id) {
        return this.getBaseDeDados().recuperarPorId(0, id);
    }
    
    public String recuperarPorId(int coluna, Long id) {
        return this.getBaseDeDados().recuperarPorId(coluna, id);
    }
    
    public Collection<String> recuperarColecaoPorId(Long id) {
        return this.getBaseDeDados().recuperarColecaoPorId(0, id);
    }
    
    public Collection<String> recuperarColecaoPorColuna(int coluna, Long id) {
        return this.getBaseDeDados().recuperarColecaoPorId(coluna, id);
    }
    
    public void inicializarBaseDeDados() {
        this.setBaseDeDados(new BaseDeDados(this.getNomeArquivo()));
    }

    /**
     * @return the baseDeDados
     */
    public BaseDeDados getBaseDeDados() {
        return baseDeDados;
    }

    /**
     * @param baseDeDados the baseDeDados to set
     */
    public void setBaseDeDados(BaseDeDados baseDeDados) {
        this.baseDeDados = baseDeDados;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
