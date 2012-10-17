/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.StatusDesafio;
import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;
import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Desafio;
import br.com.mackenzie.pos.songpop.domain.Jogador;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class DesafioDAO extends CrudBasico<Desafio> {

    public DesafioDAO() {
        setNomeArquivo(Constantes.BD_DESAFIO_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(Desafio t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Desafio t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(Desafio objeto) {
        StringBuffer linha = new StringBuffer("");
        
        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getDesafiante().getId()).append(Constantes.REGEX);
        linha.append(objeto.getDesafiado().getId()).append(Constantes.REGEX);
        linha.append(objeto.getDataInicio()).append(Constantes.REGEX);
        linha.append(objeto.getStatusDesafio().getCodigo()).append(Constantes.REGEX);
        linha.append(objeto.iDsItemDesafioLinha());
        
        return linha.toString();
    }

    @Override
    public Desafio linhaParaObjeto(String linha) {
        
        String[] registro = linha.split(Constantes.REGEX);
        
        Desafio desafio = new Desafio(Long.valueOf(registro[0].trim()));
        desafio.setDesafiante(new Jogador(Long.valueOf(registro[1].trim())));
        desafio.setDesafiado(new Jogador(Long.valueOf(registro[2].trim())));
        desafio.setDataInicio(Long.parseLong(registro[3].trim()));
        desafio.setStatusDesafio(StatusDesafio.fromValue(Integer.parseInt(registro[4].trim())));
        desafio.iDsLinhaParaItemDesafio(registro[5].trim());

        return desafio;
    }
}
