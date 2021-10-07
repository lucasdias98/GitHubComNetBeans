package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirPermissao {
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        Permissao admin = new Permissao();
        admin.setNome("ADMINISTRADOR");
        admin.setDescricao("Permissão com poderes irrestritos");
        Permissao user = new Permissao();
        user.setNome("USUARIO");
        user.setDescricao("Permissão comum");        
        em.getTransaction().begin();
        em.persist(admin);
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
  
}
