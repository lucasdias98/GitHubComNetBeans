/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirAutores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
            LivroBasico livro = em.find(LivroBasico.class, "3211223");
        Autor autor = em.find(Autor.class, 2);
        Autor autor2 = em.find(Autor.class, 3);
        
        livro.getAutores().add(autor);
        livro.getAutores().add(autor2);
        
        em.getTransaction().begin();
        em.merge(livro);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
