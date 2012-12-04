package br.com.projeto.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.User;
import br.com.projeto.util.Constants;
import br.com.projeto.util.CryptUtils;

/**
 * @author Andre Santos
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserDao dao;

	@Autowired
	private GenericDao genericDao;
	
	public User login(String login,String password){

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		 
		User user = dao.get(login, CryptUtils.md5(password));
		
		if (user == null) {
			return null;
		}
		
		session.setAttribute(Constants.USER_ADMIN, user);
		
		return user;

	}
    
	public void create(User objeto) {
		genericDao.insert(objeto);
	}

	public void update(User objeto) {
		genericDao.update(objeto);
	}

	public void delete(User objeto) {
		genericDao.remove(objeto.getClass(), objeto.getId());
	}
	
	public Object find(final Long id, User objeto) {
		return (Object) genericDao.findById(objeto.getClass(), id);
	}

	public boolean existeUsuarioComLogin(String login) {
		return dao.existeUsuarioComLogin(login);
	}
	
	public User obterPorLogin(String login) {
		return dao.obterPorLogin(login);
	}
}
