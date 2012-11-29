package br.com.projeto.dao;

import static junit.framework.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.projeto.entity.Level;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class LevelDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private LevelDao dao;

	@Autowired
	private DriverManagerDataSource ds;

	private Level criarLevel() {
    	Level level = new Level();
    	level.setNomeLevel("Level 1");
    	level.setCodigoLevel(1);
    	level.setPontosMinimo(21);
    	level.setPontosMaximo(100);
    	level.setStatus(Status.ATIVO);
		dao.create(level);
		return level;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		Level level = criarLevel();
		dao.create(level);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		Level level = criarLevel();
		Level level2 = (Level) dao.find(level.getId(), level);
		assertNotNull(level2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		Level level = criarLevel();
		level.setPontosMinimo(50);
		dao.update(level);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		Level level = criarLevel();
		dao.delete(level);
		System.out.println("testDelete Concluido!");
	}
}