package br.com.projeto.web.adm;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.projeto.entity.Artista;
import br.com.projeto.service.ArtistaService;

/**
 * @author Isaac, Waldir
 *
 */
@Controller
@Scope("request")
public class ArtistaController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArtistaService artistaService;

	private List<Artista> artistas;
	 
    public List<Artista> getProdutos(){
        if(artistas == null){
        	artistas = artistaService.findAll();
        }
        return artistas;
    }
}