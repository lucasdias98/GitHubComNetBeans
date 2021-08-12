package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteListarIdioma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        List<Idioma> lista = em.createQuery("from Idioma order by nome").getResultList();
        
        for(Idioma i: lista){
            System.out.println("ID: " + i.getId() + " Nome: "+ i.getNome() + " Sigla: " + i.getSigla());
        }
         
        em.close();
        emf.close();
    }
    
}
