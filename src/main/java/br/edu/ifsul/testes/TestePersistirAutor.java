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
public class TestePersistirAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Autor autor = new Autor();
        autor.setNome("Stephen King");
        autor.setBibliografia("O cara é brabo demais.");
        
        Autor autor2 = new Autor();
        autor2.setNome("Rick Riordan");
        autor2.setBibliografia("O cara é mitológico.");
        
        em.getTransaction().begin();
        em.persist(autor);
        em.persist(autor2);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
