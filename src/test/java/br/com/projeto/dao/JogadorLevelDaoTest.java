package br.com.projeto.dao;

import static junit.framework.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.JogadorLevel;
import br.com.projeto.entity.Level;
import br.com.projeto.entity.User;
import br.com.projeto.enumerador.Sexo;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class JogadorLevelDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JogadorLevelDao dao;

	@Autowired
	private DriverManagerDataSource ds;
	
	@Autowired
	private LevelDao lDao;
	
	@Autowired
	private JogadorDao jDao;
	
	@Autowired
	private UserDao uDao;

	private User criarUser() {
    	User user = new User();
    	user.setLogin("teste 1");
    	user.setPassword("Teste 1");
    	user.setStatus(Status.ATIVO);
    	user.setInsertDate(new Date());
    	uDao.create(user);
		return user;
	}
	
	private Jogador criarJogador() {
		
		User user = criarUser();
		
    	Jogador jogador = new Jogador();
    	jogador.setNome("Jogador 3");
    	jogador.setDataNascimento(new Date(1986, 6, 1));
    	jogador.setEmail("aaaaa@teste.com");
    	jogador.setSexo(Sexo.MASCULINO);
    	jogador.setStatus(Status.ATIVO);
    	jogador.setUser(user);
		jDao.create(jogador);
		return jogador;
	}

	private Level criarLevel() {
    	Level level = new Level();
    	level.setNomeLevel("Level 1");
    	level.setCodigoLevel(1);
    	level.setPontosMinimo(21);
    	level.setPontosMaximo(100);
    	level.setStatus(Status.ATIVO);
		lDao.create(level);
		return level;
	}

	private JogadorLevel criarJogadorLevel() {
		
		Level level = criarLevel();
		Jogador jogador = criarJogador();
		
		JogadorLevel jogadorLevel = new JogadorLevel();
		jogadorLevel.setMoeda(2323);
		jogadorLevel.setStatus(Status.ATIVO);
		jogadorLevel.setLevel(level);
		jogadorLevel.setJogador(jogador);
		
		dao.create(jogadorLevel);
		return jogadorLevel;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		JogadorLevel jogadorLevel = criarJogadorLevel();
		dao.create(jogadorLevel);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		JogadorLevel jogadorLevel = criarJogadorLevel();
		JogadorLevel jogadorLevel2 = (JogadorLevel) dao.find(jogadorLevel.getId(), jogadorLevel);
		assertNotNull(jogadorLevel2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		JogadorLevel jogadorLevel = criarJogadorLevel();
		jogadorLevel.setMoeda(23100);
		jogadorLevel.setStatus(Status.INATIVO);
		dao.update(jogadorLevel);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		JogadorLevel jogadorLevel = criarJogadorLevel();
		dao.delete(jogadorLevel);
		System.out.println("testDelete Concluido!");
	}
}