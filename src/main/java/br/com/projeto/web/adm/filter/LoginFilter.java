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



public class LoginFilter implements Filter {
	
	private static String LOGIN_URI = "/adm/login.jsp";
	private static String LOGGED_IN_URI = "/adm";
	private static String[] AUTHORIZED_URIS = new String[] {
		LOGIN_URI,
		"/adm/login.action",
		"/adm/css/",
		"/adm/img/",
		"/adm/js/"
	};

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute(Constants.USER_ADMIN) == null) {
			
			boolean authorized = false;
			
			for (int i = 0; i < AUTHORIZED_URIS.length; i++) {
				if(request.getRequestURI().startsWith(AUTHORIZED_URIS[i])) {
					authorized = true;
					break;
				}
			}
			
			if(!authorized) {
				String parameters="";
				if(StringUtils.isNotBlank(request.getQueryString())){
					parameters="$10"+request.getQueryString().replaceAll("&","\\$11");
				}
				response.sendRedirect(LOGIN_URI+"?requestedUrl="+request.getRequestURI()+parameters);
				return;
			}
			
		} else if( request.getRequestURI().replace("/", "").equals(LOGIN_URI.replaceAll("/", "")) ) {
			response.sendRedirect(LOGGED_IN_URI);
			return;
		}
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {
	}

}
