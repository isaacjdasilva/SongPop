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
import br.com.projeto.entity.Musica;
import br.com.projeto.enumerador.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class MusicaDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MusicaDao dao;

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

	private Musica criarMusica() {
		
		Artista artista = criarArtista();
		
		Musica musica = new Musica();
		musica.setNome("Não Tem Hora e Nem Lugar");
		musica.setArtista(artista);
		musica.setPrimeraParte("Quando eu te conheci minha vida mudou pra melhor");
		musica.setSegundaParte("Eu voltei a sorrir, um tempo atrás eu tava na pior");
		musica.setStatus(Status.ATIVO);
		dao.create(musica);
		
		return musica;
	}

	@Test
	@Rollback(true)
	public void testCreate() throws SQLException {
		Musica musica = criarMusica();
		dao.create(musica);
		System.out.println("testCreate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testRetrieve() throws SQLException {
		Musica musica = criarMusica();
		Musica musica2 = (Musica) dao.find(musica.getId(), musica);
		assertNotNull(musica2);
		System.out.println("testRetrieve Concluido!");
	}

	@Test
	@Rollback(true)
	public void testUpdate() throws SQLException {
		Musica musica = criarMusica();
		musica.setSegundaParte("Não sei o que eu fiz pra merecer tanto carinho assim");
		dao.update(musica);
		System.out.println("testUpdate Concluido!");
	}

	@Test
	@Rollback(true)
	public void testDelete() throws SQLException {
		Musica musica = criarMusica();
		dao.delete(musica);
		System.out.println("testDelete Concluido!");
	}
}