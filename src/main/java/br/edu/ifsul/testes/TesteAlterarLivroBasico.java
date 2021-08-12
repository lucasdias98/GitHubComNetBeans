/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteAlterarLivroBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        LivroBasico lb = em.find(LivroBasico.class, "123123");
                 
        lb.setTitulo("Pokemon");
        lb.setResumo("Pikachu, eu escolho você!");
        lb.setEditora("Mangaka");
    
        
        em.getTransaction().begin();
        em.merge(lb);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
