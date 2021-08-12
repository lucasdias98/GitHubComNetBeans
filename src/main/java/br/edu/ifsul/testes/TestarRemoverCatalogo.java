package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Catalogo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestarRemoverCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Catalogo cat = em.find(Catalogo.class, 3);

        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
