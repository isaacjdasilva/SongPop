/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Jogador;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class JogadorDAO extends CrudBasico<Jogador> {

    public JogadorDAO() {
        setNomeArquivo(Constantes.BD_JOGADOR_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(Jogador t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Jogador t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(Jogador objeto) {
        StringBuffer linha = new StringBuffer("");
        
        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getNome()).append(Constantes.REGEX);
        linha.append(objeto.getPontos()).append(Constantes.REGEX);
        linha.append(objeto.iDsDesafioLinha());
                
        return linha.toString();
    }

    @Override
    public Jogador linhaParaObjeto(String linha) {
        String[] registro = linha.split(Constantes.REGEX);
        
        Jogador jogador = new Jogador(Long.valueOf(registro[0].trim()));
        jogador.setNome(registro[1]);
        jogador.setPontos(Integer.valueOf(registro[2]));
        jogador.iDsLinhaParaDesafio(registro[3]);
        
        return jogador;
    }
}
