/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;
import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.ItemDesafio;
import br.com.mackenzie.pos.songpop.domain.Musica;
import br.com.mackenzie.pos.songpop.domain.Resposta;
import br.com.mackenzie.pos.songpop.domain.RespostaJogadorItemDesafio;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class ItemDesafioDAO extends CrudBasico<ItemDesafio> {

    public ItemDesafioDAO() {
        setNomeArquivo(Constantes.BD_ITEM_DESAFIO_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(ItemDesafio t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(ItemDesafio t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(ItemDesafio objeto) {
        StringBuffer linha = new StringBuffer("");

        if (objeto != null) {
            linha.append(objeto.getId()).append(Constantes.REGEX);
            linha.append(objeto.getMusica().getId()).append(Constantes.REGEX);
            linha.append(objeto.getTipoPergunta().getCodigo()).append(Constantes.REGEX);
            linha.append(objeto.getRespostaCorreta().getId()).append(Constantes.REGEX);

            if (objeto.getRespostaJogadorDesafianteItemDesafio() != null) {
                linha.append(objeto.getRespostaJogadorDesafianteItemDesafio().getId()).append(Constantes.REGEX);
            } else {
                linha.append(" ").append(Constantes.REGEX);
            }

            if (objeto.getRespostaJogadorDesafiadoItemDesafio() != null) {
                linha.append(objeto.getRespostaJogadorDesafiadoItemDesafio().getId());
            } else {
                linha.append(" ");
            }
        }

        return linha.toString();
    }

    @Override
    public ItemDesafio linhaParaObjeto(String linha) {

        String[] registro = linha.split(Constantes.REGEX);

        ItemDesafio itemDesafio = new ItemDesafio(Long.valueOf(registro[0].trim()));
        itemDesafio.setMusica(new Musica(Long.valueOf(registro[1].trim())));
        itemDesafio.setTipoPergunta(TipoPergunta.fromValue(Integer.valueOf(registro[2].trim())));
        itemDesafio.setRespostaCorreta(new Resposta(Long.valueOf(registro[3].trim())));
        itemDesafio.setRespostaJogadorDesafianteItemDesafio(new RespostaJogadorItemDesafio(Long.valueOf(registro[4].trim())));
        itemDesafio.setRespostaJogadorDesafiadoItemDesafio(new RespostaJogadorItemDesafio(Long.valueOf(registro[5].trim())));

        return itemDesafio;
    }
}
