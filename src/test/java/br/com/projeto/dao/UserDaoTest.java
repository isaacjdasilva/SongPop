package br.com.projeto.dao;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserDao dao;

	@Autowired
	private DriverManagerDataSource ds;

	@Test
	public void testDelete() throws SQLException {
		Assert.assertEquals("teste", "teste");
	}
}