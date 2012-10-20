package br.com.projeto.util;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
	
	private static Properties P;
	
	public static final String SITE_URL = "site.url";
	public static final String DEFAULT_MAIL_FROM = "default.mail.from";

	public static final String CONTEUDO_ARQUIVOS_DIR = "images.conteudo.dir";
	
	
	static {
		P = new Properties();
		try {
			P.load(ApplicationProperties.class.getResourceAsStream("/application.properties"));
			P.load(ApplicationProperties.class.getResourceAsStream("/application-env.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String get(String key) {
		return P.getProperty(key);
	}

	public static int getAsInt(String key) {
		return Integer.parseInt(get(key));
	}

}
