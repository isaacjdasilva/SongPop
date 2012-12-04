/**
 * 
 */
package br.com.projeto.service;

/**
 * @author Isaac, Waldir
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogadorDao;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.JogadorLevel;
import br.com.projeto.entity.Level;
import br.com.projeto.entity.User;
import br.com.projeto.enumerador.Status;

@Service
public class JogadorService {

    @Autowired
    private JogadorDao dao;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private LevelService levelService;
    
    @Autowired
    private JogadorLevelService jogadorLevelService;
    
    @Autowired
    private GenericDao genericDao;

	public void createJogador(Jogador jogador) {
		
		Level level = (Level) levelService.recuperarMenorLevel();
		
		if (level == null) {
//			Erro
		}
		
		criarJogadorLevel(jogador, level);
		userService.create(jogador.getUser());
		
		User user = userService.obterPorLogin(jogador.getUser().getLogin());
		
		jogador.setUser(user);
		
		genericDao.insert(jogador);
		
		jogadorLevelService.create(jogador.getJogadorLevel());
		
	}
	
	public boolean existeJogadorComEmail(String email) {
		return dao.existeJogadorComEmail(email);
	}

	public boolean existeJogadorComLoginOuEmail(String login, String email) {
		
		boolean existeComEmail = existeJogadorComEmail(email);
		
		if (existeComEmail) {
			return existeComEmail;
		}
		
		return userService.existeUsuarioComLogin(login);
	}
	
	/**
	 * @param jogador
	 * @param level
	 * @return
	 */
	private JogadorLevel criarJogadorLevel(Jogador jogador, Level level) {
		
		JogadorLevel jogadorLevel = new JogadorLevel();
		jogadorLevel.setMoeda(0);
		jogadorLevel.setStatus(Status.ATIVO);
		jogadorLevel.setLevel(level);
		jogador.setJogadorLevel(jogadorLevel);
		jogadorLevel.setJogador(jogador);
		
		return jogadorLevel;
	}
	
	public List<Jogador> jogadoresAtivo(Long id) {
		return dao.jogadoresAtivo(id);
	}
	
	public void create(Jogador objeto) {
		dao.create(objeto);
	}

	public Jogador update(Jogador objeto) {
		return dao.update(objeto);
	}

	public void delete(Jogador objeto) {
		dao.delete(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) dao.find(id, objeto.getClass());
	}
	
}