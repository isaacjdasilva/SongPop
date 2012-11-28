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

import br.com.projeto.entity.User;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserDao dao;

	@Autowired
	private DriverManagerDataSource ds;

	private User criarUser() {
    	User user = new User();
    	user.setLogin("teste");
    	user.setPassword("Teste");
    	user.setStatus(Status.ATIVO);
    	user.setInsertDate(new Date());
		dao.create(user);
		return user;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		User user = criarUser();
		dao.create(user);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		User user = criarUser();
		User user2 = (User) dao.find(user.getId(), user);
		assertNotNull(user2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		User user = criarUser();
		user.setStatus(Status.INATIVO);
		dao.update(user);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		User user = criarUser();
		dao.delete(user);
		System.out.println("testDelete Concluido!");
	}
}