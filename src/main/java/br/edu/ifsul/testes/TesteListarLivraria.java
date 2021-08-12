/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livraria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TesteListarLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        List<Livraria> lista = em.createQuery("from Livraria order by nome").getResultList();
        
        for(Livraria l: lista){
            System.out.println("ID: " + l.getId() + " Nome: "+ l.getNome() + " Site: " + l.getSite());
        }
         
        em.close();
        emf.close();
    }
    
}
