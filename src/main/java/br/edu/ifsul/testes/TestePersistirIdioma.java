package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirIdioma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Idioma idioma = new Idioma();
        
        idioma.setNome("asaaa");
        idioma.setSigla("as");
        
        em.getTransaction().begin();
        em.persist(idioma);
        em.getTransaction().commit();
        em.close();
        emf.close();

    
    }
    
}
