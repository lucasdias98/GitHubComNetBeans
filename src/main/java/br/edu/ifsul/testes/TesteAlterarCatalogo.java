/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TesteAlterarCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Livraria livra = em.find(Livraria.class, 1);
        Catalogo cat = em.find(Catalogo.class, 1);
                 
        cat.setNome("Drama");
        cat.setDescricao("Melhores de drama");
        
        livra.adicionarCatalogo(cat);
        
        
        em.getTransaction().begin();
        em.merge(livra);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
