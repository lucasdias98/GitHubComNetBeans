/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteAlterarAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Autor a = em.find(Autor.class, 2);
                 
        a.setNome("Karina Ricci");
        a.setBibliografia("Ela é muito serelepe");
        
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
