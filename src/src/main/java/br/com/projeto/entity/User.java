package br.com.projeto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize=1)
public class User  extends EntidadePersistente {
 
	private static final long serialVersionUID = 1L;

	@Id  
	@Column(name = "id_usuario", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_usuario")
	private Long id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String password;
	
	@Column(name = "data_insercao")
	private Date insertDate;
	
	@Column(name = "data_atualizacao")
	private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
