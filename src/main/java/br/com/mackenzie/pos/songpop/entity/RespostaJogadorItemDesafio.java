/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.entity;

import java.util.Date;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.mackenzie.pos.songpop.enumerador.Status;

/**
 *
 * @author Isaac
 */
@Entity  
@Table(name = "tb_resposta_jogador")
@SequenceGenerator(name = "seq_resposta_jogador", sequenceName = "seq_resposta_jogador")
public class RespostaJogadorItemDesafio extends EntidadePersistente {
	
	private static final long serialVersionUID = 1L;
    
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_resposta_jogador")  
	@Column(name = "id_resposta_jogador", nullable=false)
    private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_respota")
	private Resposta respota;
	
	@Column(name = "dt_resposta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataResposta;
    
	@Column(name = "pontos_ganhos", nullable = false)
	private int pontosGanhos;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jogador")
    private Jogador jogador;
    
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;
    
    public RespostaJogadorItemDesafio() {}

    public RespostaJogadorItemDesafio(Long id) {
        this.id = id;
    }

    public RespostaJogadorItemDesafio(Long id, Resposta respota, Date dataResposta, int pontosGanhos, Jogador jogador) {
        this.id = id;
        this.respota = respota;
        this.dataResposta = dataResposta;
        this.pontosGanhos = pontosGanhos;
        this.jogador = jogador;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resposta getRespota() {
        return respota;
    }

    public void setRespota(Resposta respota) {
        this.respota = respota;
    }

    public Date getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(Date dataResposta) {
        this.dataResposta = dataResposta;
    }

    public int getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(int pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
	@Override
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
