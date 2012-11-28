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
import br.com.projeto.entity.Opcao;
import br.com.projeto.enumerador.Status;
import br.com.projeto.enumerador.TipoPergunta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class OpcaoDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private OpcaoDao dao;

	@Autowired
	private DriverManagerDataSource ds;
	
	@Autowired
	private ArtistaDao aDao;

	private Artista criarArtista() {
		Artista artista = new Artista();
		artista.setNome("Exaltasamba");
		artista.setStatus(Status.ATIVO);
		aDao.create(artista);
		return artista;
	}

	private Opcao criarOpcao() {
		
		Artista artista = criarArtista();
		
		Opcao opcao = new Opcao();
		opcao.setTipoPergunta(TipoPergunta.ARTISTA);
		opcao.setArtista(artista);
		opcao.setStatus(Status.ATIVO);
		dao.create(opcao);
		return opcao;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		Opcao opcao = criarOpcao();
		dao.create(opcao);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		Opcao opcao = criarOpcao();
		Opcao opcao2 = (Opcao) dao.find(opcao.getId(), opcao);
		assertNotNull(opcao2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		Opcao opcao = criarOpcao();
		opcao.setStatus(Status.INATIVO);
		dao.update(opcao);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		Opcao opcao = criarOpcao();
		dao.delete(opcao);
		System.out.println("testDelete Concluido!");
	}
}