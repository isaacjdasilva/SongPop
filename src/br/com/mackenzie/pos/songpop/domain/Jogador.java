/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.controle.util.Util;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Isaac
 */
public class Jogador {
    
    private Long id;
    private String nome;
    private int pontos;
    private ArrayList<Desafio> desafios = new ArrayList<Desafio>();

    public Jogador(Long id) {
        this.id = id;
    }

    public Jogador(Long id, String nome, int pontos) {
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
    }
    
    public void adicionarDesafio(Desafio desafio) {
    
        if (Util.isNullOrVazio(getDesafios()))
            setDesafios(new ArrayList<Desafio>());
        
        getDesafios().add(desafio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public ArrayList<Desafio> getDesafios() {
        return desafios;
    }

    public void setDesafios(ArrayList<Desafio> desafios) {
        this.desafios = desafios;
    }
    
    public String iDsDesafioLinha() {
        StringBuffer itens = new StringBuffer("");
        
        if (!Util.isNullOrVazio(getDesafios())) {
            for (int i = 0; i < getDesafios().size(); i++) {
                Desafio desafio = getDesafios().get(i);
                
                if (desafio == null || desafio.getId() == null) {
                    itens.append(" ");
                } else {
                    itens.append(desafio.getId());
                }
                
                if ((i + 1) != getDesafios().size()) {
                    itens.append(Constantes.REGEX_ARRAY);
                    itens.append(" ");
                }
                
            }
        }
        
        return itens.toString();
    }
    
    public Collection<Desafio> iDsLinhaParaDesafio(String linha) {
        
        if (linha != null && linha.trim().length() != 0) {
            
            String[] ids = linha.split(Constantes.REGEX_ARRAY);
            
            for (int i = 0; i < ids.length; i++) {
                
                if (!"".trim().equalsIgnoreCase(ids[i].trim())) {
                    this.adicionarDesafio(new Desafio(Long.valueOf(ids[i])));
                } else {
                    this.adicionarDesafio(null);
                }
            }
        }
        
        return this.getDesafios();
    }
    
}
