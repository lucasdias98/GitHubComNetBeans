package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Formato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteRemoverFormato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Formato f = em.find(Formato.class, 2);

        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
