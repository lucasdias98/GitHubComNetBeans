package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteRemoverLivroBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        LivroBasico lb = em.find(LivroBasico.class, 3);

        em.getTransaction().begin();
        em.remove(lb);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
