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

import br.com.projeto.entity.Artista;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ArtistaDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ArtistaDao dao;

	@Autowired
	private DriverManagerDataSource ds;

	private Artista criarArtista() {
		Artista artista = new Artista();
		artista.setNome("Exaltasamba");
		artista.setStatus(Status.ATIVO);
		dao.create(artista);
		return artista;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		Artista artista = criarArtista();
		dao.create(artista);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		Artista artista = criarArtista();
		Artista artista2 = (Artista) dao.find(artista.getId(), artista);
		assertNotNull(artista2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		Artista artista = criarArtista();
		artista.setNome("Roberto Carlos");
		dao.update(artista);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		Artista artista = criarArtista();
		dao.delete(artista);
		System.out.println("testDelete Concluido!");
	}
}