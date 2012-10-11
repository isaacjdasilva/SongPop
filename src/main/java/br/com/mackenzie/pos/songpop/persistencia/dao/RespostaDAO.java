/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;
import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Resposta;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class RespostaDAO extends CrudBasico<Resposta> {

    public RespostaDAO() {
        setNomeArquivo(Constantes.BD_RESPOSTA_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(Resposta t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Resposta t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(Resposta objeto) {
        StringBuffer linha = new StringBuffer("");
        
        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getDescricao()).append(Constantes.REGEX);
        linha.append(objeto.getTipoPergunta().getCodigo());
        
        return linha.toString();
    }

    @Override
    public Resposta linhaParaObjeto(String linha) {
        
        String[] registro = linha.split(Constantes.REGEX);
        
        Resposta resposta = new Resposta(Long.valueOf(registro[0].trim()));
        resposta.setDescricao(registro[1]);
        resposta.setTipoPergunta(TipoPergunta.fromValue(Integer.parseInt(registro[2].trim())));
        
        return resposta;
    }
}
