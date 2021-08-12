package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Livraria liv = new Livraria();
        
        liv.setNome("Estrela");
        liv.setSite("www.livrariaestrela.com.br");
        
        em.getTransaction().begin();
        em.persist(liv);
        em.getTransaction().commit();   
        em.close();
        emf.close();
    }
    
}
