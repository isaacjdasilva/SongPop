/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Jogador;
import br.com.mackenzie.pos.songpop.domain.Resposta;
import br.com.mackenzie.pos.songpop.domain.RespostaJogadorItemDesafio;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class RespostaJogadorItemDesafioDAO extends CrudBasico<RespostaJogadorItemDesafio> {

    public RespostaJogadorItemDesafioDAO() {
        setNomeArquivo(Constantes.BD_RESPOSTA_JOGADOR_ITEM_DESAFIO_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(RespostaJogadorItemDesafio t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(RespostaJogadorItemDesafio t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(RespostaJogadorItemDesafio objeto) {
        StringBuffer linha = new StringBuffer("");
        
        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getJogador().getId()).append(Constantes.REGEX);
        linha.append(objeto.getPontosGanhos()).append(Constantes.REGEX);
        linha.append(objeto.getRespota().getId()).append(Constantes.REGEX);
        linha.append(objeto.getTempoFinalResposta());
        
        return linha.toString();
    }

    @Override
    public RespostaJogadorItemDesafio linhaParaObjeto(String linha) {
        
        String[] registro = linha.split(Constantes.REGEX);
        
        RespostaJogadorItemDesafio respostaJogadorItemDesafio = new RespostaJogadorItemDesafio(Long.valueOf(registro[0].trim()));
        respostaJogadorItemDesafio.setJogador(new Jogador(Long.valueOf(registro[1].trim())));
        respostaJogadorItemDesafio.setPontosGanhos(Integer.parseInt(registro[2]));
        respostaJogadorItemDesafio.setRespota(new Resposta(Long.valueOf(registro[3].trim())));
        respostaJogadorItemDesafio.setTempoFinalResposta(Long.valueOf(registro[4].trim()));
        
        return respostaJogadorItemDesafio;
    }
}