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
public class Musica {

    private Long id;
    private String nome;
    private String primeraParte;
    private String segundaParte;
    private Artista artista;
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();

    public Musica() {
    }

    public Musica(Long id) {
        this.id = id;
    }

    public Musica(String nome, String primeraParte, String segundaParte, Artista artista) {
        this.nome = nome;
        this.primeraParte = primeraParte;
        this.segundaParte = segundaParte;
        this.artista = artista;
    }

    public Musica(Long id, String nome, String primeraParte, String segundaParte, Artista artista) {
        this.id = id;
        this.nome = nome;
        this.primeraParte = primeraParte;
        this.segundaParte = segundaParte;
        this.artista = artista;
    }

    public Musica(Long id, String nome, String primeraParte, String segundaParte, ArrayList<Categoria> categorias, Artista artista) {
        setId(id);
        setNome(nome);
        setPrimeraParte(primeraParte);
        setSegundaParte(segundaParte);
        setCategorias(categorias);
        setArtista(artista);
    }

    public Musica(Long id, String nome, String primeraParte, String segundaParte, Artista artista, Categoria categoria) {
        setId(id);
        setNome(nome);
        setPrimeraParte(primeraParte);
        setSegundaParte(segundaParte);
        setArtista(artista);
        adicionarCategoria(categoria);
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

    public String getPrimeraParte() {
        return primeraParte;
    }

    public void setPrimeraParte(String primeraParte) {
        this.primeraParte = primeraParte;
    }

    public String getSegundaParte() {
        return segundaParte;
    }

    public void setSegundaParte(String segundaParte) {
        this.segundaParte = segundaParte;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        if (Util.isNullOrVazio(getCategorias())) {
            setCategorias(new ArrayList<Categoria>());
        }

        getCategorias().add(categoria);
    }

    public String iDsCategoriaLinha() {
        StringBuffer itens = new StringBuffer("");

        if (!Util.isNullOrVazio(getCategorias())) {
            for (int i = 0; i < getCategorias().size(); i++) {
                Categoria categoria = getCategorias().get(i);

                if (categoria == null || categoria.getId() == null) {
                    itens.append(" ");
                } else {
                    itens.append(categoria.getId());
                }

                if ((i + 1) != getCategorias().size()) {
                    itens.append(Constantes.REGEX_ARRAY);
                    itens.append(" ");
                }

            }
        }

        return itens.toString();
    }

    public Collection<Categoria> iDsLinhaParaCategoria(String linha) {

        if (linha != null && linha.trim().length() != 0) {

            StringTokenizer ids = new StringTokenizer(linha, Constantes.REGEX_ARRAY);

            while (ids.hasMoreTokens()) {
                final String valor = ids.nextToken();
                
                if (!"".trim().equalsIgnoreCase(valor.trim())) {
                    this.adicionarCategoria(new Categoria(Long.valueOf(valor)));
                } else {
                    this.adicionarCategoria(null);
                }
            }

        }

        return this.getCategorias();
    }
}