package br.com.projeto.web.adm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import br.com.projeto.util.Constants;
 


public class JogadorFilter implements Filter {
	 
	private static String LOGIN_URI = "/jogo/index.action";
	private static String LOGGED_IN_URI = "/jogo/index.action";
	private static String[] AUTHORIZED_URIS = new String[] {
		LOGIN_URI,
		"/jogo/login.action",
		"/jogo/cadastro.action",
		"/jogo/css/",
		"/jogo/img/",
		"/jogo/js/",
		"/jogo/adm"
	};


	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(true);

		if(request.getRequestURI().startsWith("/index.jsp")) {
			response.sendRedirect(LOGGED_IN_URI);
			return;
		}

		if(session.getAttribute(Constants.USER_JOGADOR) == null) {

			boolean authorized = false;

			for (int i = 0; i < AUTHORIZED_URIS.length; i++) {
				if(request.getRequestURI().startsWith(AUTHORIZED_URIS[i])) {
					authorized = true;
					break;
				}
			}

			if(!authorized) {
				response.sendRedirect(LOGIN_URI);
				return;
			}

		}

		chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
