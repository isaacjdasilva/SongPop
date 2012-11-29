/**
 * 
 */
package br.com.projeto.service;

/**
 * @author Isaac, Waldir
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.JogadorDao;
import br.com.projeto.entity.Jogador;

@Service
public class JogadorService {

    @Autowired
    private JogadorDao dao;

	public void createJogador(Jogador jogador) {
		dao.create(jogador);
	}
}