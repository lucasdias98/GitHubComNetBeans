package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteAlterarLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
                 
        Livraria livra = em.find(Livraria.class, 2);
        
        livra.setNome("Delta");
        livra.setSite("www.livrariadelta.com.br");
        
        em.getTransaction().begin();
        em.merge(livra);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
