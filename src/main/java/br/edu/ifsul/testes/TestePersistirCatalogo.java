package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Livraria livra = em.find(Livraria.class, 1);
        Catalogo catalog = new Catalogo();
        
        catalog.setNome("Aventura");
        catalog.setDescricao("Melhores de aventura");
        
        livra.adicionarCatalogo(catalog);
        
        em.getTransaction().begin();
        //em.persist(catal);
        em.merge(livra);
        em.getTransaction().commit();   
        em.close();
        emf.close();
    }
    
}
