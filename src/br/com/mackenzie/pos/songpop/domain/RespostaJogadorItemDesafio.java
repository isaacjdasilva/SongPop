/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

/**
 *
 * @author Isaac
 */
public class RespostaJogadorItemDesafio {
    
    private Long id;
    private Resposta respota;
    private long tempoFinalResposta;
    private int pontosGanhos;
    private Jogador jogador;
    
    public RespostaJogadorItemDesafio() {}

    public RespostaJogadorItemDesafio(Long id) {
        this.id = id;
    }

    public RespostaJogadorItemDesafio(Long id, Resposta respota, long tempoFinalRespota, int pontosGanhos, Jogador jogador) {
        this.id = id;
        this.respota = respota;
        this.tempoFinalResposta = tempoFinalRespota;
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

    public long getTempoFinalResposta() {
        return tempoFinalResposta;
    }

    public void setTempoFinalResposta(long tempoFinalResposta) {
        this.tempoFinalResposta = tempoFinalResposta;
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
}
