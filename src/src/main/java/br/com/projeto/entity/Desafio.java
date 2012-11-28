/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.projeto.enumerador.StatusDesafio;
import br.com.projeto.util.Util;

/**
 *
 * @author Isaac, Waldir
 */
@Entity
@Table(name = "tb_desafio")
@SequenceGenerator(name = "seq_desafio", sequenceName = "seq_desafio", allocationSize=1)
public class Desafio extends EntidadePersistente {
    
	private static final long serialVersionUID = 1L;
    
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_desafio")  
	@Column(name = "id_desafio", nullable=false)
    private Long id;
	
	@Column(name = "dt_inicio", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
	
	@Column(name = "dt_fim", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
	
	@Column(name="status_desafio", nullable = false)
	@Enumerated(EnumType.ORDINAL)
    private StatusDesafio statusDesafio;
    
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_desafio")
	@org.hibernate.annotations.Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
//  @org.hibernate.annotations.IndexColumn(name = "posicao_item_desafio")
	private Set<ItemDesafio> itensDesafios = new HashSet<ItemDesafio>(5);
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_desafiante", nullable = false)
    private Jogador desafiante;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_desafiado", nullable = false)
    private Jogador desafiado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vencedor")
    private Jogador vencedor;
	
    public Desafio() {
    }
    
    public Desafio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public StatusDesafio getStatusDesafio() {
        return statusDesafio;
    }

    public void setStatusDesafio(StatusDesafio statusDesafio) {
        this.statusDesafio = statusDesafio;
    }

    public Set<ItemDesafio> getItensDesafios() {
		return itensDesafios;
	}
    
    public void setItensDesafios(Set<ItemDesafio> itensDesafios) {
    	this.itensDesafios = itensDesafios;
    }

	public ItemDesafio getItensDesafiosByPosicao(int posicao) {
		
		int i = 0;
		while (this.getItensDesafios().iterator().hasNext()) {
			
			ItemDesafio itemDesafio = (ItemDesafio) this.getItensDesafios().iterator().next();
			
			if (i == posicao) {
				return itemDesafio;
			}
			
			i++;
		}
		
		return null;
	}

	public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Jogador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Jogador desafiante) {
        this.desafiante = desafiante;
    }

    public Jogador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Jogador desafiado) {
        this.desafiado = desafiado;
    }
    
    public Jogador getVencedor() {
		return vencedor;
	}

	public void setVencedor(Jogador vencedor) {
		this.vencedor = vencedor;
	}

	public void adicionarItemDesafio(ItemDesafio itemDesafio) {
    	if (Util.isNullOrVazio(this.getItensDesafios())) {
    		this.setItensDesafios(new HashSet<ItemDesafio>(5));
    	}
    	
    	this.getItensDesafios().add(itemDesafio);
    }
}