/**
 * 
 */
package br.com.projeto.service;

/**
 * @author Isaac, Waldir
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.OpcaoDao;

@Service
public class OpcaoService {

    @Autowired
    private OpcaoDao dao;
}