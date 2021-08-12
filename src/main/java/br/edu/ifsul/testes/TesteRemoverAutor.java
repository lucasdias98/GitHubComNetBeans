
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteRemoverAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Autor a = em.find(Autor.class, 3);

        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
