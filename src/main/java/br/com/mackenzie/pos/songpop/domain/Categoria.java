/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

import br.com.mackenzie.pos.songpop.controle.domain.enumeracao.Pais;
import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.controle.util.Util;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Isaac
 */
public class Categoria {
    
    private Long id;
    private String nome;
    private ArrayList<Musica> musicas = new ArrayList();
    private Pais pais;

    public Categoria(Long id) {
        setId(id);
    }
    
    public Categoria(Long id, String nome, Pais pais) {
        setId(id);
        setNome(nome);
        setPais(pais);
    }
    
    public Categoria(Long id, String nome, ArrayList<Musica> musicas, Pais pais) {
        setId(id);
        setNome(nome);
        setMusicas(musicas);
        setPais(pais);
    }
    
    public Categoria(String nome, Musica musica, Pais pais) {
        setNome(nome);
        adicionarMusica(musica);
        setPais(pais);
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

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public void adicionarMusica(Musica musica) {
        if (Util.isNullOrVazio(getMusicas()))
            setMusicas(new ArrayList<Musica>());
        
        getMusicas().add(musica);
    }
    
    public String iDsMusicaLinha() {
        StringBuffer itens = new StringBuffer("");
        
        if (!Util.isNullOrVazio(getMusicas())) {
            for (int i = 0; i < getMusicas().size(); i++) {
                Musica musica = getMusicas().get(i);
                
                if (musica == null || musica.getId() == null) {
                    itens.append(" ");
                } else {
                    itens.append(musica.getId());
                }
                
                if ((i + 1) != getMusicas().size()) {
                    itens.append(Constantes.REGEX_ARRAY);
                    itens.append(" ");
                }
                
            }
        }
        
        return itens.toString();
    }
    
    public Collection<Musica> iDsLinhaParaMusica(String linha) {
        
        if (linha != null && linha.trim().length() != 0) {
            
            String[] ids = linha.split(Constantes.REGEX_ARRAY);
            
            for (int i = 0; i < ids.length; i++) {
                
                if (!"".trim().equalsIgnoreCase(ids[i].trim())) {
                    this.adicionarMusica(new Musica(Long.valueOf(ids[i])));
                } else {
                    this.adicionarMusica(null);
                }
            }
        }
        
        return this.getMusicas();
    }
    
}
