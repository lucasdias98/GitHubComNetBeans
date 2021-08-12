/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class TestePersistirLivro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWPU");
        EntityManager em = emf.createEntityManager();
        
        Catalogo catalogo = em.find(Catalogo.class, 18);
        
        Livro livro = new Livro();
        
        livro.setISBN("009212");
        livro.setTitulo("Merlin");
        livro.setResumo("O mago dos dragões");
        livro.setEditora("Panini");
        livro.setCodigoBarras("8899232123");
        livro.setDataPuclicacao(Calendar.getInstance());
        livro.setNumeroPaginas(500);
        livro.setAtivo(true);
        livro.setValor(70.00);
        
        livro.setFormato(em.find(Formato.class, 1));
        livro.setIdioma(em.find(Idioma.class, 1));
        
        catalogo.adicionarLivro(livro);
        
        em.getTransaction().begin();
        //em.persist(livro);
        em.merge(catalogo);
        em.getTransaction().commit();   
        em.close();
        emf.close();
    }
    
}
