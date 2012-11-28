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

import br.com.projeto.entity.Categoria;
import br.com.projeto.enumerador.Pais;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class CategoriaDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CategoriaDao dao;

	@Autowired
	private DriverManagerDataSource ds;

	private Categoria criarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setNome("Samba");
		categoria.setPais(Pais.BRASIL);
		categoria.setQuantidadeMoeda(344);
		categoria.setStatus(Status.ATIVO);
		dao.create(categoria);
		return categoria;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		Categoria categoria = criarCategoria();
		dao.create(categoria);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		Categoria categoria = criarCategoria();
		Categoria categoria2 = (Categoria) dao.find(categoria.getId(), categoria);
		assertNotNull(categoria2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		Categoria categoria = criarCategoria();
		categoria.setQuantidadeMoeda(100);
		dao.update(categoria);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		Categoria categoria = criarCategoria();
		dao.delete(categoria);
		System.out.println("testDelete Concluido!");
	}
}