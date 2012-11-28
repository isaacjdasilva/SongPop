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
import br.com.projeto.entity.User;
import br.com.projeto.enumerador.Sexo;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class JogadorDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JogadorDao dao;
	
	@Autowired
	private UserDao uDao;

	@Autowired
	private DriverManagerDataSource ds;
	
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
    	jogador.setNome("Jogador 1");
    	jogador.setDataNascimento(new Date(1986, 6, 1));
    	jogador.setEmail("aaaaa@teste.com");
    	jogador.setSexo(Sexo.MASCULINO);
    	jogador.setStatus(Status.ATIVO);
    	jogador.setUser(user);
		dao.create(jogador);
		return jogador;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		Jogador jogador = criarJogador();
		dao.create(jogador);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		Jogador jogador = criarJogador();
		Jogador jogador2 = (Jogador) dao.find(jogador.getId(), jogador);
		assertNotNull(jogador2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		Jogador jogador = criarJogador();
		jogador.setDataNascimento(new Date(1986, 6, 5));
		jogador.setStatus(Status.ATIVO);
		dao.update(jogador);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		Jogador jogador = criarJogador();
		dao.delete(jogador);
		System.out.println("testDelete Concluido!");
	}
}