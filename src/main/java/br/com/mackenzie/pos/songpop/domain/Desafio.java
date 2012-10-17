/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.StatusDesafio;
import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.TipoPergunta;
import br.com.mackenzie.pos.songpop.controle.util.Constantes;

/**
 *
 * @author Isaac
 */
public class Desafio {
    
    private Long id;
    private long dataInicio;
    private StatusDesafio statusDesafio;
    private ItemDesafio[] itemDesafio = new ItemDesafio[5];
    private Categoria categoria;
    private Jogador desafiante;
    private Jogador desafiado;

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

    public long getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(long dataInicio) {
        this.dataInicio = dataInicio;
    }

    public StatusDesafio getStatusDesafio() {
        return statusDesafio;
    }

    public void setStatusDesafio(StatusDesafio statusDesafio) {
        this.statusDesafio = statusDesafio;
    }

    public ItemDesafio[] getItemDesafio() {
        return itemDesafio;
    }

    public void setItemDesafio(ItemDesafio[] itemDesafio) {
        this.itemDesafio = itemDesafio;
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

    public void adicionarItemDesafio (ItemDesafio itemDesafio) {
    
    }
    
    public String iDsItemDesafioLinha() {
        StringBuffer itens = new StringBuffer("");
        
        if (getItemDesafio() != null) {
            for (int i = 0; i < getItemDesafio().length; i++) {
                ItemDesafio itemDesafio = getItemDesafio()[i];
                
                if (itemDesafio == null || itemDesafio.getId() == null) {
                    itens.append(" ");
                } else {
                    itens.append(itemDesafio.getId());
                }
                
                if ((i + 1) != getItemDesafio().length) {
                    itens.append(Constantes.REGEX_ARRAY);
                    itens.append(" ");
                }
                
            }
        }
        
        return itens.toString();
    }
    
    public ItemDesafio[] iDsLinhaParaItemDesafio(String linha) {
        
        if (linha != null && linha.trim().length() != 0) {
            
            String[] ids = linha.split(Constantes.REGEX_ARRAY);
            
            for (int i = 0; i < ids.length; i++) {
                
                if (!"".trim().equalsIgnoreCase(ids[i].trim())) {
                    this.getItemDesafio()[i] = new ItemDesafio(Long.valueOf(ids[i]));
                } else {
                    this.getItemDesafio()[i] = null;
                }
            }
        }
        
        return this.getItemDesafio();
    }
}