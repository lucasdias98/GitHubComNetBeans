package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Formato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListarFormato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        List<Formato> lista = em.createQuery("from Formato order by nome").getResultList();
        
        for(Formato f: lista){
            System.out.println("ID: " + f.getId() + " Nome: "+ f.getNome());
        }
         
        em.close();
        emf.close();
    }
    
}