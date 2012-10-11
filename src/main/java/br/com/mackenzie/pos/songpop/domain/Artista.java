/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.domain;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.controle.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

/**
 *
 * @author Isaac
 */
public class Artista {
    
    private Long id;
    private String nome;
    private ArrayList<Musica> musicas = new ArrayList();

    public Artista(String nome, ArrayList<Musica> musicas) {
        setNome(nome);
        setMusicas(musicas);
    }
    
    public Artista(String nome, Musica musica) {
        setNome(nome);
        adicionarMusica(musica);
    }
    
    public Artista(Long id, String nome) {
        setId(id);
        setNome(nome);
    }
    
    public Artista(Long id, String nome, ArrayList<Musica> musicas) {
        setId(id);
        setNome(nome);
        setMusicas(musicas);
    }
    
    public Artista(Long id) {
        setId(id);
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
            
            StringTokenizer ids = new StringTokenizer(linha, Constantes.REGEX_ARRAY);
            
            if (ids.countTokens() == 0) {
            
            }
            
            while (ids.hasMoreTokens()) {
                final String valor = ids.nextToken();

                if (!"".trim().equalsIgnoreCase(valor.trim())) {
                    this.adicionarMusica(new Musica(Long.valueOf(valor)));
                } else {
                    this.adicionarMusica(null);
                }
            }
        }
        
        return this.getMusicas();
    }
    
}
