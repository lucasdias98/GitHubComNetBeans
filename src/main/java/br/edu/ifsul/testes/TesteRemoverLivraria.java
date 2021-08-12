package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteRemoverLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Livraria l = em.find(Livraria.class, 3);

        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
