package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirLivroBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        LivroBasico livro = new LivroBasico();
        
        livro.setISBN("123123");
        livro.setTitulo("IT - A coisa");
        livro.setEditora("SUMA");
        livro.setResumo("Um palhaço da pesada vai inferniar a vida da mulecada");
        em.getTransaction().begin();
        
        em.persist(livro);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
