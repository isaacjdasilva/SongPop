/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.Pais;
import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Categoria;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class CategoriaDAO extends CrudBasico<Categoria> {

    public CategoriaDAO() {
        setNomeArquivo(Constantes.BD_CATEGORIA_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(Categoria t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Categoria t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(Categoria objeto) {
        StringBuffer linha = new StringBuffer("");
        
        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getNome()).append(Constantes.REGEX);
        linha.append(objeto.getPais().getCodigo()).append(Constantes.REGEX);
        linha.append(objeto.iDsMusicaLinha());
        
        return linha.toString();
    }

    @Override
    public Categoria linhaParaObjeto(String linha) {
        
        String[] registro = linha.split(Constantes.REGEX);
        
        Categoria categoria = new Categoria(Long.valueOf(registro[0].trim()));
        categoria.setNome(registro[1]); 
        categoria.setPais(Pais.fromValue(Integer.parseInt(registro[2].trim())));
        categoria.iDsLinhaParaMusica(registro[3]);
        
        return categoria;
    }
}
